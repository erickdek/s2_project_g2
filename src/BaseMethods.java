import java.io.File;

public interface BaseMethods {
	public boolean createFile(File fileData);
	public boolean checkFiles();
	public boolean checkFiles(User user);
	public boolean set( int type, String value );
	public String[] get(int type);
	public String[] get(int type, int limit);
	public boolean put(int type, int att, String value);
	public boolean del(int type, int att);
}
