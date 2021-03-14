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
public class LebanonTax extends Tax implements TaxAdapter{

    public LebanonTax(float netAmount) {
        super(netAmount);
    }

    @Override
    public float taxPercentage(int s) {
        this.setTaxPercentage(s);
        return (getNetAmount()* getTaxPercentage()/100);
    }

}
