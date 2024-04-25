/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mongo.mongoaerolineas_fabricio;

import daos.DAOAerolineas;
import modelos.Aerolinea;
import org.bson.types.ObjectId;

/**
 *
 * @author fabri
 */
public class MongoAerolineas_Fabricio {

    public static void main(String[] args) {
        ObjectId ob = new ObjectId("662ad1a5f14c5a277475bccc");
        DAOAerolineas dao = new DAOAerolineas();
//        dao.agregarAerolinea(new Aerolinea("avion123","mexico", "mxn",true));
        dao.eliminarAerolinea(ob);


    }
}
