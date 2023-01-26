/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easy.bank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author n
 */
public class SQLdb {
    int port=3306 ;
    String db_name = "atm_db";
    
    public void insertNewPin(String querry) throws SQLException {//update choices for the etudiant
       
         

        Connection connect_sql;
        
        String URL = "jdbc:mysql://localhost:"+port+"/"+db_name+"?characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");//create my databese connection
            connect_sql = DriverManager.getConnection(URL,"root" ,"");//connection
            
            Statement st = connect_sql.createStatement();
                                   
            st.execute(querry);
            st.close();
            connect_sql.close();
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public user getDB(String requette) throws ClassNotFoundException{
        user a = null;
        Connection connect_sql;
        String URL = "jdbc:mysql://localhost:"+port+"/"+db_name+"?characterEncoding=utf8";
        
            try {
                Class.forName("com.mysql.jdbc.Driver");//create my databese connection
                connect_sql = DriverManager.getConnection(URL,"root" ,"");//connection
                Statement st = connect_sql.createStatement();
                ResultSet rslt = st.executeQuery(requette);
                
                String name;
                double card_num;
                int pin;
                int balance;
                while (rslt.next()) {                    
                    
                    name=rslt.getString("name");
                    card_num=rslt.getDouble("card_num");
                    pin=rslt.getInt("pin");
                    balance=rslt.getInt("balance");
                    
                   a = new user(name, card_num, pin, balance);
                }connect_sql.close();
            } catch (SQLException ex) {
                System.out.println("sql error ");
                Logger.getLogger(SQLdb.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    return a;
    }
    
}
