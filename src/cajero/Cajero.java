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

import java.io.*;
import javax.swing.JOptionPane;

/** Esta clase simula el comportamiento de un Cajero Electronico 
 *  de una Cuenta de Ahorro simulando las opciones 
 *  Retirar, Consignar, Consultar Saldo
 *
 * @author Amaury Cabarcas
 */
public class Cajero { 
    /**
     * Valor Constante de la Clase que indica el numero maximo de clientes 
     *  
     */
    public static final int CANTIDADCLIENTES = 20;    
    /**
     * Metodo Main de la Clase Cajero no recibe parametros 
     *  
     */
    public static void main(String[] args) {
        
        //SE CREA UN VECTOR DE 10 PERSONAS // (Son 20 personas)
        
        Cuenta listaCuentas[] = new Cuenta[CANTIDADCLIENTES];
        // SE LLAMA AL METODO PARA CREAR LOS OBJETOS EN EL VECTOR
        
        llenarCuentas(listaCuentas);
        mostrarClientes(listaCuentas);
        boolean op = false;
        int ced = 0;
        int posicionCliente = -1;
        
        //MENU PARA IDENTIFICAR CLIENTE EN EL BANCO
        while (!op || ced<0){
            do{
                JOptionPane.showMessageDialog(null, "BIENVENIDO A SU CAJERO ELECTRONICO", "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);
                String s = JOptionPane.showInputDialog(null, "INGRESE SU CEDULA", "SU BANCA MOVIL!", JOptionPane.QUESTION_MESSAGE);
                ced = Integer.parseInt(s);
                //LA CEDULA NEGATIVA SALE DEL PROGRAMA
                if(ced<0){
                    JOptionPane.showMessageDialog(null, "VUELVA PRONTO", "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }//fin del if
                // Si se ingresa una cedula valida, se procede a buscarla
                // el Método buscarCliente devuelve la posición en el arreglo donde se encuentra el cliente. 
                posicionCliente = buscarCliente(listaCuentas,ced);
                if(posicionCliente<0){
                    JOptionPane.showMessageDialog(null, "CLIENTE NO EXISTE", "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);
                }
            }while(posicionCliente<0);
        // FIN DEL MENU 
        
        //Ubica al objeto en el arreglo e imprime su nombre listaCuentas[posicionCliente].getTitular().getNombre()
        JOptionPane.showMessageDialog(null, "BIENVENIDO "+listaCuentas[posicionCliente].getTitular().getNombre(), "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);    
        int opcion;
        do{
           
           String s = JOptionPane.showInputDialog(null, "SELECCIONE UNA OPCIÓN\n"
                    + "1. RETIRO\n"
                    + "2. CONSIGNACIÓN\n"
                    + "3. CONSULTAR SALDO\n"
                    + "4. SALIR", "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);
            opcion = Integer.parseInt(s);
            switch(opcion){
                case 1: 
                    /*
                    INSERTE CODIGO QUE HAGA UN RETIRO DE LA CUENTA
                    */
                    double retiro = //Se declara la variable retiro...
                            Double.parseDouble ( JOptionPane.showInputDialog ( "INGRESE LA CANTIDAD A RETIRAR" ) ); //...Y se le asigna la cantidad a retirar ingresada por el usuario usando JOptionPane,
                                                                                                                    //y se convierte la cantidad a double.
                    
                    boolean confir;//Se declara un booleano para confirmar el retiro y se inicializa en false.
                    confir = listaCuentas[posicionCliente].retirar( retiro ); //En la posición del cliente, se le asigna el argumento retiro a la función retirar(),
                                                                                //y el valor que retorna se le asigna a la variable confir.
                    
                    if ( confir == true )  //Si el valor de confir es true...
                        JOptionPane.showMessageDialog( null, "SE RETIRÓ EXITOSAMENTE" ); //...Muestra un mensaje que dice que el retiro fue exitoso.
                    else  //Si el valor de confir es falso...
                        JOptionPane.showMessageDialog(null, "LA CANTIDAD NO SE PUDO RETIRAR"); //...Muestra un mensaje que dice que la cantidad no se pudo retirar.
                break;
                case 2:
                    /*
                    INSERTE CODIGO QUE HAGA CONSIGNACION EN LA CUENTA
                    */
                    double consigna = //Se declara la variable consigna...
                            Double.parseDouble( JOptionPane.showInputDialog ( "INGRESE EL VALOR A CONSIGNAR" ) ); //...Y se le asigna la cantidad a consignar ingresada por el usuario usando JOptionPane,
                                                                                                                   //y se convierte la cantidad a double.
                    
                    listaCuentas[posicionCliente].setSaldo( consigna ); //En la posición del cliente, se le asigna el argumento consigna a la función setSaldo().
                    
                break;
                case 3:
                    //consultar saldo
                    JOptionPane.showMessageDialog(null, "SU SALDO ES "+listaCuentas[posicionCliente].getSaldo(), "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);
                break;
                case 4:
                    JOptionPane.showMessageDialog(null, "VUELVA PRONTO", "SU BANCA MOVIL", JOptionPane.INFORMATION_MESSAGE);
                return;
                
            }
            }while(opcion!=4);
            op = true;
        }
        
    }
    //METODOS PARA TRABAJAR. INSERTE SU CODIGO EN CADA UNO DE ESTOS METODOS
    
    /**
     * Metodo mostrarCliente recibe un arreglo de cuentas 
     * RECORRE EL VECTOR DE CUENTAS E IMPRIME UNO A UNO LOS DATOS DE CADA CUENTA
     * @param c Arreglo de objetos de tipo Cuenta  
     */
       public static void mostrarClientes(Cuenta[] c){
        //INSERTE SU CODIGO AQUI 
        
        for  ( int i = 0; i < CANTIDADCLIENTES; i++ )//Recorre el vector de cuentas.
           JOptionPane.showMessageDialog ( null, c[i].toString() );//Imprime uno a uno los datos de cada cuenta individual con la función toString() de Cuenta usando JOptionPane.
        
    }
      
    /**
     * METODO buscarCliente recibe un arreglo de objetos de la clase Cuenta y una cedula a buscar
     * RECORRE EL VECTOR DE CUENTAS BUSCANDO LA CEDULA ced
     * SI LA ENCUENTRA DEVUELVE LA POSICIÓN EN EL VECTOR 
     * SI NO LA ENCUENTRA DEVUELVE -1 
     * @param c Arreglo de objetos de tipo Cuenta  
     * @param ced numero de cedula a buscar
     */
    public static int buscarCliente(Cuenta [] c, int ced){
        //INSERTE SU CODIGO AQUI
        for ( int i = 0; i < CANTIDADCLIENTES; i++ ) //Recorre el vector de cuentas buscando la cédula con el valor de ced.
        {
            /*Se coge el número de cédula almacenado en cada espacio del vector usando el método getTitular() de Cuenta,
               y el método getCedula() de Persona para obtener el número de cédula del titular de ese espacio del vector y se compara con la cédula ingresada (ced).
                  Si las cédulas son iguales, retorna el número del espacio usando el iterador i.
            */
            if ( c[ i ].getTitular().getCedula() == ced ) 
                return i;                                  
      
        }
        
       return -1;//Si no encuentra la cédula en ninguna posición al salir del for, devuelve -1.
    }
    
    
    //METODOS COMPLEMENTARIOS NO MODIFICAR NI BORRAR
    
    /**
     * Metodo leerNombresClientes no recibe parametros
     * Busca en el archivo nombres.txt un listado de nombrres
     * los almacena en un arreglo de String y lo devuelve
     * @return String[] arreglo de String con los nombres de los clientes
     */
    public static String[] leerNombresClientes(){
      File archivo ;
      FileReader fr = null;
      BufferedReader br ;
      String nombres[] = new String[CANTIDADCLIENTES];
      int pos=0;
      try {
         // Apertura del archivo y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("nombres.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del archivo
         String linea ="";
         while((linea !=null)&&(pos<20)){
            linea=br.readLine();
            nombres[pos] = linea;
            pos++;
            
         }
            //System.out.println(linea);
         return nombres;   
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el archivo, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return null; 
   } // fin del metodo
    
    /**
     * Metodo llenarCuenta recibe como parametro un arreglo de objetos Cuenta
     * genera saldos aleatorios entre 50000 y 500000
     * los almacena en el atributo saldo de cada cuenta
     * y usa el metodo leerNombresClientes para asignarles
     * los nombres a los titulares 
     */
    /*********************ERROR: SE MODIFICÓ ESTE MÉTODO PARA QUE INICIALICE EL NÚMERO DE CUENTA 
       DE MANERA CONVENIENTE USANDO EL ITERADOR DEL FOR EN EL MÉTODO MODIFICADO.************/
    
    public static void llenarCuentas(Cuenta[] lista){
        // DEFINE EL RANGO 
        int max = 500000; 
        int min = 50000; 
        int range = max - min + 1;
        int ced = 123;
        String nombres[] = new String[CANTIDADCLIENTES];
        // GENERA NUMEROS ALEATORIOS ENTRE 50000 Y 500000  
        for (int i = 0; i < CANTIDADCLIENTES; i++) { 
            double rand = (double)(Math.random() * range) + min;
            nombres = leerNombresClientes();
            //SE CREA EL OBJETO CUENTA CON EL SALDO ALEATORIO           
            lista[i]=new Cuenta(rand,nombres[i],ced, i + 1);
            ced+=i+1;
            
        } 
    }
    
 
}//FIN DE LA CLASE 