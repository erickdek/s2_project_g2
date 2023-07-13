import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Template for save in the files: writer.write(id + "," + fecha1 + "," + cantidad + "," + fecha2 + "," + "\"" + descripcion + "\"\n");
public class Base extends ManageMoney implements BaseMethods{
	@Override
    public boolean createFile(File fileData){
        try {
            PrintWriter write = new PrintWriter(fileData); //Crear el archivo con el nombre fileData
            write.close(); //Cerramos el archivo.
            return true;
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
            System.out.print("\nHubo un error: " + e.getMessage());
            return false;
        }
    }
    @Override
    public boolean checkFiles(){
        //Check userFile
        if (!userFile.exists() || userFile.isDirectory()){
            this.createFile(userFile);
        }
        return true;
    }
    @Override
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
    @Override
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
            System.out.print("\nHubo un error: " + e.getMessage());
        } catch (IOException e){
            e.printStackTrace(System.out);
            System.out.print("\nHubo un error: " + e.getMessage());
        }
        return false;
    }

    /**
     * Funcion para Obtener los datos
     * @param type Entero 0 = User, 1 = transaction
     * @param limit Entero Limite de datos para mostrar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
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
                    System.out.print("\nHubo un error: " + e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                    System.out.print("\nHubo un error: " + e.getMessage());
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
                    System.out.print("\nHubo un error: " + e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                    System.out.print("\nHubo un error: " + e.getMessage());
                }
                break;
            }
        return result.toArray(new String[0]);
    }
    
    @Override
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
                    System.out.print("\nHubo un error: " + e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                    System.out.print("\nHubo un error: " + e.getMessage());
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
                    System.out.print("\nHubo un error: " + e.getMessage());
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                    System.out.print("\nHubo un error: " + e.getMessage());
                }
                break;
            }
        return result.toArray(new String[0]);
    }
    @Override
    public boolean put(int type, int att, String value){
        return false;
    }
    
    /**
     * Funcion para Eliminar una fila del fichero
     * @param type Entero 0 = User, 1 = transaction
     * @param numLine Entero numero de linea a eliminar
     * @return Boolean True - si todo fue exitoso
    */
    @Override
    public boolean del(int type, int numLine){
        switch (type) {
            case 0:
                // Obtener los usuarios
                try {
                    System.out.println("Eliminando...");
                    File tempFile = new File("src\\Data\\tempData.txt");
                    BufferedReader userFileReader = new BufferedReader(new FileReader(this.userFile));
                    BufferedWriter writerTempFile = new BufferedWriter(new FileWriter(tempFile));
                    
                    int linecurrent = 0;
                    String line; // Guardas las lecturas
                    while ((line = userFileReader.readLine()) != null) {
                        linecurrent++; //Sumamos una linea mas sumada
                        if(linecurrent == numLine) continue;
                        writerTempFile.write(line + System.getProperty("line.separator"));
                    }

                    userFileReader.close();
                    writerTempFile.close();
                    this.userFile.delete();
                    tempFile.renameTo(this.userFile);
                    return true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
                break;
            case 1:
                // Obtener los movimientos
                try {
                    System.out.println("Eliminando...");
                    File tempFile = new File("src\\Data\\tempData.txt");
                    BufferedReader transactionFileReader = new BufferedReader(new FileReader(this.transactionFile));
                    BufferedWriter writerTempFile = new BufferedWriter(new FileWriter(tempFile));
                    
                    int linecurrent = 0;
                    String line; // Guardas las lecturas
                    while ((line = transactionFileReader.readLine()) != null) {
                        linecurrent++; //Sumamos una linea mas sumada
                        if(linecurrent == numLine) continue;
                        writerTempFile.write(line + System.getProperty("line.separator"));
                    }

                    transactionFileReader.close();
                    writerTempFile.close();
                    this.transactionFile.delete();
                    tempFile.renameTo(this.transactionFile);
                    return true;
                } catch (FileNotFoundException e) {
                    e.printStackTrace(System.out);
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
                break;
            }
        return false;
    }

}