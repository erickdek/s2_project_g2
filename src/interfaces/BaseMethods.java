package interfaces;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface BaseMethods {
	public boolean set( int type, Document doc );
	public FindIterable<Document> get(int type, Document doc);
	public FindIterable<Document> get(int type, Document doc, int limit);
        public FindIterable<Document> get(int type, Document doc, Document filter);
	public boolean put(int type, Document doc, Document put);
	public boolean del(int type, Document doc);
        public boolean del(int type, Document doc, boolean many);
}
