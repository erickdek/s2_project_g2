//Jordy se va a mimir, gn C:
import javax.swing.JOptionPane;
//Gestor de Movimientos
public class App {
    public static void main(String[] args) {
        int opc;
        
        //Creacion de Objetos
        Base b1 = new Base();
        //Crear archivos necesarios
        b1.checkFiles();
        Movimientos transac = new Movimientos();
        System.out.print(transac.fecha);

        //Se va a repetir el proceso hasta que el usuario presione la opcion de salir
        do{ 
            opc = Integer.parseInt(JOptionPane.showInputDialog("\n" +
            "=======================================\n"+
            "       Bienvenido a APPmasterXD69      \n"+
            "=======================================\n"+
            "================= MENU ================\n"+
            "1. Registrar ingreso. \n"+
            "2. Registrar engreso. \n"+ 
            "3. Eliminar movimientos. \n"+
            "4. Historial de movimientos. \n"+
            "5. Ver Patrimonio. \n" +
            "6. Salir. \n" +
            "=======================================\n" +
            "Ingrese una opcion: "));

            switch (opc) {
                case 1:
                    //Ingresar Ingresos
                    b1.set(0, "1 Juan 235034");
                    b1.set(1, "2 Juana 235032 kmasoe");
                    break;
                case 2:
                    //Ingresar Egresos
                    
                    break;
                case 3:
                    //Eliminar movimiento
                    
                    break;
                case 4:
                    //Historial de movimientos

                    break;
                case 5:
                    //Ver patrimonio
                    
                    break;
                case 6:
                    System.out.println("Muchas gracias por utilizar nuestro servicio, vuelva pronto.");
                    break;     
                default:
                    System.out.println("Opcion Incorrecta, por favor vuelva a intentarlo nuevamente");
                    break;
            }
        }while (opc !=6);
    }
}