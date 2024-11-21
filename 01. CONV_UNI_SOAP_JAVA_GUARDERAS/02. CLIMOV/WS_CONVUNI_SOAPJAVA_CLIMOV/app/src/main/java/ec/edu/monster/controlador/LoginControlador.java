    package ec.edu.monster.ws_convuni_soapjava_climov.controlador;

    import java.security.MessageDigest;
    import java.security.NoSuchAlgorithmException;

    public class LoginControlador {

        private String usuario = "Monster";
        private String clave = "7fbdfcdd431cb77a5bce52182f863d807544fdbea2edb49dc396d5ba30481f64";

        public boolean verificar(String usuario, String clave){
            String hashClave = "";
            try{
                hashClave = hashSHA256(clave);
            }catch(NoSuchAlgorithmException e){
                System.err.println("Error. Algoritmo SHA-256 no encontrado.");
            }
            if(usuario.equals(this.usuario) && hashClave.equals(this.clave)){
                return true;
            }
            return false;
        }

        private static String hashSHA256(String entrada) throws NoSuchAlgorithmException{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hashBytes = digest.digest(entrada.getBytes());

            StringBuilder hexString = new StringBuilder();

            for(byte b: hashBytes){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        }

    }

