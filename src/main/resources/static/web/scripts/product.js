document.addEventListener("DOMContentLoaded", function () {
    // Realiza una solicitud GET para obtener la lista de productos desde tu API
    axios.get('http://localhost:8080/api/producto/getProducts2')
        .then(function (response) {
            // Obtén la tabla y el cuerpo de la tabla
            var table = document.getElementById('productoTable');
            var tbody = table.getElementsByTagName('tbody')[0];

            // Limpia la tabla antes de agregar nuevos datos
            tbody.innerHTML = ''; // Esto eliminará todas las filas existentes

            // Itera sobre los productos y agrega filas a la tabla
            response.data.forEach(function (product) {
                var row = tbody.insertRow();
                // Agrega las celdas a la fila
                row.insertCell(0).textContent = product.id;
                row.insertCell(1).textContent = product.nombreProducto;
                row.insertCell(2).textContent = product.precioVenta;
                row.insertCell(3).textContent = product.stockMin;
                row.insertCell(4).textContent = product.stockMax;
                row.insertCell(5).textContent = product.existencia;
                row.insertCell(6).textContent = product.iva;
                row.insertCell(7).textContent = product.estado;

                // Agrega un botón "Eliminar" en la última celda de la fila
                var deleteButton = document.createElement('button');
                deleteButton.textContent = 'Eliminar';
                deleteButton.addEventListener('click', function () {
                    deleteProduct(product.id_prod); // Llama a la función de eliminación
                });
                row.insertCell(8).appendChild(deleteButton);
            });
        })
        .catch(function (error) {
            console.error('Error al obtener la lista de productos:', error);
        });
});
