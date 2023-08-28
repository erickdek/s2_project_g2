package interfaces;

import TypeData.User;
import org.bson.types.ObjectId;

public interface GestorMethods {
	public ObjectId Login(User user);
	public boolean Register(User user);
	public double getPatrimonio(User user);
}
