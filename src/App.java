import javax.swing.JOptionPane;
import java.time.LocalDate;
//Gestor de Movimientos
public class App {
    public static void main(String[] args) {
        int opc, flag=0, login = 0; String desc; double monto=0.0;
        //La Interfaz se realizara en apache, se ve que es mas facil desde ahi, y podre hacerlo pro pro - Erick
        //Creacion de Objetos
        Base root = new Base();
        LocalDate fecha = LocalDate.now();
        //Crear archivos necesarios
        root.checkFiles();
        Movimientos trans = new Movimientos();
        do{
            if(login==0){
                //Se va a repetir el proceso hasta que el usuario presione la opcion de salir
                String usuario = JOptionPane.showInputDialog("Ingrese su usuario: ");
                trans.ID = 1;
                trans.user = usuario;
                login = 1;
            } else if(login ==1){
                do{ 
                    opc = Integer.parseInt(JOptionPane.showInputDialog("\n" +
                    "=======================================\n"+
                    "       Bienvenido a ManageMoney      \n"+
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
                            //Ingresar Ingresos - Se solicitara el int tipo, double monto, String fecha (dia-mes-anio), String descripcion. 
                            monto = Double.parseDouble(JOptionPane.showInputDialog("\n" +
                            "Ingrese un monto:\n"));
                            desc = JOptionPane.showInputDialog("\n" +
                            "Ingrese una descripción de su ingreso:\n");
                            trans.setMovimiento(0, monto, fecha, desc);
                            break;
                        case 2:
                            //Ingresar Egresos
                            monto = Double.parseDouble(JOptionPane.showInputDialog("\n" +
                            "Ingrese un monto:\n"));
                            desc = JOptionPane.showInputDialog("\n" +
                            "Ingrese una descripción de su egreso:\n");
                            trans.setMovimiento(1, monto, fecha, desc);
                            break;
                        case 3:
                            //Eliminar movimiento proximamente V2.1
                            
                            break;
                        case 4:
                            //Historial de movimientos
                            System.out.println("Los movimientos guardados estan:");
                            trans.getMovimientos();
                            break;
                        case 5:
                            //Ver patrimonio proximamente V2.1
                            
                            break;
                        case 6:
                            System.out.println("Muchas gracias por utilizar nuestro servicio, vuelva pronto.");
                            flag = 1;
                            break;     
                        default:
                            System.out.println("Opcion Incorrecta, por favor vuelva a intentarlo nuevamente");
                            break;
                    }
                }while (opc !=6);
            }
        } while(flag != 1);
        
        
    }
}
