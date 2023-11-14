processGetPaises = (paises) => {
	$("#tblPaises").removeClass("ocultar");
	$("#tblPaises").addClass("mostrar");
	
	let tbody = $("#tblPaises tbody");
	tbody.html("");
		
	if(paises.length <= 0){
		let tr = $("<tr></tr>");
		tr.append("<tr><td colspan = '3'>No se encontraron paises</td></tr>");
		tbody.append(tr);
	} 
	else {
		paises.forEach (pais => {
			tbody.append(createTrCountry(pais));
		});
	}
}

createTrCountry = (pais) => {
	let tr = $("<tr></tr>");
	let tdIdPais = $("<td>"+pais.id+"</td>");
	tr.append(tdIdPais);
	
	let tdPais = $("<td>"+pais.nombre+"</td>");
	tr.append(tdPais);
	
	let tdEdit = $("<td>Editar</td>");
	tdEdit.click(function () {
		showFormCountry(pais);
	});
	tr.append(tdEdit);
	
	let tdDelete = $("<td>Eliminar</td>");
	tdDelete.click(function () {
		invokeDelete(pais);				
	});
	tr.append(tdDelete);
	
	return tr;
}

invokeDelete = (pais) => {
	console.log("pais que quiero eliminar ", pais);

	$.ajax({
		url: "http://localhost:8080/paises/"+ pais.id,
		success: function () {
			getPaises();
			
			alert("Pais eliminado correctamente");
		}, 
		error: function (response) {
			console.log("respuesta error: ", response);
			alert("No fue posible eliminar el país");
		},
		type: "DELETE"
	});
}	
	
getPaises = () => {		
	$.get( "http://localhost:8080/paises", processGetPaises	);
}

showFormCountry = (data) => {
	$("#tblPaises").removeClass("mostrar");
	$("#tblPaises").addClass("ocultar");
	$("#frmPaises").removeClass("ocultar");
	$("#frmPaises").addClass("mostrar");
	console.log("Data For Form: ", data);
	
	// para editar
	if(!!data ) {
		$("#divId").addClass("mostrar");
		$("#divId").removeClass("ocultar");
		
		$("#id").val(data.id);
		$("#nombre").val(data.nombre);
	}
	else { // para mostrar
		$("#divId").addClass("ocultar");
		$("#divId").removeClass("mostrar");
		$("#id").val("");
		$("#nombre").val("");
	}
}

sendForm = () => {
	if($("#nombre").val() == undefined || $("#nombre").val() == null || $("#nombre").val() == "") {
		alert("Por favor verifique el campo nombre");
		return ;
	}
		
	let data = {"nombre": $("#nombre").val()};
	let type = "POST";
	let message = "Pais registrado exitosamente";
	let actionType = ($("#id").val() == "") ? "agregar": "editar";
	
	if (actionType == "editar") {
		data.id = $("#id").val();
		type = "PUT";
		message = "Pais actualizado exitosamente";
	}
	
	console.log(data);
	$.ajax({
		url: "http://localhost:8080/paises", 
		contentType: "application/json",
		data: JSON.stringify(data), 
		success: function (response) {
			console.log(response);
			getPaises();
			$("#frmPaises").removeClass("mostrar");
			$("#frmPaises").addClass("ocultar");
			
			alert(message);
		}, 
		error: function (response) {
			console.log("respuesta error: ", response);
			alert("No fue posible "+actionType+" el país");
		},
		dataType: "json", 
		type: type 
	});		
}

$(document).ready(function () {
	$("#btnAddCountry").click(function () {
		showFormCountry(null);
	})
	
	$("#btnEnviar").click(sendForm);
	
	$("#btnCancelar").click(function () {
		$("#frmPaises").removeClass("mostrar");
		$("#frmPaises").addClass("ocultar");
		$("#tblPaises").removeClass("ocultar");
		$("#tblPaises").addClass("mostrar");
	});
	
	getPaises();
})

