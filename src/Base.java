import java.io.*;

//Template for save in the files: writer.write(id + "," + fecha1 + "," + cantidad + "," + fecha2 + "," + "\"" + descripcion + "\"\n");
//Asi es como se debera de guardar los datos.
//Eso se debe de pasar antes, en base solo solicitara el dato value asi que para ello en las clases hereedadas deberan de crear ese template.
//En la descripcion va a ser distinto ya que pueden agregar comas y eso nos estorbaria.
public class Base {
    //Almacenar los datos es ficheros
    File userFile = new File("src\\Data\\"+"users.txt");
    File transactionFile = new File("src\\Data\\"+"transactions.txt");
    
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
     * Funcion para establecer un dato
     * @param type Entero 0 = User, 1 = transaction
     * @param value String para guardar los datos ejemplo: id + "," + fecha1 + "," + cantidad + "," + fecha2 + "," + "\"" + descripcion + "\"\n"
     * @return Boolean True - si todo fue exitoso
    */
    public boolean get(int type){
        int count = 0;
        switch (type){
            case 0:
                //Visualizar los usuarios
                try {
                    count = 1;
                    BufferedReader inFile = new BufferedReader( new FileReader(this.userFile));
                    String dato = inFile.readLine(); // Lee una linea
                    while (dato != null) {
                        System.out.println(count + ": " + dato);
                        dato = inFile.readLine(); // Lee una linea mas
                        count ++;
                    }
                    inFile.close();
                    return true;
                } catch (FileNotFoundException e){
                    e.printStackTrace(System.out);
                } catch (IOException e){
                    e.printStackTrace(System.out);
                }
                break;
            case 1:
                //Visualizar los movimientos
                try {
                    count = 1;
                    BufferedReader inFile = new BufferedReader( new FileReader(this.transactionFile));
                    String dato = inFile.readLine(); // Lee una linea
                    while (dato != null) {
                        System.out.println(count + ": " + dato);
                        dato = inFile.readLine(); // Lee una linea mas
                        count ++;
                    }
                    inFile.close();
                    return true;
                } catch (FileNotFoundException e){
                    e.printStackTrace(System.out);
                } catch (IOException e){
                    e.printStackTrace(System.out);
                }
                break;
        }
        return false;
    }
    public boolean get(int type, int limit){
        switch (type){
            case 0:
                //Visualizar los usuarios
                try {
                    BufferedReader inFile = new BufferedReader( new FileReader(this.userFile));
                    for (int i = 0; i < limit; i++){
                        int count = i + 1;
                        String dato = inFile.readLine(); // Lee una linea
                        if (dato != null){
                            System.out.println( count + ": " + dato);
                        }
                    }
                    inFile.close();
                    return true;
                } catch (FileNotFoundException e){
                    e.printStackTrace(System.out);
                } catch (IOException e){
                    e.printStackTrace(System.out);
                }
                break;
            case 1:
                //Visualizar los movimientos
                try {
                    BufferedReader inFile = new BufferedReader( new FileReader(this.transactionFile));
                    String dato = inFile.readLine(); // Lee una linea
                    for (int i = 0; i < limit; i++){
                        int count = i + 1;
                        if (dato != null){
                            dato = inFile.readLine(); // Lee una linea
                            System.out.println( count + ": " + dato);
                        }
                    }
                    inFile.close();
                    return true;
                } catch (FileNotFoundException e){
                    e.printStackTrace(System.out);
                } catch (IOException e){
                    e.printStackTrace(System.out);
                }
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