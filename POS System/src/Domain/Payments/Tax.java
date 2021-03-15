/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments;

/**
 *
 * @author lenovo
 */
public class Tax {
    private int taxPercentage;
    private float taxAmount,netAmount;
    
    
    public Tax( float netAmount) {
        this.netAmount = netAmount;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Float netAmount) {
        this.netAmount = netAmount;
    }

}
