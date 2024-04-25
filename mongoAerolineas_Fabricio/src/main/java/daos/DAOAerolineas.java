package daos;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;
import com.mongodb.client.MongoClient;
//import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import modelos.Aerolinea;

public class DAOAerolineas {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAOAerolineas() {
                    com.mongodb.client.MongoClient mongoClient = MongoClients.create("mongodb+srv://chinoantrax69nini19:f48r1c10@cluster0.iwwnzlu.mongodb.net/");

//        mongoClient = new MongoClient("mongodb+srv://chinoantrax69nini19:f48r1c10@cluster0.iwwnzlu.mongodb.net/");
        database = mongoClient.getDatabase("aeropuerto");
        collection = database.getCollection("aviones");

    }

    public ArrayList<Aerolinea> obtenerAerolineas() {
        ArrayList<Aerolinea> aerolineas = new ArrayList();

        MongoCursor<Document> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
                Document d = cursor.next();
                Aerolinea a = new Aerolinea(d.getObjectId("_id"), d.getString("name"), d.getString("country"), d.getString("currency"), d.getBoolean("lowcost") == null ? false : true);
                aerolineas.add(a);
//                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return aerolineas;
    }

    public boolean agregarAerolinea(Aerolinea aerolinea) {
        Document d = new Document("nombre", aerolinea.getNombre())
                .append("pais", aerolinea.getPais())
                .append("moneda", aerolinea.getMoneda())
                .append("economica", aerolinea.isEconomica());

        collection.insertOne(d);
        return true;
    }
}
