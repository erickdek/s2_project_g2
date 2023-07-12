import java.time.LocalDate;
import java.util.Scanner;

public interface GestorMethods {
	public boolean Login(Scanner sc);
	public boolean Register(Scanner sc);
	public void showPatrimonio();
	public void delMovimientos();
	public boolean setMovimiento(int type, double amount, LocalDate date, String desc);
	public boolean getMovimiento(int type, double amount, LocalDate date, String desc);
	public void getMovimientos();
	public void showUsers();
}
