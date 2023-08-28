package TypeData;

//Para crear ingresos se debe de crear el template (comment in base), para pasarlo como value a Base.
public class Movimientos{
    String descripcion;
    int tipo;
    double value;
    String date;
    
    public Movimientos(int tipo, double value, String date, String desc) {
        this.descripcion = desc;
        this.tipo = tipo;
        this.date = date;
        this.value = value;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}