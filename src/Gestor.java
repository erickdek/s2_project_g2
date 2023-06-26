import java.time.LocalDate;
import java.util.*;

public class Gestor {
    Base root = new Base(); //Acceso a archivos
    User user = new User(); //Usuario Actual

    List<Movimientos> arrTransaction = new ArrayList<>();
    List<User> arrUsers = new ArrayList<>();

    double patrimonio = 0;

    public boolean Login(Scanner sc){
        boolean login = false;
        try {
            sc.nextLine();
            //solicitmos los datos
            System.out.print("\nIngresa el nombre de usuario: ");
            String enterUser = sc.nextLine();
            System.out.print("Ingresa la contraseña: ");
            String enterPass = sc.nextLine();

            //Obtenemos todos los usuarios
            String[] usuarios = root.get(0);
            //Recorremos el array
            for (String usuarioData : usuarios) {
                String[] datos = usuarioData.split(",");
                if (datos[3].equals(enterUser) && datos[4].equals(enterPass)) {
                    login = true;
                    int role = Integer.parseInt(datos[0]);
                    long ci = Long.parseLong(datos[1]);
                    user = new User(role, ci, datos[2], datos[3], datos[4]); //Establecemos el usuario logeado
                    //Check User
                    root.checkFiles(user); //Chequeamos el archivo History del usuario actual
                    break;
                }
            }
            if (login == false){
                System.out.println("El usuario o la contraseña fue incorrecto...");
            }
            return login;
        } catch (Exception e) {
            System.out.print("\n Hubo un error: " + e.getMessage());
            return false;
        }
    }

    public boolean Register(Scanner sc){
        boolean login = false;
        try {
            sc.nextLine();
            System.out.print("\nIngresa tu Nombre: ");
            String enterName = sc.nextLine();
            System.out.print("\nIngresa tu Cedula/DNI: ");
            Long enterCI = sc.nextLong();
            System.out.print("\nIngresa tu username: ");
            String enterUser = sc.nextLine();
            System.out.print("\nIngresa tu Contraseña: ");
            String enterPass = sc.nextLine();
            System.out.print("\nVuelve a ingresar tu Contraseña: ");
            String enterRePass = sc.nextLine();
            
            return login;
        } catch (Exception e) {
            return false;
        }
    }


    //Metodos para el patrimonio ---------------------------------


    /**
     * Funcion para Mostrar el Patrimonio
     * @return void
    */ 
    public void showPatrimonio(){
        //Proximamente V2.1
    }


    //Metodos para los Movimientos -------------------------------
    

    /**
     * Funcion para Eliminar Movimientos.
     * @param type 0 = Ingreso, 1 = Egreso.
     * @param amount Double de la cantidad todal.
     * @param date Fecha del movimiento.
     * @param desc Descripcion del movimiento.
     * @return boolean
    */ 
    public void delMovimientos(){
        //proximamente
    }

    /**
     * Funcion para Registrar los Movimientos.
     * @param type 0 = Ingreso, 1 = Egreso.
     * @param amount Double de la cantidad todal.
     * @param date Fecha del movimiento - LocalDate.
     * @param desc Descripcion del movimiento.
     * @return boolean
    */ 
    public boolean setMovimiento(int type, double amount, LocalDate date, String desc){
        String result = "";
        try {
            result = type + "," + amount + "," + date + "," + "\"" + desc + "\"";
            root.set(1, result); //Aqui debe de haber un metodo de movimiento
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Funcion para Registrar los Movimientos.
     * @param type 0 = Ingres0, 1 = Egreso.
     * @param amount Double de la cantidad todal.
     * @param date Fecha del movimiento - LocalDate.
     * @param desc Descripcion del movimiento.
     * @return boolean
    */ 
    public boolean getMovimiento(int type, double amount, LocalDate date, String desc){
        return true;
    }

    /**
     * Funcion para Visualizar todos los movimientos.
     * @param type 0 = Ingres0, 1 = Egreso.
     * @param amount Double de la cantidad todal.
     * @param date Fecha del movimiento.
     * @param desc Descripcion del movimiento.
     * @return boolean
    */ 
    public void getMovimientos(){
        try {
            //Obtenemos todos los movimientos
            String[] transaction = root.get(1);
            String tipo;
            //Recorremos el array
            for (String infoTransaction : transaction) {
                String[] datos = infoTransaction.split(",");
                if (Integer.parseInt(datos[0]) == 1){tipo = "Egreso";} else {tipo = "Ingreso";}
                System.out.print(
                     "\nTipo: " + tipo +
                    " - Cantidad: " + datos[1] +
                    " - Fecha: " + datos[2] +
                    " - Descripcion: " + datos[3]
                );
            }
            return;
        } catch (Exception e) {
            return;
        }
    }

    public void showUsers(){
        //Obtenemos todos los usuarios
        String[] usuarios = root.get(0);
        //Recorremos el array
        for (String usuarioData : usuarios) {
            String[] datos = usuarioData.split(",");
            System.out.print(
                "\nRole: " + datos[0] +
                "\nCI: " + datos[1] +
                "\nNombre: " + datos[2] +
                "\nUser: " + datos[3] +
                "\nPass: " + datos[4] +
                "\n"
            );
        }
    }
}
