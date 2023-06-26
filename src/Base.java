import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Template for save in the files: writer.write(id + "," + fecha1 + "," + cantidad + "," + fecha2 + "," + "\"" + descripcion + "\"\n");
public class Base {
    //Almacenar los datos es ficheros
    File userFile = new File("src\\Data\\"+"users.txt");
    File transactionFile = new File("src\\Data\\"+"history.txt");
    
    private boolean createFile(File fileData){
        try {
            PrintWriter write = new PrintWriter(fileData); //Crear el archivo con el nombre fileData
            write.close(); //Cerramos el archivo.
            System.out.println("Archivo Creado."); 
            return true;
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
            return false;
        }
    }

    public boolean checkFiles(){
        //Check userFile
        if (!userFile.exists() || userFile.isDirectory()){
            this.createFile(userFile);
        }
        return true;
    }
    public boolean checkFiles(User user){
        //Check userFile
        File userTransaction = new File("src\\Data\\"+ user.getUser() + "-history.txt");
        this.transactionFile = userTransaction;
        
        if (!userFile.exists() || userFile.isDirectory()){
            this.createFile(userFile);
        }
        if (!transactionFile.exists() || transactionFile.isDirectory()){
            this.createFile(transactionFile);
        }
        return true;
    }

    /**
     * Funcion para establecer un dato
     * @param type Entero 0 = User, 1 = transaction
     * @param value String para guardar los datos ejemplo: id + "," + fecha1 + "," + cantidad + "," + fecha2 + "," + "\"" + descripcion + "\"\n"
     * @return Boolean True - si todo fue exitoso
    */
    public boolean set( int type, String value ){
        File data = this.userFile;
        switch (type){
            case 0:
                //Registrar un usuario
                data = this.userFile;
                break;
            case 1:
                //Registrar un movimiento
                data = this.transactionFile;
                break;
        }
        try {
            PrintWriter outData = new PrintWriter(new FileWriter(data, true));
            outData.println(value);
            outData.close();
            System.out.println("Se guardo los datos.");
            return true;
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
        return false;
    }

    /**
     * Funcion para Obtener los datos
     * @param type Entero 0 = User, 1 = transaction
     * @param limit Entero Limite de datos para mostrar
     * @return Boolean True - si todo fue exitoso
    */
    public String[] get(int type) {
        List<String> result = new ArrayList<>();
        switch (type) {
            case 0:
                // Obtener los usuarios
                try {
                    BufferedReader userFileReader = new BufferedReader(new FileReader(this.userFile));
                    String line = userFileReader.readLine(); // Lee una línea
                    while (line != null) {
                        result.add(line);
                        line = userFileReader.readLine(); // Lee una línea más
                    }
                    userFileReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
                break;
            case 1:
                // Obtener los movimientos
                try {
                    BufferedReader transactionFileReader = new BufferedReader(new FileReader(this.transactionFile));
                    String line = transactionFileReader.readLine(); // Lee una línea
                    while (line != null) {
                        result.add(line);
                        line = transactionFileReader.readLine(); // Lee una línea más
                    }
                    transactionFileReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
                break;
            }
        return result.toArray(new String[0]);
    }
    public String[] get(int type, int limit) {
        List<String> result = new ArrayList<>();
        switch (type) {
            case 0:
                // Obtener los usuarios
                try {
                    BufferedReader userFileReader = new BufferedReader(new FileReader(this.userFile));
                    String line = userFileReader.readLine(); // Lee una línea
                    while (line != null && result.size() < limit) {
                        result.add(line);
                        line = userFileReader.readLine(); // Lee una línea más
                    }
                    userFileReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
                break;
            case 1:
                // Obtener los movimientos
                try {
                    BufferedReader transactionFileReader = new BufferedReader(new FileReader(this.transactionFile));
                    String line = transactionFileReader.readLine(); // Lee una línea
                    while (line != null && result.size() < limit) {
                        result.add(line);
                        line = transactionFileReader.readLine(); // Lee una línea más
                    }
                    transactionFileReader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
                break;
            }
        return result.toArray(new String[0]);
    }

    public boolean put(int type, int att, String value){
        return false;
    }

    public boolean del(int type, int att){
        return false;
    }

}