const { data } = require("jquery");

document.addEventListener("DOMContentLoaded", function () {
    // Realiza una solicitud GET para obtener la lista de usuarios desde tu API
    axios.get('http://localhost:8080/api/user/getUsers2')
        .then(function (response) {
            // Obtén la tabla y el cuerpo de la tabla
            var table = document.getElementById('userTable');
            var tbody = table.getElementsByTagName('tbody')[0];

            // Limpia la tabla antes de agregar nuevos datos
            tbody.innerHTML = ''; // Esto eliminará todas las filas existentes

            // Itera sobre los usuarios y agrega filas a la tabla
            response.data.forEach(function (user) {
                var row = tbody.insertRow();
                // Agrega las celdas a la fila
                row.insertCell(0).textContent = user.id;
                row.insertCell(1).textContent = user.usuario;
                row.insertCell(2).textContent = user.primerNombre;
                row.insertCell(3).textContent = user.segundoNombre;
                row.insertCell(4).textContent = user.primerApellido;
                row.insertCell(5).textContent = user.segundoApellido;
                row.insertCell(6).textContent = user.estado;
                row.insertCell(7).textContent = user.rol;

                // Agrega un botón "Eliminar" en la última celda de la fila
                var deleteButton = document.createElement('button');
                deleteButton.textContent = 'Editar';
                deleteButton.className='btn btn-danger';
                deleteButton.addEventListener('click', function () {
                    deleteUser(user.id); // Llama a la función de eliminación
                });
                row.insertCell(8).appendChild(deleteButton);
            });
        })
        .catch(function (error) {
            console.error('Error al obtener la lista de usuarios:', error);
        });
});
