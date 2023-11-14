processGet = (productos) => {
	$("#tblProductos").removeClass("ocultar");
	$("#tblProductos").addClass("mostrar");
	
	let tbody = $("#tblProductos tbody");
	tbody.html("");
		
	if(productos.length <= 0){
		let tr = $("<tr></tr>");
		tr.append("<tr><td colspan = '3'>No se encontraron productos</td></tr>");
		tbody.append(tr);
	} 
	else {
		productos.forEach (producto => {
			tbody.append(createTr(producto));
		});
	}
}

createTd = (value) => {
	return $("<td>"+value+"</td>");
}

createTdEdit = (producto) => {
	let td = createTd("Editar");
	td.click(function () {
		showForm(producto);
	});
	return td;
}

createTdDelete = (producto) => {
	let td = createTd("Eliminar");
	td.click(function () {
		invokeDelete(producto);				
	});
	return td;
}

createTr = (producto) => {
	let tr = $("<tr></tr>");
	
	tr.append(createTd(producto.id));
	tr.append(createTd(producto.nombreProducto));
    tr.append(createTd(producto.precioVenta));
    tr.append(createTd(producto.stockMin));
    tr.append(createTd(producto.stockMax));
    tr.append(createTd(producto.existencia));
    tr.append(createTd(producto.estado));
    tr.append(createTd(producto.iva));
	
	tr.append(createTdEdit(producto));
	tr.append(createTdDelete(producto));
	
	return tr;
}

invokeDelete = (producto) => {
	console.log("producto que quiero eliminar ", producto);

	$.ajax({
		url: "http://localhost:8080/productos/"+ producto.id,
		//contentType: "application/json; charset=utf-8",
		success: function () {
			invokeGet();
			
			alert("Producto eliminado correctamente");
		}, 
		error: function (response) {
			console.log("respuesta error: ", response);
			alert("No fue posible eliminar el producto");
		},
		type: "DELETE"
	});
}

invokeGet = () => {		
	$.get( "http://localhost:8080/productos", processGet);
}

showForm = (data) => {
	$("#tblProductos").removeClass("mostrar");
	$("#tblProductos").addClass("ocultar");
	$("#frmProductos").removeClass("ocultar");
	$("#frmProductos").addClass("mostrar");
	console.log("Data For Form: ", data);
	
	// para editar
	if(!!data ) {
		$("#divIdProd").addClass("mostrar");
		$("#divIdProd").removeClass("ocultar");
		
		$("#id").val(data.id);
		$("#nombreProducto").val(data.nombreProducto);
        $("#precioVenta").val(data.precioVenta);
        $("#stockMin").val(data.stockMin);
        $("#stockMax").val(data.stockMax);
        $("#existencia").val(data.existencia);
        $("#estado").val(data.estado);
        $("#iva").val(data.iva);

	}
	else { // para mostrar
		$("#divIdProd").addClass("ocultar");
		$("#divIdProd").removeClass("mostrar");
		$("#id").val("");
		$("#nombreProducto").val("");
        $("#precioVenta").val("");
		$("#stockMin").val("");
        $("#stockMax").val("");
        $("#existencia").val("");
        $("#estado").val("");
        $("#iva").val("");
	}
}
    

sendForm = () => {
	if ($("#nombreProducto").val() == undefined || $("#nombreProducto").val() == null || $("#nombreProducto").val() == "") {
        alert("Por favor verifique el campo nombre");
        return;
    }
	if ($("#precioVenta").val() == undefined || $("#precioVenta").val() == null || $("#precioVenta").val() == "") {
        alert("Por favor verifique el campo precio venta");
        return;
    }
	if ($("#stockMin").val() == undefined || $("#stockMin").val() == null || $("#stockMin").val() == "") {
        alert("Por favor verifique el campo stockMin");
        return;
    }
	if ($("#stockMax").val() == undefined || $("#stockMax").val() == null || $("#stockMax").val() == "") {
        alert("Por favor verifique el campo stockMax");
        return;
    }
	if ($("#existencia").val() == undefined || $("#existencia").val() == null || $("#existencia").val() == "") {
        alert("Por favor verifique el campo existencia");
        return;
    }

    let data = {
        "nombreProducto": $("#nombreProducto").val(),
        "precioVenta": $("#precioVenta").val(),
		"stockMin": $("#stockMin").val(),
        "stockMax": $("#stockMax").val(),
        "existencia": $("#existencia").val(),
        "estado": $("#estado").val(),
        "iva": $("#iva").val()
    };
    console.log("Data ", data);

	let type = "POST";
	let message = "Producto registrado exitosamente";
	let actionType = ($("#id").val() == "") ? "agregar": "editar";
	
	if (actionType == "editar") {
		data.id = $("#id").val();
		type = "PUT";
		message = "Producto actualizado exitosamente";
	}
	
	console.log(data);
	$.ajax({
        url: "http://localhost:8080/productos",
        contentType: "application/json", //; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            console.log("Response"), //JSON.stringify(data));
            invokeGet();
            $("#frmProductos").removeClass("mostrar");
            $("#frmProductos").addClass("ocultar");

            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible " + actionType + " el producto");
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
		$("#frmProductos").removeClass("mostrar");
		$("#frmProductos").addClass("ocultar");
		$("#tblProductos").removeClass("ocultar");
		$("#tblProductos").addClass("mostrar");
	});
	
	invokeGet();
})

