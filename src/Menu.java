import java.util.*;
public class Menu {

    public void ShowCurrentUser(User user){
        System.out.print(
            "\n" +
            "\n Usuario: " + user.getName() +
            "\n C.I.: " + user.getCI() +
            "=======================================\n"
        );
    }

    public int loginUser(Scanner sc){
        int op = 0;
        System.out.print(
            "\n" +
            "=======================================\n"+
            "       Bienvenido a ManageMoney      \n"+
            "=======================================\n"+
            "¿Que quieres hacer? \n"+
            "1. Identificarme \n"+ 
            "2. Registrarme \n"+
            "3. Salir \n"+
            "=======================================\n" +
            "Ingrese una opcion: "
        );
        op = getIOInt(sc, -9);
        return op;
    }

    public int MenuPrincipal(Scanner sc){
        int op = 0;
        System.out.print(
            "\n" +
            "================= MENU ================\n"+
            "1. Registrar ingreso. \n"+
            "2. Registrar engreso. \n"+ 
            "3. Eliminar movimientos. \n"+
            "4. Historial de movimientos. \n"+
            "5. Ver Patrimonio. \n" +
            "6. Cerrar Sesion. \n" +
            "=======================================\n" +
            "Ingrese una opcion: "
        );
        op = getIOInt(sc, -9);
        return op;
    }

    
    //Capturar String y capturar errores en caso de ingrese un dato no valido
    public static String getIOString(Scanner sc){
        try {
            String data;
            data = sc.nextLine();
            return data;
        } catch (Exception e) {
            System.out.println("Ingresaste un dato no valido!");
            return null;
        }
    }

    //Capturar INT y capturar errores en caso de ingrese un dato no valido
    public static int getIOInt(Scanner sc, int defaultV){
        try {
            int data;
            data = sc.nextInt();
            return data;
        } catch (Exception e) {
            System.out.println("Ingresaste un dato no valido!");
            return defaultV;
        }
    }
}
