/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain.Payments;

import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public interface PaymentAdapter {
    
    public void proceed() throws SQLException;
}
