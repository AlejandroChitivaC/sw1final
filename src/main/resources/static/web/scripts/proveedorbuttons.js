$(".buttons-csv").on("click", function () {
    console.log('hola');
    // Fetch data from the server
    window.location.href = "http://localhost:8080/api/supplier/downloadCsv";
});

$(".buttons-excel").on("click", function () {
    // Fetch data from the server
    $.get("http://localhost:8080/proveedores", function (proveedores) {
        // Assuming 'proveedores' is your array of data
        const data = proveedores.map(proveedor => [
            proveedor.id,
            proveedor.ciudad.id,
            proveedor.ciudad.nombre,
            proveedor.nombre,
            proveedor.nit,
            proveedor.correo,
            proveedor.telefono,
            proveedor.direccion,
            proveedor.estado
        ]);

        // Create a new Excel workbook and add a worksheet
        const workbook = XLSX.utils.book_new();
        const worksheet = XLSX.utils.aoa_to_sheet(data);

        // Add the worksheet to the workbook
        XLSX.utils.book_append_sheet(workbook, worksheet, 'Sheet1');

        // Save the workbook as an Excel file
        XLSX.writeFile(workbook, 'proveedores.xlsx');
    });
});

$(".buttons-pdf").on("click", function () {
    // Fetch data from the server
    $.get("http://localhost:8080/proveedores", function (proveedores) {
        const data = proveedores.map(proveedor => [
            proveedor.id.toString(),
            proveedor.ciudad.id.toString(),
            proveedor.ciudad.nombre,
            proveedor.nombre,
            proveedor.nit,
            proveedor.correo,
            proveedor.telefono,
            proveedor.direccion,
            proveedor.estado
        ]);

        // Set the table headers
        const headers = [
            'ID',
            'Ciudad ID',
            'Ciudad Nombre',
            'Nombre',
            'NIT',
            'Correo',
            'Teléfono',
            'Dirección',
            'Estado'
        ];

        // Create a PDF document definition
        const docDefinition = {
            content: [
                {
                    table: {
                        headerRows: 1,
                        body: [headers, ...data]
                    }
                }
            ],
            pageOrientation: 'landscape', // or 'portrait'
        };

        // Create the PDF
        pdfMake.createPdf(docDefinition).download('data.pdf');
    });
});

$(".buttons-print").on("click", function () {
    // Fetch data from the server
    $.get("http://localhost:8080/proveedores", function (proveedores) {
        // Assuming 'proveedores' is your array of data
        const data = proveedores.map(proveedor => [
            proveedor.id.toString(),
            proveedor.ciudad.id.toString(),
            proveedor.ciudad.nombre,
            proveedor.nombre,
            proveedor.nit,
            proveedor.correo,
            proveedor.telefono,
            proveedor.direccion,
            proveedor.estado
        ]);

        // Set the table headers
        const headers = [
            'ID',
            'Ciudad ID',
            'Ciudad Nombre',
            'Nombre',
            'NIT',
            'Correo',
            'Teléfono',
            'Dirección',
            'Estado'
        ];

        // Create a table with headers and data
        const table = `<table border="1" cellspacing="0" cellpadding="5">
            <thead>${headers.map(header => `<th>${header}</th>`).join('')}</thead>
            <tbody>${data.map(row => `<tr>${row.map(cell => `<td>${cell}</td>`).join('')}</tr>`).join('')}</tbody>
        </table>`;

        // Create a new window with the table content
        const printWindow = window.open('', '_blank');
        printWindow.document.open();
        printWindow.document.write(`
            <html>
                <head>
                    <style>
                        table {
                            border-collapse: collapse;
                            width: 100%;
                        }
                        th, td {
                            border: 1px solid #dddddd;
                            text-align: left;
                            padding: 8px;
                        }
                        th {
                            background-color: #f2f2f2;
                        }
                    </style>
                </head>
                <body>${table}</body>
            </html>
        `);
        printWindow.document.close();

        // Trigger the print dialog
        printWindow.print();
    });
});
