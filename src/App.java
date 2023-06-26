import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.Scanner;
//Gestor de Movimientos
public class App {

    public static void main(String[] args) {
        int MenuOP = 0, loginOP = 0, flag = 0, login = 0;
        double monto = 0.0;
        String desc;
        
        //Creacion de Objetos
        Scanner sc = new Scanner(System.in);
        Menu mn = new Menu(); //Menus
        Base root = new Base(); //Gestion de archivos
        Gestor gs = new Gestor(); //Movimientos
        LocalDate fecha = LocalDate.now(); //Fechas
        
        //Crear archivos necesarios
        root.checkFiles();

        do{
            if(login==0){
                do {
                    loginOP = mn.loginUser(sc);
                    switch(loginOP){
                        case 1:
                            if ( gs.Login(sc) ){login = 1;}
                            break;
                        case 2:
                            if ( gs.Login(sc) ){login = 1;}
                            break;
                        case 3:
                            System.out.print("\nGracias por usar...");
                            flag = 1; login = 0;
                            break;
                        }
                } while ( login == 0 ^ loginOP == 3 );
            } else if(login == 1){
                do{ 
                    MenuOP = mn.MenuPrincipal(sc);
                    
                    switch (MenuOP) {
                        case 1:
                            try {
                                //Ingresar Ingreso
                                System.out.print("\nIngrese un monto del Ingreso: ");
                                monto = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Ingrese una descripcion pequeña (Sin comas): ");
                                desc = sc.nextLine();
                                gs.setMovimiento(0, monto, fecha, desc);
                            } catch (Exception e) {
                                System.out.print("\nHubo un error: " + e.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                //Ingresar Egresos
                                System.out.print("\nIngrese un monto del Egreso: ");
                                monto = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Ingrese una descripcion pequeña (Sin comas): ");
                                desc = sc.nextLine();
                                gs.setMovimiento(1, monto, fecha, desc);
                            } catch (Exception e) {
                                System.out.print("\nHubo un error: " + e.getMessage());
                            }
                            break;
                        case 3:
                            //Eliminar movimiento proximamente V2.1
                            
                            break;
                        case 4:
                            //Historial de movimientos
                            System.out.println("Los movimientos guardados estan:");
                            gs.getMovimientos();
                            break;
                        case 5:
                            //Ver patrimonio proximamente V2.1
                            
                            break;
                        case 6:
                            System.out.println("Muchas gracias por utilizar nuestro servicio, vuelva pronto.");
                            login = 0;
                            break;     
                        default:
                            System.out.println("Opcion Incorrecta, por favor vuelva a intentarlo nuevamente");
                            break;
                    }
                }while (login == 0 ^ MenuOP == 6);
            }
        } while( flag == 0 );
        System.out.println("Salio exitosamente!");
        
    }

}