/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import Domain.Sales.ProductCatalog;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class TransferFromDB {

    private String findItemByKeyString = "select * from Item where idItem = ?";
    private String findAllItemsString = "select * from Item ";
    private String findAllSalesString = "SELECT * FROM sale";
    private String findAllSalesLineItemsString="SELECT * FROM mydb.salelineitem where Sale_idSale = ?;";
    private String getPaymentString="SELECT Amount,PaymentType from mydb.payment where Sale_SaleID= ?;";

    private PreparedStatement findItemByKeyStmt;
    private PreparedStatement findAllItemsStmt;
    private PreparedStatement findAllSalesStmt;
    private PreparedStatement findAllSalesLineItemsStmt;
    private PreparedStatement findPaymentStmt;

    private TransferFromDB() {
        try {
            findItemByKeyStmt = DataSource.getConnection().prepareStatement(findItemByKeyString);
            findAllItemsStmt = DataSource.getConnection().prepareStatement(findAllItemsString);
            findAllSalesStmt = DataSource.getConnection().prepareStatement(findAllSalesString);
            findAllSalesLineItemsStmt = DataSource.getConnection().prepareStatement(findAllSalesLineItemsString);
            findPaymentStmt = DataSource.getConnection().prepareStatement(getPaymentString);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getPayment(int idSale) throws SQLException{
        findPaymentStmt.setString(1, String.valueOf(idSale));
        ResultSet set = findPaymentStmt.executeQuery();
        return set;
    }
    public ResultSet getItem(int idItem) {
        try {
            findItemByKeyStmt.setString(1, String.valueOf(idItem));
            ResultSet set = findItemByKeyStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getCatalog() {
        try {
            ResultSet set = findAllItemsStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getSales() throws SQLException {
        try {
            ResultSet set = findAllSalesStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getSalesLineItems(int id){
           try {
             findAllSalesLineItemsStmt.setString(1, String.valueOf(id));
            ResultSet set = findAllSalesLineItemsStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static final TransferFromDB instance = new TransferFromDB();
}
