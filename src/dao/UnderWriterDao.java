package dao;

import helper.ConnectDB;
import model.UnderWriter;

import java.sql.*;


public class UnderWriterDao {

    private Connection con;

    public void insert(UnderWriter und) {

        try {
             con = ConnectDB.getConn();
            String query = "insert into underwriter(Id,Name,DOB,DOJ,Password) values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, und.getUwId());
            stmt.setString(2, und.getName());
            stmt.setString(3, und.getDob());
            stmt.setString(4, und.getDoj());
            stmt.setString(5, und.getPassword());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0)
                System.out.println("UnderWriter Registered Successfully");
            else
                System.out.println("UnderWriter Registration Failed");

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void search(UnderWriter uw) {

        try {
             con = ConnectDB.getConn();

            String query = "select * from underwriter where Id=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, uw.getUwId());
            ResultSet rs = stmt.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    System.out.println("Id: " + rs.getInt(1));
                    System.out.println("Name: " + rs.getString(2));
                    System.out.println("DOB: " + rs.getString(3));
                    System.out.println("DOJ: " + rs.getString(4));
                    System.out.println("Password: " + rs.getString(5));
                }

                stmt.close();

            } else {
                System.out.println("UnderWriter not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(UnderWriter uw) {

        try{
             con=ConnectDB.getConn();

            String query="delete from underwriter where Id=?";
            PreparedStatement stmt=con.prepareStatement(query);
            stmt.setInt(1,uw.getUwId());

            int rowsAffected=stmt.executeUpdate();

            if (rowsAffected > 0)
                System.out.println("UnderWriter Deleted Successfully");
            else
                System.out.println("UnderWriter Deletion Failed");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
