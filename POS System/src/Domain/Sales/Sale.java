/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Sales;

import Domain.Payments.Payment;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Sale {
    private boolean isComplete;
    private Payment payment;
    private Date date;
    private List<SalesLineItem> ls = new ArrayList<>();

    public Sale(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    
    public void becomeComplete(){
        isComplete = true;
    }
    public void makeLineItem(Item item, int quantity){
        ls.add(new SalesLineItem(quantity,item));
    }
    public void makePayment(float amount){
        this.payment = new Payment(amount);
    }
    @Override
    public String toString() {
        return "Sale{" + "isComplete=" + isComplete + '}';
    }
    
    
}
