
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ManageMoney {
	//User
	protected String name;
    protected long CI;
    protected int role;
    protected String user;
    protected String pass;
    //Movimientos
    protected String descripcion;
    protected int tipo = 0;
    protected String date;
    protected float value;
    //Base
    protected File userFile = new File("src\\Data\\"+"users.txt");
    protected File transactionFile = new File("src\\Data\\"+"history.txt");
    //Gestor
    List<Movimientos> arrTransaction = new ArrayList<>();
    List<User> arrUsers = new ArrayList<>();

    double patrimonio = 0;
}
