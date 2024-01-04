package dao;

import helper.ConnectDB;
import model.Vehicle;

import java.sql.*;

public class VehicleDao {
    private Connection con;

    public void create(Vehicle v) {

        try {
            con = ConnectDB.getConn();
            String query = "insert into vehicle(VehicleNo,VehicleType,CustomerName,EngineNo,ChasisNo,PhoneNo,Type,PremiumAmount,FromDate,UserId) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt =con.prepareStatement(query);
            stmt.setInt(1, v.getVno());
            stmt.setString(2, v.getVtype());
            stmt.setString(3, v.getCname());
            stmt.setInt(4, v.getEngno());
            stmt.setInt(5, v.getChno());
            stmt.setLong(6, v.getPhno());
            stmt.setString(7, v.getItype());
            stmt.setInt(8, v.getPreamo());
            stmt.setString(9, v.getFd());
            stmt.setInt(10, v.getUid());
            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0){
                System.out.println("Vehicle Registered Successfully");
            }else{
                System.out.println("Vehicle Registration Failed");
            }
            
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
