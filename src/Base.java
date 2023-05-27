import java.io.*;

public class Base {
    //Almacenar los datos es ficheros
    File userFile = new File("src\\Data\\"+"users.txt");
    File transactionFile = new File("src\\Data\\"+"transactions.txt");
    
    private boolean createFile(File fileData){
        try {
            PrintWriter write = new PrintWriter(fileData);
            write.close();
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
        if (!transactionFile.exists() || transactionFile.isDirectory()){
            this.createFile(transactionFile);
        }
        return true;
    }

    /**
     * Funcion para establecer un dato
     * @param type Entero 0 = User, 1 = transaction
     * @param value String para guardar los datos ejemplo: id nombre apellido ci patrimonio pass
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
        } catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean get(int type, int att){
        switch (type){
            case 0:
                //Registrar un usuario
                try {
                    BufferedReader inFile = new BufferedReader( new FileReader(this.userFile));
                    inFile.readLine(); // Lee una linea
                    inFile.close();
                    System.out.println("Se guardo los datos.");
                    return true;
                } catch (FileNotFoundException e){
                    e.printStackTrace(System.out);
                } catch (IOException e){
                    e.printStackTrace(System.out);
                }
                break;
            case 1:
                //Registrar un movimiento
                break;
        }
        return false;
    }

    public boolean put(int type, int att, String value){
        return false;
    }

    public boolean del(int type, int att){
        return false;
    }

}