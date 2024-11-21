from ec.edu.monster.controlador.controladorServicio import ControladorServicio

class Prueba01:
    
    def probar(self):
        kg = 1
        lb = 2.205
        
        conServicio = ControladorServicio()
        
        nuevLb = conServicio.convKgLb(kg)
        nuevKg = conServicio.convLbKg(lb)
        
        print(str(kg)+" kg = "+str(nuevLb)+" lb")
        print(str(lb)+" lb = "+str(nuevKg)+" kg")
        
        
if __name__ == "__main__":
    pr1 = Prueba01()
    pr1.probar()