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
    private int saleID;

    public Sale(boolean isComplete, Date date,int saleID) {
        this.isComplete = isComplete;
        this.date = date;
        this.saleID=saleID;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    

    public boolean isIsComplete() {
        return isComplete;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    
    public void becomeComplete(){
        isComplete = true;
    }
    public SalesLineItem makeLineItem(Item item, int quantity,float price){
        ls.add(new SalesLineItem(quantity,item,price));
        return new SalesLineItem(quantity,item,price);
    }
    public void makePayment(float amount){
        this.payment = new Payment(amount,saleID);
    }
    @Override
    public String toString() {
        return "Sale{" + "isComplete=" + isComplete + '}';
    }

    public Payment getPayment() {
        return payment;
    }

    public Date getDate() {
        return date;
    }

    public List<SalesLineItem> getLs() {
        return ls;
    }

    public void setLs(List<SalesLineItem> ls) {
        this.ls = ls;
    }
    
    
}
