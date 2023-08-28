package Controller;

import TypeData.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
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
        double patriTotal = 0.0;
        try {
            //Obtenemos todos los movimientos
            Document doc = new Document("user_id", user.getId());
            FindIterable<Document> documents = root.get(1, doc);
        
            try (MongoCursor<Document> cursor = documents.iterator()) {
                while(cursor.hasNext()){
                    Document document = cursor.next();
                    if (document.getDouble("amount") != null){
                        if(document.getInteger("type") != 1){
                            patriTotal -= document.getDouble("amount");
                        } else{
                            patriTotal += document.getDouble("amount");
                        }

                    }
                }
                root.put(0, new Document("_id", user.getId()), new Document("patrimonio", patriTotal));
                return patriTotal;
            } catch (Exception e){
                System.out.println("Hubo un error : " + e);
            }
            return patriTotal;
        } catch (Exception e) {
            return patriTotal;
        }
    }
    
    /**
     * Funcion para Mostrar el Patrimonio
     * @return double
    */ 
    @Override
    public boolean putUser(Document doc, Document put){
        double patriTotal = 0.0;
        try {
            return root.put(0, doc, put);
        } catch (Exception e) {
            return false;
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
    @Override
    public boolean putMovimiento(Document doc, Document put){
        // 0 INGRESO - 1 EGRESO
        try {
            //Aqui debe de haber un metodo de movimiento
            return root.put(1, doc, put);
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
