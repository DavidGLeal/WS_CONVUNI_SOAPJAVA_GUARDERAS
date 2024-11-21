from flask import Flask, render_template,request,jsonify,session,redirect,url_for

from ec.edu.monster.controlador.controladorServicio import ControladorServicio
from ec.edu.monster.controlador.controladorLogin import ControladorLogin


app = Flask(__name__, template_folder="../vista",static_folder="../vista/static")
app.secret_key = 'monster'
controladorServicio = ControladorServicio()

def login_required(f):
    def wrap(*args,**kwargs):
        if 'usuario' not in session:
            return redirect(url_for('login'))
        return f(*args,**kwargs)
    wrap.__name__ = f.__name__
    return wrap

@app.route('/')
@login_required
def home():
    return render_template('index.html')

@app.route('/login',methods=['GET','POST'])
def login():
    controlLogin = ControladorLogin()
    if request.method == 'POST':
        datos = request.get_json()
        usuario = datos.get('usuario')
        clave = datos.get('clave')
        
        if controlLogin.verifUsuario(usuario,clave):
            session['usuario'] = usuario
            return jsonify({"exito":True,"redirect": url_for('home')})
        else:
            return jsonify({"exito":False,"error":"Credenciales incorrectas"})
    return render_template('login.html')

@app.route('/convertir/kg-lb', methods=['POST'])
@login_required
def convertKgLb():
    datos = request.get_json()
    kg = datos.get('kg')
    if kg is None:
        return jsonify({'error': 'Falta el valor de kilogramos.'}), 400
    lb = controladorServicio.convKgLb(kg)
    return jsonify({'libras': lb})

@app.route('/convertir/lb-kg', methods=['POST'])
@login_required
def convertLbKg():
    datos = request.get_json()
    lb = datos.get('lb')
    if lb is None:
        return jsonify({'error': 'Falta el valor de libras.'}), 400
    kg = controladorServicio.convLbKg(lb)
    return jsonify({'kilogramos': kg})

@app.route('/logout')
def logout():
    session.pop('usuario',None)
    return jsonify({"redirect": url_for('login')})

if __name__ == '__main__':
    app.run(debug=True, host="0.0.0.0", port=5000)