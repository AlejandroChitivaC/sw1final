processGet = (proveedores) => {
    $("#tblProveedores").removeClass("ocultar");
    $("#tblProveedores").addClass("mostrar");

    let tbody = $("#tblProveedores tbody");
    tbody.html("");

    if (proveedores.length <= 0) {
        let tr = $("<tr></tr>");
        tr.append("<tr><td colspan='3'>No se encontraron proveedores</td></tr>");
        tbody.append(tr);
    } else {
        proveedores.forEach(proveedor => {
            tbody.append(createTr(proveedor));
        });
    }
}

createTd = (value) => {
	return $("<td>"+value+"</td>");
}

createTr = (proveedor) => {
    let tr = $("<tr></tr>");

    tr.append(createTd(proveedor.id));
    tr.append(createTd(proveedor.ciudad.id));
    tr.append(createTd(proveedor.ciudad.nombre));
    tr.append(createTd(proveedor.nombre));
    tr.append(createTd(proveedor.nit));
    tr.append(createTd(proveedor.correo));
    tr.append(createTd(proveedor.telefono));
    tr.append(createTd(proveedor.direccion));
    tr.append(createTd(proveedor.estado));

    tr.append(createTdEdit(proveedor));
    tr.append(createTdDelete(proveedor));

    return tr;
}

createTdEdit = (proveedor) => {
	let td = createTd("Editar");
	td.click(function () {
		showForm(proveedor);
	});
	return td;
}

createTdDelete = (proveedor) => {
	let td = createTd("Eliminar");
	td.click(function () {
		invokeDelete(proveedor);				
	});
	return td;
}

invokeDelete = (proveedor) => {
    console.log("proveedor que quiero eliminar ", proveedor);

    $.ajax({
        url: "http://localhost:8080/proveedores/" + proveedor.id,
        success: function () {
            invokeGet();

            alert("Proveedor eliminado correctamente");
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible eliminar el proveedor");
        },
        type: "DELETE"
    });
}

invokeGet = () => {
    $.get("http://localhost:8080/proveedores", processGet);
}

showForm = (data) => {
    $("#tblProveedores").removeClass("mostrar");
    $("#tblProveedores").addClass("ocultar");
    $("#frmProveedores").removeClass("ocultar");
    $("#frmProveedores").addClass("mostrar");
    console.log("Data For Form: ", data);

    // para editar
    if (!!data) {
        $("#divId").addClass("mostrar");
        $("#divId").removeClass("ocultar");

        $("#id").val(data.id);
        $("#nombreProveedor").val(data.nombre);
        $("#nit").val(data.nit);
        $("#correo").val(data.correo);
        $("#telefono").val(data.telefono);
        $("#direccion").val(data.direccion);
        $("#estado").val(data.estado);

        $("#id_ciudad").val(data.ciudad.id);
        $("#ciudadNombre").val(data.ciudad.nombre);
	}
    else { // para mostrar
        $("#divId").addClass("ocultar");
        $("#divId").removeClass("mostrar");
        $("#id").val("");
        $("#nombreProveedor").val("");
        $("#nit").val("");
        $("#correo").val("");
        $("#telefono").val("");
        $("#direccion").val("");
        $("#estado").val("");
        $("#id_ciudad").val("");
        $("#ciudadNombre").val("");
    }
}

sendForm = () => {
	if ($("#nombreProveedor").val() == undefined || $("#nombreProveedor").val() == null || $("#nombreProveedor").val() == "") {
        alert("Por favor verifique el campo nombre");
        return;
    }
    if ($("#nit").val() == undefined || $("#nit").val() == null || $("#nit").val() == "") {
        alert("Por favor verifique el campo nit");
        return;
    }
    if ($("#telefono").val() == undefined || $("#telefono").val() == null || $("#telefono").val() == "") {
        alert("Por favor verifique el campo telefono");
        return;
    }
    if ($("#correo").val() == undefined || $("#correo").val() == null || $("#correo").val() == "") {
        alert("Por favor verifique el campo correo");
        return;
    }
    if ($("#direccion").val() == undefined || $("#direccion").val() == null || $("#direccion").val() == "") {
        alert("Por favor verifique el campo direccion");
        return;
    }

    console.log("ID Ciudad:", $("#id_ciudad").val());
    let data = {
        "ciudad": {
            "id": $("#id_ciudad").val(),
            "nombre": $("#ciudadNombre").val()
        },
        "nombre": $("#nombreProveedor").val(),
        "nit": $("#nit").val(),
        "correo": $("#correo").val(),
        "telefono": $("#telefono").val(),
        "direccion": $("#direccion").val(),
        "estado": $("#estado").val()
    };
    console.log("Data ", data);

	let type = "POST";
    let message = "Proveedor registrado exitosamente";
    let actionType = ($("#id").val() == "") ? "agregar" : "editar";

    if (actionType == "editar") {
        data.id = $("#id").val();
        type = "PUT";
        message = "Proveedor actualizado exitosamente";
    }

    $.ajax({
        url: "http://localhost:8080/proveedores",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: function (response) {
            console.log("Response ", JSON.stringify(data));
            invokeGet();
            $("#frmProveedores").removeClass("mostrar");
            $("#frmProveedores").addClass("ocultar");

            alert(message);
        },
        error: function (response) {
            console.log("respuesta error: ", response);
            alert("No fue posible " + actionType + " el proveedor");
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
        $("#frmProveedores").removeClass("mostrar");
        $("#frmProveedores").addClass("ocultar");
        $("#tblProveedores").removeClass("ocultar");
        $("#tblProveedores").addClass("mostrar");
    });

    invokeGet();
})