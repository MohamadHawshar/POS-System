/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.ProductCatalog;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PersistentStorage {
    private String endSaleString = "UPDATE `pos`.`sale` SET `isCompleted` = True WHERE `idSale` = ?;";
    private String enterLineItemString = "INSERT INTO `pos`.`salelineitem` (`Item_idItem`, `Sale_idSale`, `quantity`, `TotalPrice`) VALUES (?,?,?,?);";
    private String makeNewSaleString = "INSERT INTO `pos`.`sale` (`isCompleted`,`Date`) VALUES (?,?);";
    private String makePaymentString = "INSERT INTO `pos`.`payment` (`Date`, `Amount`, `isPaid`, `Sale_SaleID`) VALUES (?,?,?,?);";

    private PreparedStatement endSalesStmt;
    private PreparedStatement enterLineItemStmt;
    private PreparedStatement makeNewSaleStmt;
    private PreparedStatement makePaymentStmt;
//    private Register(ProductCatalog productCatalog) {
//        this.productCatalog = productCatalog;
//    }
    private PersistentStorage() {
        try {
            endSalesStmt = DataSource.getConnection().prepareStatement(endSaleString);
            enterLineItemStmt = DataSource.getConnection().prepareStatement(enterLineItemString);
            makeNewSaleStmt = DataSource.getConnection().prepareStatement(makeNewSaleString);
            makePaymentStmt = DataSource.getConnection().prepareStatement(makePaymentString);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
    public void endSale(int id) throws SQLException{
        endSalesStmt.setInt(1, id);
        endSalesStmt.executeUpdate();
    }
    public void enterLineItem(int quantity , int idSale, int idItem, float price) throws SQLException{
       //TODO 
        enterLineItemStmt.setInt(1, idItem);
        enterLineItemStmt.setInt(2, idSale);
        enterLineItemStmt.setInt(3, quantity);
        enterLineItemStmt.setFloat(4,price);
        enterLineItemStmt.executeUpdate();
    }
    public int makeNewSale() throws SQLException{
        //TODO
        //get the new sale id
        long millis=System.currentTimeMillis();
        makeNewSaleStmt.setBoolean(1, false);
        makeNewSaleStmt.setDate(2,new java.sql.Date(millis));
        return 0;
    }
    public void makePayment(float amount, int idSale) throws SQLException{
        //TODO
        long millis=System.currentTimeMillis();
        makePaymentStmt.setDate(1,new java.sql.Date(millis));
        makePaymentStmt.setFloat(2,amount);
        makePaymentStmt.setBoolean(3, true);
        makePaymentStmt.setInt(4, idSale);
        makePaymentStmt.executeUpdate();
    }
    public static final PersistentStorage instance = new PersistentStorage();
}

