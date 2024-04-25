/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mongo.mongoaerolineas_fabricio;

import daos.DAOAerolineas;
import modelos.Aerolinea;

/**
 *
 * @author fabri
 */
public class MongoAerolineas_Fabricio {

    public static void main(String[] args) {
        DAOAerolineas dao = new DAOAerolineas();
        dao.agregarAerolinea(new Aerolinea("avion123","mexico", "mxn",true));



    }
}
