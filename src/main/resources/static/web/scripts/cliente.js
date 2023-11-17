document.addEventListener("DOMContentLoaded", function () {
    // Realiza una solicitud GET para obtener la lista de productos desde tu API
    axios.get('http://localhost:8080/api/clientes/getClientes2')
        .then(function (response) {
            // Obtén la tabla y el cuerpo de la tabla
            var table = document.getElementById('clienteTable');
            var tbody = table.getElementsByTagName('tbody')[0];

            // Limpia la tabla antes de agregar nuevos datos
            tbody.innerHTML = ''; // Esto eliminará todas las filas existentes

            // Itera sobre los productos y agrega filas a la tabla
            response.data.forEach(function (cliente) {
                var row = tbody.insertRow();
                // Agrega las celdas a la fila
                row.insertCell(0).textContent = cliente.id;
                row.insertCell(1).textContent = cliente.nombre;
                row.insertCell(2).textContent = cliente.nit;
                row.insertCell(3).textContent = cliente.estado;

                // Agrega un botón "Eliminar" en la última celda de la fila
                var deleteButton = document.createElement('button');
                deleteButton.textContent = 'Eliminar';
                deleteButton.addEventListener('click', function () {
                    deleteCliente(cliente.id); // Llama a la función de eliminación
                });
                row.insertCell(4).appendChild(deleteButton);
            });
        })
        .catch(function (error) {
            console.error('Error al obtener la lista de clientes:', error);
        });
});
