processGet = (clientes) => {
	$("#tblClientes").removeClass("ocultar");
	$("#tblClientes").addClass("mostrar");
	
	let tbody = $("#tblClientes tbody");
	tbody.html("");
		
	if(clientes.length <= 0){
		let tr = $("<tr></tr>");
		tr.append("<tr><td colspan = '3'>No se encontraron clientes</td></tr>");
		tbody.append(tr);
	} 
	else {
		clientes.forEach (cliente => {
			tbody.append(createTr(cliente));
		});
	}
}

createTd = (value) => {
	return $("<td>"+value+"</td>");
}

createTdEdit = (cliente) => {
	let td = createTd("Editar");
	td.click(function () {
		showForm(cliente);
	});
	return td;
}

createTdDelete = (cliente) => {
	let td = createTd("Eliminar");
	td.click(function () {
		invokeDelete(cliente);				
	});
	return td;
}

createTr = (cliente) => {
	let tr = $("<tr></tr>");
	
	tr.append(createTd(cliente.id));
	tr.append(createTd(cliente.nombre));
	tr.append(createTd(cliente.nit));
	tr.append(createTd(cliente.estado));
		
	tr.append(createTdEdit(cliente));
	tr.append(createTdDelete(cliente));
	
	return tr;
}

invokeDelete = (cliente) => {
	console.log("cliente que quiero eliminar ", cliente);

	$.ajax({
		url: "http://localhost:8080/clientes/"+ cliente.id,
		success: function () {
			invokeGet();
			
			alert("Cliente eliminado correctamente");
		}, 
		error: function (response) {
			console.log("respuesta error: ", response);
			alert("No fue posible eliminar el cliente");
		},
		type: "DELETE"
	});
}	
	
invokeGet = () => {		
	$.get( "http://localhost:8080/clientes", processGet);
}

showForm = (data) => {
	$("#tblClientes").removeClass("mostrar");
	$("#tblClientes").addClass("ocultar");
	$("#frmClientes").removeClass("ocultar");
	$("#frmClientes").addClass("mostrar");
	console.log("Data For Form: ", data);
	
	// para editar
	if(!!data) {
		$("#divId").addClass("mostrar");
		$("#divId").removeClass("ocultar");
		
		$("#id").val(data.id);
		$("#nombre").val(data.nombre);
		$("#nit").val(data.nit);
		$("#estado").val(data.estado);
	}
	else { // para mostrar
		$("#divId").addClass("ocultar");
		$("#divId").removeClass("mostrar");
		$("#id").val("");
		$("#nombre").val("");
		$("#nit").val("");
		$("#estado").val("");
	}
}

sendForm = () => {
	if($("#nombre").val() == undefined || $("#nombre").val() == null || $("#nombre").val() == "") {
		alert("Por favor verifique el campo nombre");
		return ;
	}
		
	let data = {"nombre": $("#nombre").val(), "nit": $("#nit").val(), "estado": $("#estado").val()};
	let type = "POST";
	let message = "Cliente registrado exitosamente";
	let actionType = ($("#id").val() == "") ? "agregar": "editar";
	
	if (actionType == "editar") {
		data.id = $("#id").val();
		type = "PUT";
		message = "Cliente actualizado exitosamente";
	}
	
	console.log(data);
	$.ajax({
		url: "http://localhost:8080/clientes", 
		contentType: "application/json",
		data: JSON.stringify(data), 
		success: function (response) {
			console.log(response);
			invokeGet();
			$("#frmClientes").removeClass("mostrar");
			$("#frmClientes").addClass("ocultar");
			
			alert(message);
		}, 
		error: function (response) {
			console.log("respuesta error: ", response);
			alert("No fue posible "+actionType+" el cliente");
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
		$("#frmClientes").removeClass("mostrar");
		$("#frmClientes").addClass("ocultar");
		$("#tblClientes").removeClass("ocultar");
		$("#tblClientes").addClass("mostrar");
	});
	
	invokeGet();
})

