

async function convertKgLb(){
    const kg = document.getElementById('kgIn').value;
    if(kg!== undefined && kg !==''){
        const respuesta = await fetch('/convertir/kg-lb',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({kg: parseFloat(kg)})
        });
        const datos = await respuesta.json();
        if(datos.libras<0){
            document.getElementById("error").style.display = "block";
        }
        else{
            document.getElementById('lbOut').value = respuesta.ok ?
                datos.libras : '';
        }
    }
    else{
        document.getElementById('kgIn').value = '';
        document.getElementById('lbOut').value = '';
    }
}

async function convertLbKg(){
    const lb = document.getElementById('lbIn').value;
    if(lb!== undefined && lb !==''){
        console.log(lb+"lb")
        const respuesta = await fetch('/convertir/lb-kg', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({lb: parseFloat(lb)})
        });
        const datos = await respuesta.json();
        if(datos.kilogramos<0){
            document.getElementById("error").style.display = "block";
        }
        else{
            document.getElementById('kgOut').value = respuesta.ok ?
                datos.kilogramos : '';
        }
    }
    else{
        document.getElementById('lbIn').value = '';
        document.getElementById('kgOut').value = '';
    }
}

document.getElementById("errorOk").addEventListener("click", () =>{
    document.getElementById("error").style.display = "none";
})

