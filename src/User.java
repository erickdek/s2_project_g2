public class User {
    //Declaracion de variables
    private String name;
    private long CI;
    private int role;
    private String user;
    private String pass;

    public User(){
        //Constructor vacio
    };

    public User(int role, long CI, String name, String user, String pass) {
        this.name = name;
        this.CI = CI;
        this.role = role;
        this.user = user;
        this.pass = pass;
    }
    
    //Encapsulamiento
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCI(long cI) {
        CI = cI;
    }

    public long getCI() {
        return CI;
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