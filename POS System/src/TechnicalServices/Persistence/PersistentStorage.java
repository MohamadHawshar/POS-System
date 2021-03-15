/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.ProductCatalog;
import Domain.Sales.Sale;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PersistentStorage {

    private String endSaleString = "UPDATE `mydb`.`sale` SET `isCompleted` = True WHERE `idSale` = ?;";
    private String enterLineItemString = "INSERT INTO `mydb`.`salelineitem` (`Item_idItem`, `Sale_idSale`, `quantity`, `TotalPrice`) VALUES (?,?,?,?);";
    private String makeNewSaleString = "INSERT INTO `mydb`.`sale` (`isCompleted`,`Date`) VALUES (?,?);";
    private String makePaymentString = "INSERT INTO `mydb`.`payment` ( `Amount`, `Sale_SaleID`,`PaymentType`) VALUES (?,?,?);";
    private String enterItemString = "INSERT INTO `mydb`.`item` (`idItem`, `ItemName`, `Price`) VALUES (?,?,?); ";
    private String getSaleIDString = "SELECT idSale FROM mydb.sale ORDER BY idSale DESC LIMIT 1";

    private PreparedStatement endSalesStmt;
    private PreparedStatement enterLineItemStmt;
    private PreparedStatement makeNewSaleStmt;
    private PreparedStatement makePaymentStmt;
    private PreparedStatement enterItemStmt;
    private PreparedStatement getSaleIDStmt;
//    private Register(ProductCatalog productCatalog) {
//        this.productCatalog = productCatalog;
//    }

    private PersistentStorage() {
        try {
            endSalesStmt = DataSource.getConnection().prepareStatement(endSaleString);
            enterLineItemStmt = DataSource.getConnection().prepareStatement(enterLineItemString);
            makeNewSaleStmt = DataSource.getConnection().prepareStatement(makeNewSaleString);
            makePaymentStmt = DataSource.getConnection().prepareStatement(makePaymentString);
            enterItemStmt = DataSource.getConnection().prepareStatement(enterItemString);
            getSaleIDStmt = DataSource.getConnection().prepareStatement(getSaleIDString);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void endSale(int id) throws SQLException {
        endSalesStmt.setInt(1, id);
        endSalesStmt.executeUpdate();
    }

    public void enterLineItem(int quantity, int idSale, int idItem, float price) throws SQLException {
        //TODO 
        enterLineItemStmt.setInt(1, idItem);
        enterLineItemStmt.setInt(2, idSale);
        enterLineItemStmt.setInt(3, quantity);
        enterLineItemStmt.setFloat(4, price);
        enterLineItemStmt.executeUpdate();
    }

    private int saleID() throws SQLException {
        int x = 0;
        ResultSet z = getSaleIDStmt.executeQuery();
        while (z.next()) {
            x = Integer.parseInt(z.getString(1));
        }
        System.out.println(x);
        return x;
    }

    public Sale makeNewSale() throws SQLException {
        //TODO
        //get the new sale id
        int x = 0;
        long millis = System.currentTimeMillis();
        makeNewSaleStmt.setBoolean(1, false);
        makeNewSaleStmt.setDate(2, new java.sql.Date(millis));
        makeNewSaleStmt.executeUpdate();
        x = saleID();
        Sale s = new Sale(false, new java.sql.Date(millis), x);
        return s;
    }

    public void makePayment(float amount, int idSale,String type) throws SQLException {
        //TODO
        makePaymentStmt.setFloat(1, amount);
        makePaymentStmt.setInt(2, idSale);
        makePaymentStmt.setString(3, type);
        makePaymentStmt.executeUpdate();
    }

    public void addItem(int id, String name, float price) throws SQLException {
        enterItemStmt.setInt(1, id);
        enterItemStmt.setString(2, name);
        enterItemStmt.setFloat(3, price);
        enterItemStmt.executeUpdate();
    }
    public static final PersistentStorage instance = new PersistentStorage();
}
