import java.time.LocalDate; //Importar libreria para mostrar fecha 

public class Movimientos extends User {

    //Sirve para mostrar fecha actual
    protected LocalDate fecha = LocalDate.now();
    
    public String descripcion;
    public int tipo = 0;
    public float value;

    /*Metodos de la clase movimientos
    *Eliminar movimientos
    */
    public void eliminarmov(){

    }

    //Permite Registrar Ingresos
    public void regingresos(){

    }

    //Permite Registrar Egresos
    public void regegresos(){

    }
}