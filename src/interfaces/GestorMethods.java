package interfaces;

import TypeData.User;
import org.bson.Document;
import org.bson.types.ObjectId;

public interface GestorMethods {
	public ObjectId Login(User user);
	public boolean Register(User user);
	public double getPatrimonio(User user);
        public boolean putUser(Document doc, Document put);
}
