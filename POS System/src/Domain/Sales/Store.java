/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import TechnicalServices.Persistence.Register;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class Store {
    private String location;
    private String name;
    private Register register;
    ProductCatalog productCatalog = new ProductCatalog();
    private List<Sale> SalesList = new ArrayList<>();

    private Store() {
        register = Register.instance;
        register.setProductCatalog(productCatalog);
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
