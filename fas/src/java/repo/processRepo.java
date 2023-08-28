/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SWATANTRA
 */
public class processRepo {

    String sqlusername = "root";
    String sqlpassword = "password";
    String url = "JDBC:mysql://localhost:3306/dashboard";
//sales

    public ResultSet getallData() throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareStatement("select no,name,email,phone,city,course from studentdata where city=\"surat\";");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet lastdata() throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM studentdata where city = \"surat\" ORDER BY no DESC LIMIT 1;;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }
//   purchase 

    public ResultSet getallDataPurchase() throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareStatement("select no,name,email,phone,city,course from studentdata where city=\"russia\";");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet lastdataPurchase() throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM studentdata where city = \"russia\" ORDER BY no DESC LIMIT 1;;");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    
    
    
    public ResultSet EditViewData(int id) throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM studentdata where no=?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public int updatestudentdetails(String username, String email, String phone, String city, String course, int number) throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareCall("update  studentdata set name=?,email=?,phone=?,city=?,course=?  where no=? ;");

        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, phone);
        stmt.setString(4, city);
        stmt.setString(5, course);
        stmt.setInt(6, number);
        int status = stmt.executeUpdate();
        return status;
    }

    public int newstudentdetails(String username, String email, String phone, String city, String course) throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareCall("insert into studentdata (name,email,phone,city,course) values(?,?,?,?,?);");
        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, phone);
        stmt.setString(4, city);
        stmt.setString(5, course);
        int status = stmt.executeUpdate();
        return status;
    }

    public int deletestudentdetail(int no) throws SQLException {
        Connection con = DriverManager.getConnection(url, sqlusername, sqlpassword);
        PreparedStatement stmt = con.prepareCall("delete from  studentdata where no=? ;");
        stmt.setInt(1, no);
        return stmt.executeUpdate();
    }
}
