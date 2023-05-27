public class User extends Base {
    //Declaracion de variables
    public String name;
    protected int CI;
    protected long ID;
    protected int role;
    protected String user;
    protected String pass;

    //Encapsulamiento
    /**
     * Funcion para establecer un nombre
     * @param name Nombre del usuario
     * @return None
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Funcion para obtener el nombre
     * @param name Nombre del usuario
     * @return None
    */
    public String getName() {
        return name;
    }

    public void setCI(int cI) {
        CI = cI;
    }

    public int getCI() {
        return CI;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public long getID() {
        return ID;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public String getPass() {
        return pass;
    }
}