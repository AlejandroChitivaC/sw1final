processGet = (ciudades) => {
	$("#tblCiudades").removeClass("ocultar");
	$("#tblCiudades").addClass("mostrar");
	
	let tbody = $("#tblCiudades tbody");
	tbody.html("");
		
	if(ciudades.length <= 0){
		let tr = $("<tr></tr>");
		tr.append("<tr><td colspan = '3'>No se encontraron ciudades</td></tr>");
		tbody.append(tr);
	} 
	else {
		ciudades.forEach (ciudad => {
			tbody.append(createTr(ciudad));
		});
	}
}

createTd = (value) => {
	return $("<td>"+value+"</td>");
}

createTdEdit = (ciudad) => {
	let td = createTd("Editar");
	td.click(function () {
		showForm(ciudad);
	});
	return td;
}

createTdDelete = (ciudad) => {
	let td = createTd("Eliminar");
	td.click(function () {
		invokeDelete(ciudad);				
	});
	return td;
}

createTr = (ciudad) => {
	let tr = $("<tr></tr>");
	
	tr.append(createTd(ciudad.id));
	tr.append(createTd(ciudad.nombre));
	tr.append(createTd(ciudad.pais.id));
	tr.append(createTd(ciudad.pais.nombre));
			
	tr.append(createTdEdit(ciudad));
	tr.append(createTdDelete(ciudad));
	
	return tr;
}

invokeDelete = (ciudad) => {
	console.log("ciudad que quiero eliminar ", ciudad);

	$.ajax({
		url: "http://localhost:8080/ciudad/"+ ciudad.id,
		success: function () {
			invokeGet();
			
			alert("Ciudad eliminada correctamente");
		}, 
		error: function (response) {
			console.log("respuesta error: ", response);
			alert("No fue posible eliminar la ciudad");
		},
		type: "DELETE"
	});
}	
	
invokeGet = () => {		
	$.get( "http://localhost:8080/ciudad", processGet);
}

showForm = (data) => {
	$("#tblCiudades").removeClass("mostrar");
	$("#tblCiudades").addClass("ocultar");
	$("#frmCiudades").removeClass("ocultar");
	$("#frmCiudades").addClass("mostrar");
	console.log("Data For Form: ", data);
	
	// para editar
	if(!!data) {
		$("#divId").addClass("mostrar");
		$("#divId").removeClass("ocultar");
		
		
		$("#id").val(data.id);
        $("#nombre").val(data.nombre);
        $("#id_pais").val(data.pais.id); 
        $("#paisNombre").val(data.pais.nombre); 
	}
	else { // para mostrar
		$("#divId").addClass("ocultar");
		$("#divId").removeClass("mostrar");
		$("#id").val("");
		$("#nombre").val("");
		$("#id_pais").val("");
		$("#paisNombre").val("");
	}
}

sendForm = () => {
    if ($("#nombre").val() == undefined || $("#nombre").val() == null || $("#nombre").val() == "") {
        alert("Por favor verifique el campo nombre");
        return;
    }

    let data = {
        "nombre": $("#nombre").val(),
        "id_pais": {
			"id_pais": $("#id_pais").val()
		}
    };

    let type = "POST";
    let message = "Ciudad registrada exitosamente";
    let actionType = ($("#id").val() == "") ? "agregar" : "editar";

    if (actionType == "editar") {
        data.id = $("#id").val();
        //type = "PUT";
        message = "Ciudad actualizada exitosamente";
    }

    console.log(data);
    $.ajax({
        url: "http://localhost:8080/ciudad",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            console.log("Response", JSON.stringify(data));
            invokeGet();
            $("#frmCiudades").removeClass("mostrar");
            $("#frmCiudades").addClass("ocultar");

            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible " + actionType + " la ciudad");
        },
        dataType: "json",
        type: type
    });
}

$(document).ready(function () {
	$("#btnAdd").click(function () {
		showForm(null);
	})
	
	$("#btnEnviar").click(sendForm);
	
	$("#btnCancelar").click(function () {
		$("#frmCiudades").removeClass("mostrar");
		$("#frmCiudades").addClass("ocultar");
		$("#tblCiudades").removeClass("ocultar");
		$("#tblCiudades").addClass("mostrar");
	});
	
	invokeGet();
})

