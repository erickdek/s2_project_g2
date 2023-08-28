package interfaces;

import TypeData.User;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface MovimientosMethods {
    public boolean delMovimiento(Document doc);
    public boolean setMovimiento(Document doc);
    public FindIterable<Document> getMovimiento(Document doc);
    public boolean putMovimiento(Document doc, Document put);
}
