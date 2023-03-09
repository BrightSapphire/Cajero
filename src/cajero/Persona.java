/*
/***************************************************************************************
* Palabra de honor:
* - No he discutido ni mostrado el código de mi programa con alguien que no sea mi *compañero, Profesor o con
el monitor asignado a este curso.
*
* - No he utilizado código obtenido de otro u otros estudiantes,
* O cualquier otra fuente no autorizada, ya sea modificado o sin modificar.
*
* - Si cualquier código o documentación utilizada en mi programa
* Fue obtenido de otra fuente, tal como un libro de texto o notas del curso
* debe ser claramente señalado con una cita apropiada en
* los comentarios de mi programa.
*
* <Sebastián Herrera Claro, Stephanie Acosta Sierra – 0221910043, 0221910006>
*
***********************************************************************/

package cajero;

/** Esta clase define objetos que contienen datos de Personas nombre y cedula
 *
 * @author Amaury Cabarcas
 * @version: 22/04/2020 
 */
public class Persona {
    // ATRIBUTOS 
    private String nombre;
  
    private int cedula;
     //FIN ATRIBUTOS
   
     /**
     * Constructor por defecto no recibe parametros 
     * inicializa nombre a Fulano de Tal
     * inicializa cedula a 123
     */
    public Persona(){
        nombre = "Fulano de Tal";
        cedula = 123;
    }
    /**
     * Constructor alternativo
     * recibe como parametro nombre de la persona
     * recibe como parametro cedula de la persona
     * inicializa los atributos a los valores de los parametros
     */
    //constructor alternativo
    public Persona (String  nombre, int cedula){
     
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
        
    // Analizadores y Modificadores de atributos
    
    /**
     * Metodo Analizador del atributo nombre no recibe parametros 
     * 
     * @return String El nombre de la persona
     * 
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Metodo Analizador del atributo cedula no recibe parametros 
     * 
     * @return int El numero de cedula de la persona
     * 
     */
    public int getCedula() {
        return cedula;
    }
    /**
     * Metodo Modificador del atributo cedula recibe el valor a ingresar
     * 
     * @param cedula El numero de cedula a ingresar en el atributo
     * 
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
     /**
     * Metodo Modificador del atributo nombre recibe el valor a ingresar
     * 
     * @param nombre El nombre de la persona a ingresar en el atributo
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo toString heredado de la clase Object 
     * Devuelve los atributos de la forma 
     * "Los datos de la persona son: "+nombre+" "+cedula 
     */
    
    @Override
    public String toString() {
        return "Los datos de la persona son: "+nombre+" "+cedula; 
    }
       
    
}//fin de clase Persona
