/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.Sale;

/**
 *
 * @author User
 */
public class Register {
    private ProductCatalog productCatalog;
    private Sale sale; 

    public Register(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    
    public void endSale(){
        //TODO
    }
    public void enterItem(int id, int quantity){
       //TODO 
    }
    public void makeNewSale(){
        //TODO
    }
    public void makePayment(float amount){
        //TODO
    }
}
