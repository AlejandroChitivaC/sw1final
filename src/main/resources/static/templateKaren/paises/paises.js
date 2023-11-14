processGetPaises = (response) => {
			// do something to response
			let tbody = document.querySelector("#tblPaises tbody");
			const paises = JSON.parse(response);
			
			if(paises.length <= 0){
				tbody.innerHTML = "<tr ><td colspan = '3'>No se encontraron paises</td></tr>";
				return ;
			}
				
			let tr = "<tr><td>ID</td><td>NOMBRE</td><td>ESTADO</td></tr>";
			paises.forEach (pais => {
				console.log(pais);
				//let trAux = tr.replace("ID", pais.id).replace("NOMBRE", pais.nombre).replace("ESTADO", "Activo");
				//tbody.innerHTML += trAux;
				
				tbody.innerHTML += "<tr><td>"+pais.id+"</td><td>"+pais.nombre+"</td><td>Activo</td></tr>";
			});
				
			console.log(response);
			console.log("-------------");
			console.log(tbody);				
		}
	
		getPaises = () => {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', 'http://localhost:8082/paises', true);
			//xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			xhr.onload = function () { 
				processGetPaises(this.responseText);
			}
			xhr.send('');
		}
		getPaises();