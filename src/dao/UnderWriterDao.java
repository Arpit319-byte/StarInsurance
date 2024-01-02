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

            con.close();
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
                    System.out.println("------------------------------------------------");
                }

                con.close();

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

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void update(UnderWriter uw,String password2){

        try {
            con = ConnectDB.getConn();
            String query = "update underwriter set password=? where ID=? and password=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,password2);
            stmt.setInt(2,uw.getUwId());
            stmt.setString(3,uw.getPassword());

            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected>0)
                System.out.println("UnderWriter Password Updated Successfully");
            else
                System.out.println("UnderWriter Password Updation Failed");

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewAll(){

        try {
            con = ConnectDB.getConn();
            String query = "select * from underwriter";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if(rs!=null){

                while(rs.next()){
                    System.out.println("Id: " + rs.getInt(1));
                    System.out.println("Name: " + rs.getString(2));
                    System.out.println("DOB: " + rs.getString(3));
                    System.out.println("DOJ: " + rs.getString(4));
                    System.out.println("Password: " + rs.getString(5));
                }

                con.close();
            }else{
                System.out.println("No UnderWriter found");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
