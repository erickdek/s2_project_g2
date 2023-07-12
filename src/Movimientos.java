//Para crear ingresos se debe de crear el template (comment in base), para pasarlo como value a Base.
public class Movimientos extends ManageMoney{
//    public String descripcion;
//    public int tipo = 0;
//    public String date;
//    public float value;

    public Movimientos(int tipo, float value, String date, String desc) {
        this.descripcion = desc;
        this.tipo = tipo;
        this.date = date;
        this.value = value;
    }
}