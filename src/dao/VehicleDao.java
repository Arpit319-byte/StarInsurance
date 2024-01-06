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
            PreparedStatement stmt = con.prepareStatement(query);
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

            if (rowsAffected > 0) {
                System.out.println("Vehicle Registered Successfully");
            } else {
                System.out.println("Vehicle Registration Failed");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renew(Vehicle v){

        try{

            con= ConnectDB.getConn();
            String query="select * from vehicle where PolicyNo=?";
            PreparedStatement stmt =con.prepareStatement(query);
            stmt.setInt(1,v.getPno());

            ResultSet rs=stmt.executeQuery();

            if(rs!=null){

                  String query1="insert into vehicle(VehicleNo,VehicleType,CustomerName,EngineNo,ChasisNo,PhoneNo,Type,PremiumAmount,FromDate,UserId) values(?,?,?,?,?,?,?,?,?,?,?)";
                  PreparedStatement stmt1=con.prepareStatement(query1);
                  stmt1.setString(1,rs.getString(2));
                  stmt1.setString(2,rs.getString(3));
                  stmt1.setString(3,rs.getString(4));
                  stmt1.setInt(4,rs.getInt(5));
                  stmt1.setInt(5,rs.getInt(6));
                  stmt1.setLong(6,rs.getLong(7));
                  stmt1.setString(7,rs.getString(8));
                  stmt1.setInt(8,v.getPreamo());
                  stmt1.setString(9,rs.getString(10));
                  stmt1.setString(10,rs.getString(11));
                  stmt1.setInt(11,rs.getInt(12));

                  int rowsAffected=stmt1.executeUpdate();

                    if(rowsAffected>0) {
                        System.out.println("Policy Renewed Successfully");
                    }else{
                        System.out.println("Policy Renewal Failed");
                    }
            }else{
                System.out.println("No Vehicle Registered Under the given Policy Number");
            }

            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void change(Vehicle v) {

        try {
            con = ConnectDB.getConn();
            String query = "select * from vehicle where PolicyNo=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, v.getPno());

            ResultSet rs = stmt.executeQuery();


            if (rs != null) {

                String type = rs.getString(8);

                if (type.equals("Third Party")) {
                    System.out.println("No provision to update Insurance type from third party to full insurance");
                } else {

                    String query1 = "update vehicle set Type=? where PolicyNo=?";
                    PreparedStatement stmt1 = con.prepareStatement(query1);
                    stmt1.setString(1, v.getItype());
                    stmt1.setInt(2, v.getPno());

                    int rowsAffected = stmt1.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Insurance Type Updated Successfully");
                    } else {
                        System.out.println("Insurance Type Updation Failed");
                    }

                    con.close();
                }

            } else {
                System.out.println("No Vehicle Registered Under the given Policy Number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void view(Vehicle v) {

        try {

            con = ConnectDB.getConn();
            String query = "select * from vehicle where UserId=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, v.getUid());

            ResultSet rs = stmt.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    System.out.println("Policy Number: " + rs.getInt(1));
                    System.out.println("Vehicle Number: " + rs.getString(2));
                    System.out.println("Vehicle Type: " + rs.getString(3));
                    System.out.println("Customer Name: " + rs.getString(4));
                    System.out.println("Engine Number: " + rs.getInt(5));
                    System.out.println("Chasis Number: " + rs.getInt(6));
                    System.out.println("Phone Number: " + rs.getInt(7));
                    System.out.println("Insurance Type: " + rs.getString(8));
                    System.out.println("Premium Amount: " + rs.getInt(9));
                    System.out.println("From Date: " + rs.getString(10));
                    System.out.println("To Date: " + rs.getString(11));
//                    System.out.println("User Id: "+rs.getInt(12));
                    System.out.println("------------------------------------------------");

                }
            } else {
                System.out.println("No Vehicle Registered Under the given UserId");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
