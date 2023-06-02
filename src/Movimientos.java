import java.time.LocalDate; //Importar libreria para mostrar fecha 

//Para crear ingresos se debe de crear el template (comment in base), para pasarlo como value a Base.
public class Movimientos extends User {
    
    //Sirve para mostrar fecha actual
    protected LocalDate fecha = LocalDate.now();
    Base root = new Base();
    
    public String descripcion;
    public int tipo = 0;
    public float value;

    /*Metodos de la clase movimientos
    *Eliminar movimientos
    */
    public void delMovimientos(){

    }

    /**
     * Funcion para Registrar los Movimientos.
     * @param type 0 = Ingreso, 1 = Egreso.
     * @param amount Double de la cantidad todal.
     * @param date Fecha del movimiento.
     * @param desc Descripcion del movimiento.
     * @return boolean
    */ 
    public boolean setMovimiento(int type, double amount, LocalDate date, String desc){
        String result = "";
        try {
            result = ID + "," + type + "," + amount + "," + date + "," + "\"" + desc + "\"";
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
     * @param date Fecha del movimiento.
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
            root.get(1); //Aqui debe de haber un metodo de movimiento
            return;
        } catch (Exception e) {
            return;
        }
    }
}