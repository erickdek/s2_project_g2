import java.time.LocalDate;
import java.util.*;

public class Gestor extends ManageMoney implements GestorMethods{
    protected Base root = new Base(); //Acceso a archivos
    protected User usr = new User(); //Usuario Actual

	@Override
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
                    usr = new User(role, ci, datos[2], datos[3], datos[4]); //Establecemos el usuario logeado
                    //Check User
                    root.checkFiles(usr); //Chequeamos el archivo History del usuario actual
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
    
    @Override
    public boolean Register(Scanner sc){
        boolean login = false;
        try {
            String enterPass,enterRePass,enterName,enterUser;
            boolean flag = false;
            sc.nextLine();
            int Role = 0;

            System.out.print("\nIngresa tu Nombre: ");
            enterName = sc.nextLine();

            System.out.print("\nIngresa tu Cedula/DNI: ");
            Long enterCI = sc.nextLong();

            sc.nextLine(); //Limpiar

            System.out.print("\nIngresa tu username: ");
            enterUser = sc.nextLine();
            //PASSWORD
            do{
                flag = false;
                System.out.print("\nIngresa tu Contraseña: ");
                enterPass = sc.nextLine();

                System.out.print("\nVuelve a ingresar tu Contraseña: ");
                enterRePass = sc.nextLine();

                if (!enterPass.equals(enterRePass)){
                    flag = true;
                    System.out.println("Las contraseñas no coinciden");
                }
            } while (flag);

            String result = "";
            try {
                result =  Role + "," + enterCI + "," + enterName + "," + enterUser + "," + enterPass;
                if(root.set(0, result)) {
                    login = true;
                    usr = new User(role, enterCI, enterName, enterUser, enterPass); //Establecemos el usuario logeado
                    //Check User
                    root.checkFiles(usr); //Chequeamos el archivo History del usuario actual
                }; //Aqui debe de haber un metodo de movimiento
            } catch (Exception e) {
                return false;
            }
            
            return login;
        } catch (Exception e) {
            System.out.print("\n Hubo un error: " + e.getMessage());
            return false;
        }
    }


    //Metodos para el patrimonio ---------------------------------


    /**
     * Funcion para Mostrar el Patrimonio
     * @return void
    */ 
    @Override
    public void showPatrimonio(){
        try {
            //Obtenemos todos los movimientos
            String[] transaction = root.get(1);
            double patriTotal = 0.0;
            double patriIngreso = 0.0;
            double patriEgreso = 0.0;
            //Recorremos el array
            for (String infoTransaction : transaction) {
                String[] datos = infoTransaction.split(",");
                if (Integer.parseInt(datos[0]) == 0){
                    patriIngreso += Double.parseDouble(datos[1]);
                } else {
                    patriEgreso += Double.parseDouble(datos[1]);
                }
            }
            patriTotal = patriIngreso - patriEgreso;
            System.out.println(
                "Su Patrimonio es: $USD" + patriTotal +
                "\nTotal de Ingresos: $USD" + patriIngreso +
                "\nTotal de Egresos: $USD:" + patriEgreso
            );
            return;
        } catch (Exception e) {
            return;
        }
    }


    //Metodos para los Movimientos -------------------------------
    

    /**
     * Funcion para Eliminar Movimientos.
     * @param numLine numero de linea a eliminar
     * @return boolean
    */ 
    @Override
    public void delMovimientos(int numLine){
        //proximamente
        if(root.del(1, numLine)){
            System.out.println("Dato eliminado correctamente...");
        };
    }

    /**
     * Funcion para Registrar los Movimientos.
     * @param type 0 = Ingreso, 1 = Egreso.
     * @param amount Double de la cantidad todal.
     * @param date Fecha del movimiento - LocalDate.
     * @param desc Descripcion del movimiento.
     * @return boolean
    */ 
    @Override
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
    @Override
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
    @Override
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

    @Override
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
