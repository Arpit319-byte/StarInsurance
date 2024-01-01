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

}
