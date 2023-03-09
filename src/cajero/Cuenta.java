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

/** Esta clase define objetos que contienen datos de una Cuenta de Ahorro saldo, titular y numero de cuenta
 *
 * @author Amaury Cabarcas
 * @version: 22/04/2020 
 */
public class Cuenta {
    //Atributo privado que guarda el saldo de la cuenta   
    private double saldo;
    private Persona titular;
    private int numeroCuenta;
    
    //CONSTANTE DE CLASE NO APARECE EN LOS OBJETOS que define el saldo minimo a dejar en la cuenta. 
    private static final double SALDOMINIMO = 10000;
    //CONSTANTE DE CLASE QUE DEFINE EL SALDO DE APERTURA DE LA CUENTA
    private static final double SALDOAPERTURA = 10000;
    private static final double RETIROMAXIMO = 700000;
    
    public Cuenta(){
           //INSERTE CODIGO AQUI
            saldo = SALDOAPERTURA; //Se inicializa saldo en SALDOAPERTURA.
            titular = new Persona(); //Se crea un objeto tipo Persona como titular.
           
    }
    
    /**
     * Constructor alternativo recibe como parametros saldo, n y c  
     * Inicializa saldo con el valor del parametro saldo
     * el valor como parametro no puede ser menor a constante SALDOAPERTURA
     * Crea un objeto de tipo Persona como titular, con los parametros n y c
     * @see Persona
     */
    
    //CONSTRUCTOR ALTERNATIVO QUE CREA LA CUENTA CON UN VALOR POR PARAMETRO
    /************* ERROR: En este constructor hacía falta inicializar el número de cuenta así que agregamos un
     ¨  parámetro num para que el número de cuenta sea inicializado (continuar corrección en el método llenarCuentas de Cajero).***********/   
    public Cuenta(double saldo, String n, int c, int num){
           //INSERTE CODIGO AQUI
          
           //Si es mayor o igual a SALDOAPERTURA se inicializa saldo con el valor del parámetro saldo, sino se inicializa en SALDOAPERTURA.
           if ( saldo >= SALDOAPERTURA ) 
               this.saldo = saldo; 
           else
               this.saldo = SALDOAPERTURA; 
           
            titular = new Persona( n, c );  //Se crea un objeto de tipo Persona como titular, con los parámetros n y c.
            
            numeroCuenta = num; //Se inicializa numeroCuenta con el valor del parámetro num.
         
           
       }
    /**
     * Metodo Analizador del atributo saldo no recibe parametros 
     * 
     * @return saldo de la cuenta
     * 
     */
    public double getSaldo() {
        return saldo;
    }
    /**
     * Metodo Analizador del atributo titula no recibe parametros 
     * 
     * @return titular de la cuenta el cual es un objeto de tipo Persona
     * 
     */
    public Persona getTitular() {
        return titular;
    }
    
    /**
     * Metodo Modificador del atributo saldo recibe el valor a consignar en la cuenta
     * 
     * @param cantidad El valor numerico que representa el valor a consignar en la cuenta
     * 
     */
    public void setSaldo(double cantidad) {
        this.saldo += cantidad;
    }
    
    /**
     * Metodo Modificador del atributo saldo recibe el valor a retirar en la cuenta
     * el valor a retirar no puede ser superior a constante RETIROMAXIMO
     * Al retirar se debe validar que el saldo minimo es SALDOMINIMO
     * ninguna cuenta puede tener un saldo menor a SALDOMINIMO 
     * luego de hacer un retiro
     * Devuelve true si puede hacer el retiro 
     * de lo contrario devuelve false
     * @param retiro El valor numerico que representa el valor a retirar de la cuenta 
     *  @return boolean True si puede hacer retiro false si no puede hacer retiro
     */
    public boolean retirar(double retiro) {
        //INSERTE CODIGO AQUI
        
        /*Como todas las condiciones son obligatorias, pasa a retornar falso si las condiciones que no permiten retirar se cumplen.
        Si ninguna de éstas se cumple, se realiza el retiro y por tanto retorna verdadero.
        */
        
        if ( retiro > RETIROMAXIMO ) 
            return false;         
        else if ( saldo - retiro < SALDOMINIMO )
            return false; 
        else 
            saldo -= retiro;
        
        return true;    
        
    }//FIN METODO RETIRAR

    /**
     * Metodo toString heredado de la clase Object 
     * Devuelve los atributos de la cuenta en un String
     * que contiene numeroCuenta, nombre, cedula y saldo
     */
    @Override
    public String toString() {
        return "Informacion de la cuenta "+numeroCuenta+
                "\n Titular: "+titular.getNombre()+
                "\n Cedula: "+titular.getCedula()+
                "\n Saldo "+saldo; 
    }
    
    
    
       
}//FIN DE LA CLASE