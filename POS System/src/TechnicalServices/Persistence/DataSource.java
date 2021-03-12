/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechnicalServices.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hover
 */
public class DataSource {

    private static Connection con = null;

    public static Connection getConnection() {
      	// --- Pour une connexion MySQL native
        String lsPilote    = "com.mysql.jdbc.Driver";
	String lsConnexion = "jdbc:mysql://localhost:330/mydb";

	String lsUt  = "root";
	String lsMdp = "root";
        
        if (con == null) {
            try {
                Class.forName(lsPilote);
                con = DriverManager.getConnection(lsConnexion,lsUt,lsMdp);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
                con = null;
              //  DriverManager.getConnection("jdbc:derby:database/bookdb20;shutdown=true");
            } catch (SQLException ex) {
                //Logger.getLogger(Datasource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
