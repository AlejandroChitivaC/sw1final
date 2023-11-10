axios.get()
function handleSubmit(event) {
    event.preventDefault(); // Evita que el formulario se envíe
  
    // Obtén los valores de los campos del formulario
    var user = document.getElementById('username').value;
    var pass = document.getElementById('pass').value;
    var data = {
      username: user,
      pass: pass
    };
  
    // Realiza la solicitud POST al Endpoint
    axios.post('http://localhost:8080/auth/login', data)
      .then(function (response) {
          Swal.fire('Respuesta exitosa:', response.data);
          window.location.href = "/web/main.html"
          setTimeout(100);
      })

      .catch(function (error) {
        Swal.fire('Error:','Credenciales inválidas');
      });
  }
  
  // Asigna la función al evento onsubmit del formulario
  document.getElementById('form').addEventListener('submit', handleSubmit);