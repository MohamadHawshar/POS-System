/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import Domain.Payments.Payment;
import TechnicalServices.Persistence.Register;
import TechnicalServices.Persistence.TransferFromDB;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Store {

    private String location;
    private String name;
    private Register register;
    ProductCatalog productCatalog = new ProductCatalog();
    private List<Sale> salesList = new ArrayList<>();

    private Store() {
        register = Register.instance;
        register.setProductCatalog(productCatalog);
        try {
            loadSpecs();
        } catch (SQLException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void loadSpecs() throws SQLException {
        ResultSet set = TransferFromDB.instance.getSales();
        Date d;
        int saleID;
        boolean isComplete;
        int itemID, quantity;
        float price;
        List<SalesLineItem> salesLineItems = new ArrayList<>();
        float totalPrice = 0;
        String type = null;
        try {
            while (set.next()) {
                saleID = Integer.parseInt(set.getString(1));
                d = set.getDate(2);
                isComplete = set.getBoolean(3);

                ResultSet set2 = TransferFromDB.instance.getSalesLineItems(saleID);
                salesLineItems = new ArrayList<>();
                
               

                while (set2.next()) {
                    itemID = Integer.parseInt(set2.getString(1));
                    quantity = Integer.parseInt(set2.getString(3));
                    price = Float.parseFloat(set2.getString(4));

                    Item item = register.getCatalog().getItem(itemID);

                    SalesLineItem s = new SalesLineItem(quantity, item, price);
                    s.setIdSale(saleID);

                    salesLineItems.add(s);

                }set2.close();

                ResultSet set3 = TransferFromDB.instance.getPayment(saleID);
                while (set3.next()) {
                    totalPrice = Float.parseFloat(set3.getString(1));
                    type = set3.getString(2);
                }
                set3.close();
                
                Payment p = new Payment(totalPrice, saleID);
                p.setPaymentType(type);
                

                Sale x = new Sale(isComplete, d, saleID);
                x.setPayment(p);
                x.setLs(salesLineItems);
                salesList.add(x);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Sale> getSalesList() {
        return salesList;
    }

    public Register getRegister() {
        return register;
    }

    public Store(String location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" + "location=" + location + ", name=" + name + '}';
    }

    public static final Store instance = new Store();
}
