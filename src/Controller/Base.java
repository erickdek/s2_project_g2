package Controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import interfaces.BaseMethods;
import javax.swing.JOptionPane;
import org.bson.Document;

public class Base implements BaseMethods{
    //CONNECT TO DATABASE
    private MongoDatabase DB = new DB_MongoDB().ConnectDB();
    
    public MongoCollection<Document> users;
    public MongoCollection<Document> movimientos;
    
    public Base(){
        users = DB.getCollection("users");
        movimientos = DB.getCollection("transactions");
        
        //CREAMOS INDICES
        users.createIndex(new Document("user", 1), new IndexOptions().unique(true));
        users.createIndex(new Document("email", 1), new IndexOptions().unique(true));
    }
    
    /**
     * Funcion para establecer un dato
     * @param type Entero 0 = User, 1 = transaction
     * @param doc Docmento con los valores a guardar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public boolean set( int type, Document doc ){
        switch (type){
            case 0:
                //Registrar un usuario
                try {
                    users.insertOne(doc);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al registrar el usuario");
                }
                break;
            case 1:
                //Registrar un movimiento
                try {
                    movimientos.insertOne(doc);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al registrar un movimiento");
                }
                break;
        }
        return false;
    }

    /**
     * Funcion para Obtener los datos
     * @param type Entero 0 = User, 1 = transaction
     * @param doc Documento que nos ayudara a dar el ID del usuario
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public FindIterable<Document> get(int type, Document doc) {
        FindIterable<Document> documents = null;
        switch (type) {
            case 0:
                // Obtener los usuarios
                try {
                    FindIterable<Document> docs = users.find();
                    if (doc != null){
                        docs = users.find(doc);
                    }
                    
                    documents = docs;
                } catch(Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al obtener los datos.");
                }
                break;
            case 1:
                // Obtener los movimientos
                try {
                    FindIterable<Document> docs = movimientos.find();
                    if (doc != null){
                        docs = movimientos.find(doc);
                    }
                    documents = docs;
                } catch(Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al obtener los datos.");
                }
                break;
            }
        return documents;
    }
    
    /**
     * Funcion para Obtener los datos
     * @param type Entero 0 = User, 1 = transaction
     * @param limit Entero Limite de datos para mostrar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public FindIterable<Document> get(int type, Document doc, int limit) {
        FindIterable<Document> documents = null;
        switch (type) {
            case 0:
                // Obtener los usuarios
                
                break;
            case 1:
                // Obtener los movimientos
                
                break;
            }
        return documents;
    }
    /**
     * Funcion para Obtener los datos
     * @param type Entero 0 = User, 1 = transaction
     * @param filter Documento para filtrar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public FindIterable<Document> get(int type, Document doc, Document filter) {
        FindIterable<Document> documents = null;
        switch (type) {
            case 0:
                // Obtener los usuarios
                
                break;
            case 1:
                // Obtener los movimientos
                
                break;
            }
        return documents;
    }
    
    /**
     * Funcion para Actualizar un dato
     * @param type Entero 0 = User, 1 = transaction
     * @param doc Documento a buscar
     * @param put Documento con los nuevos valores a actualizar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public boolean put(int type, Document doc, Document put){
        // Crear un documento con los nuevos valores
        Document update = new Document("$set", put);
        
        switch (type) {
            case 0:
                //USUARIOS
                try {
                    // Actualizar el documento
                    users.updateOne(doc, update);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar un dato.");
                }
                break;
            case 1:
                //MOVIMIENTOS
                try {
                    movimientos.updateOne(doc, update);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar un dato.");
                }
                break;
            }
        return false;
    }
    
    /**
     * Funcion para Eliminar un dato
     * @param type Entero 0 = User, 1 = transaction
     * @param doc Documento con los valores a buscar al que se desea eliminar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public boolean del(int type, Document doc){
        switch (type) {
            case 0:
                //USUARIOS
                try {
                    users.deleteOne(doc);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar un dato.");
                }
                break;
            case 1:
                //MOVIMIENTOS
                try {
                    movimientos.deleteOne(doc);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar un dato.");
                }
                break;
            }
        return false;
    }

    @Override
    public boolean del(int type, Document doc, boolean many) {
        switch (type) {
            case 0:
                //USUARIOS
                try {
                    users.deleteMany(doc);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar un dato.");
                }
                break;
            case 1:
                //MOVIMIENTOS
                try {
                    movimientos.deleteMany(doc);
                    return true;
                } catch (Exception e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar un dato.");
                }
                break;
            }
        return false;
    }

}