/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments;


/**
 *
 * @author User
 */
public class Payment {
    private float amount;
    private int idPayment;
    private String PaymentType;

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    
    
    public Payment(float amount,int idPayment) {
        this.amount = amount;
        this.idPayment=idPayment;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" + "amount=" + amount + '}';
    }
    
}
