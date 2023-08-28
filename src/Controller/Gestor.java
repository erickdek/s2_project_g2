package Controller;

import TypeData.User;
import com.mongodb.client.FindIterable;
import interfaces.GestorMethods;
import interfaces.MovimientosMethods;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;

public class Gestor implements GestorMethods, MovimientosMethods {
    protected Base root = new Base(); //Acceso a los datos

    @Override
    public ObjectId Login(User user){
        ObjectId user_id = null;
        try {
            Document userFilter = new Document("user", user.getUser());
            Document existingUser = root.users.find(userFilter).first();

            if (existingUser == null) {
                JOptionPane.showMessageDialog(null, "No existe un usuario con ese nombre.");
                return user_id;
            }

            String storedPassword = existingUser.getString("pass");
            String inputPassword = user.getPass();

            if (BCrypt.checkpw(inputPassword, storedPassword)) {
                JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + user.getUser());
                return existingUser.getObjectId("_id");
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
                return user_id;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al iniciar sesión.");
            e.printStackTrace();
            return user_id;
        }
    }
    
    @Override
    public boolean Register(User user){
        try {
            Document existingUser = root.users.find(
                new Document("$or", Arrays.asList(
                        new Document("user", user.getUser()),
                        new Document("email", user.getEmail())
                ))).first();

            if (existingUser != null) {
                JOptionPane.showMessageDialog(null, "El usuario o el correo ya fue registrado.");
                return false;
            }

            // Encriptar la contraseña antes de almacenarla
            String hashedPassword = BCrypt.hashpw(user.getPass(), BCrypt.gensalt());

            Document newUser = new Document("user", user.getUser())
                    .append("email", user.getEmail())
                    .append("pass", hashedPassword)
                    .append("patrimonio", 0.0);
            root.set(0, newUser);

            JOptionPane.showMessageDialog(null, "Registro exitoso.");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al registrar.");
            e.printStackTrace();
            return false;
        }
    }


    //Metodos para el patrimonio ---------------------------------


    /**
     * Funcion para Mostrar el Patrimonio
     * @return double
    */ 
    @Override
    public double getPatrimonio(User user){
        try {
            //Obtenemos todos los movimientos
            double patriTotal = 0.0;
            double patriIngreso = 0.0;
            double patriEgreso = 0.0;
            Document doc = new Document("user_id", user.getId());
            root.get(1, doc);
            
            return patriTotal;
        } catch (Exception e) {
            return 0.0;
        }
    }


    //Metodos para los Movimientos -------------------------------
    

    /**
     * Funcion para Eliminar Movimientos.
     * @param doc Documentos con los valores para identificar a cual eliminar
     * @return boolean
    */ 
    @Override
    public boolean delMovimiento(Document doc){
        try {
            return root.del(1, doc);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el movimiento.");
        }
        return false;
    }

    /**
     * Funcion para Registrar los Movimientos.
     * @param doc Documento con los valores a guardar
     * @return boolean
    */ 
    @Override
    public boolean setMovimiento(Document doc){
        // 0 INGRESO - 1 EGRESO
        try {
            //Aqui debe de haber un metodo de movimiento
            return root.set(1, doc);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Funcion para Actualizar.
     * @param doc Documento con los valores a guardar
     * @return boolean
    */ 
    
    public boolean uptMovimiento(Document doc){
        // 0 INGRESO - 1 EGRESO
        try {
            //Aqui debe de haber un metodo de movimiento
            return root.set(1, doc);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Funcion para Obtener los Movimientos.
     * @param doc Ahi se debe de especificar los valores que deben de ser iguales para recuperarlos
     * @return boolean
    */ 
    @Override
    public FindIterable<Document> getMovimiento(Document doc){
        FindIterable<Document> documents = null;
        try {
            FindIterable<Document> docs = root.get(1, doc);
            documents = docs;
            
        } catch (Exception e){
            return documents;
        }
        return documents;
    }
}
