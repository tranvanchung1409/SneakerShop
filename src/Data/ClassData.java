/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ClassData {

//    Connection Con = null;
    private Connection Con;
    private Statement St;

    public static Connection ConnectDb() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String connection = "jdbc:mysql://localhost:3306/banhang?useSSL=false";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            Connection Con = DriverManager.getConnection(connection, user, password);;
            return Con;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi Kết Nối!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public ResultSet Select(String query) throws SQLException {
        St = Con.createStatement();
        ResultSet resultSet = St.executeQuery(query);
        return resultSet;
    }

    public int Insert(String query) throws SQLException {
        St = Con.createStatement();
        int result = St.executeUpdate(query);
        return result;
    }

    private boolean closeDB() {
        boolean res = true;
        try {
            if (!Con.isClosed()) {
                Con.close();
            }
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }
}
