import hashlib

class ControladorLogin:
    
    def __init__(self):
        self.usuario = "Monster"
        self.clave = "7fbdfcdd431cb77a5bce52182f863d807544fdbea2edb49dc396d5ba30481f64"
    
    def verifUsuario(self,usuario,clave):
        hashclave = self.hashEntrada(clave)
        if(usuario == self.usuario and hashclave == self.clave):
            return True
        return False
    
    def hashEntrada(self,clave):
        hash_obj = hashlib.sha256(clave.encode('utf-8'))
        hash_digest = hash_obj.hexdigest()
        return hash_digest
