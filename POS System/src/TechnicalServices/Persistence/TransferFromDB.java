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
    private PreparedStatement findItemByKeyStmt;
    private PreparedStatement findAllItemsStmt;
    
    private TransferFromDB(){
        try {
            findItemByKeyStmt = DataSource.getConnection().prepareStatement(findItemByKeyString);
            findAllItemsStmt = DataSource.getConnection().prepareStatement(findAllItemsString);
        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getItem(int idItem){
        try {
            findItemByKeyStmt.setString(1,  String.valueOf(idItem));
            ResultSet set = findItemByKeyStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getCatalog(){
        try {
            ResultSet set = findAllItemsStmt.executeQuery();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(TransferFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static final TransferFromDB instance = new TransferFromDB();
}
