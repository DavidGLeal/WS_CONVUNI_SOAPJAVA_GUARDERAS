from zeep import Client


class ConvUniModelo:
    
    def __init__(self):
        self.wsdl_url = 'http://192.168.100.22:8080/WS_CONVUNI_SOAPJAVA/CONVUNI?wsdl'
        try:
            self.cliente = Client(wsdl=self.wsdl_url)
        except Exception as e:
            print("Error de servidor. El servicio no está disponible.")

    def convKGLB(self,kg):
        try:
            resultado = self.cliente.service.convertKGLB(kg)
            return resultado
        except Exception as e:
            return -1

    def convLBKG(self,lb):
        try:
            resultado = self.cliente.service.convertLBKG(lb)
            return resultado
        except Exception as e:
            return -1

