/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.Item;
import Domain.Sales.ProductCatalog;
import Domain.Sales.Sale;
import com.sun.jndi.ldap.PersistentSearchControl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Register {
    // the Register server as the port which the Persistence package communicate with other packages.
    // it calls the two controllers that are in charge of handling the communication with the database.
    private ProductCatalog productCatalog;

    public void endSale(int idSale) throws SQLException {
        PersistentStorage.instance.endSale(idSale);
    }

    public void enterLineltem(int idItem,int idSale, int quantity) throws SQLException {
        
        float price = quantity*productCatalog.descriptions.get(idItem).getPrice();
        PersistentStorage.instance.enterLineItem(quantity, idSale, idItem,price);

    }

    public Sale makeNewSale() throws SQLException {

        return PersistentStorage.instance.makeNewSale();

    }

    public void makePayment(float amount , int idSale) throws SQLException {

        PersistentStorage.instance.makePayment(amount, idSale);

    }
    
    public Item getItem(int idItem){
        return productCatalog.getItem(idItem);
    }
    
    public ProductCatalog getCatalog(){
        return productCatalog;
    }
    public void addItem(Item i) throws SQLException{
        PersistentStorage.instance.addItem(i.getIdItem(), i.getItemName(), i.getPrice());
        productCatalog.descriptions.put(i.getIdItem(), i);
    }
    public static final Register instance = new Register();

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
}
