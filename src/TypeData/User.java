package TypeData;

import org.bson.types.ObjectId;

public class User{
    ObjectId id;
    String user;
    String pass;
    String email;
    double patrimonio;
    
    public User(){
        //Constructor vacio
    };

    public User(String email, String user, String pass) {
        this.email = email;
        this.user = user;
        this.pass = pass;
        this.patrimonio = 0;
    }
    
    //Encapsulamiento
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }
    
    public void addPatrimonio(double patrimonio) {
        this.patrimonio += patrimonio;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}