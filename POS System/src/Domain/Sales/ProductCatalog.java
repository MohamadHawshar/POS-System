/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import Domain.Sales.Item;
import TechnicalServices.Persistence.DataSource;
import TechnicalServices.Persistence.TransferFromDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ProductCatalog {

    public Map<Integer, Item> descriptions = new HashMap< Integer, Item>();

    public ProductCatalog() {
        loadSpecs();
    }

    public void loadSpecs() {
        ResultSet set = TransferFromDB.instance.getCatalog();
        int idItem;
        float price;
        String itemName;
        try {
            while (set.next()) {
                idItem = Integer.parseInt(set.getString(1));
                itemName = set.getString(2);
                price = Float.parseFloat(set.getString(3));
                descriptions.put(idItem,new Item(idItem,price,itemName));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    public Item getItem(int id) {
        return descriptions.get(id);
    }

    @Override
    public String toString() {
        return "ProductCatalog{" + "descriptions=" + descriptions + '}';
    }
    
    
}
