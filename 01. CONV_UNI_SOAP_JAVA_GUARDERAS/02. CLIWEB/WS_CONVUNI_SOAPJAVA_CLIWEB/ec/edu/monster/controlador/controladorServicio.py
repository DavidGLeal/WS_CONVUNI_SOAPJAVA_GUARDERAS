from ec.edu.monster.modelo.modelo import ConvUniModelo

class ControladorServicio:
    
    def __init__(self):
        self.modelo = ConvUniModelo()
    
    def convKgLb(self,kg):
        lb = self.modelo.convKGLB(kg)
        return lb
    
    def convLbKg(self,lb):
        kg = self.modelo.convLBKG(lb)
        return kg