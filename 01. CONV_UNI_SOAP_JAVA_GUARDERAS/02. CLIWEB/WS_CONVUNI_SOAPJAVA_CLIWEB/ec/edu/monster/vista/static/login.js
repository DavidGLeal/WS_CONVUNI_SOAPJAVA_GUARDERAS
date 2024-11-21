async function logIn(){
    const usuario = document.getElementById("usuario").value;
    const clave = document.getElementById("clave").value;

    if(usuario !== undefined && clave !== undefined){
        
        try{
            const res = await fetch('/login',{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({usuario:usuario,clave:clave})
            });

            const datos = await res.json();

            if(datos.exito){
                window.location.href = datos.redirect;
            }else{
                const err = document.getElementsByClassName("mal")[0];
                err.style.display = 'block';
            }

        }catch(error){
            console.error("Error en la solicitud: ",error);
            alert("Hubo un problema. Inténtelo de nuevo");
        }

    } else{
        alert("Por favor, ingrese usuario y contraseña");
    }
}

async function logOut(){
    const res = await fetch('/logout');
    const dat = await res.json();
    window.location.href = dat.redirect;
}