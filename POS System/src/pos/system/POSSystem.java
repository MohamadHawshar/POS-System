/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.system;

import Domain.Sales.Store;
import TechnicalServices.Persistence.Register;
import UI.ProcessSaleJFrame;

/**
 *
 * @author User
 */
public class POSSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Store store = Store.instance;
        store.setName("Lebanon");
        Register register = store.getRegister();
        ProcessSaleJFrame frame = new ProcessSaleJFrame(register);
    }
    
}
