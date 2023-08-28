
package mail;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase sirve para verificar y sugerir emails 
 * y tambien sugerir contraseñas
 * @author Miguel Jesus Zuñiga Coneo
 * @version 1.0
 */
public class Validacion {
    /**
     * La funcion de este metodo es verificar el Email ingresado por el usuario
     * Si el Email es correcto envia un mensaje (true), si es incorrecto (false)
     * @param dato
     * @return respuesta
     */
    public boolean VerificarMail(String dato){
        
     
        
        boolean respuesta;
        // Patrón para validar el email
            Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            Matcher mather = pattern.matcher(dato);

            if (mather.find() == true) {
		respuesta = true;
            } else {
		respuesta= false;
            }
                
        return respuesta;
    }
            /**
             * Este metodo sugiere cuatro Emails basados en los datos ingresados por el usuario
             * @param Nombre
             * @param PrimerApellido
             * @param SegundoApellido
             * @param AñoNacimiento
             * @return Emails Sugeridos
             */
    public String SugerirMail(String Nombre, String PrimerApellido, String SegundoApellido, int AñoNacimiento){
        
        String opcion1 = ""+ Nombre.charAt(0)+PrimerApellido;
         //En esta variable (opcion1) se almacenara el Primer email sugerido por el programa
        String opcion2 = "" + Nombre.charAt(0)+PrimerApellido+SegundoApellido.charAt(0)+AñoNacimiento;
        //En esta variable (opcion2) se almacenara el segundo email sugerido por el programa
        String opcion3 = "" + Nombre.charAt(0)+PrimerApellido+SegundoApellido+AñoNacimiento;
        //En esta variable (opcion3) se almacenara el tercer email sugerido por el programa
        String opcion4 = ""+ PrimerApellido+SegundoApellido.charAt(0)+AñoNacimiento;
        //En esta variable (opcion4) se almacenara el cuarto email sugerido por el programa
        
        return "Opcion1: "+ opcion1 +"\n" + "Opcion2: "+ opcion2 +"\n"+ "Opcion3: "+ opcion3 +"\n" +"Opcion4: "+ opcion4  ;
    }
    /**
     * La funcion de este metodo es sugerir al usuario una contraseña segura
     * @return password
     */
    public String SugerirPassword(){
        final String mayuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String resto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final String CaracterEspecial = "!¡?¿*./+-_";
        String password="";
        int len = 10;
        Random rd= new Random();
        
   
        for (int i=0; i < len ; i ++ ){
             int aux ;
            if(password.equals("")){
                aux = rd.nextInt(mayuscula.length());
                password = password + mayuscula.charAt(aux);
            }
            if(i== (len-1)){
               aux = rd.nextInt(CaracterEspecial.length());
                password = password + CaracterEspecial.charAt(aux); 
            }
            else{
                aux = rd.nextInt(resto.length());
                password = password + resto.charAt(aux); 
            }
        }
        
        return password;
    }
}
