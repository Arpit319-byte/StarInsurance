package helper;

import java.sql.*;

public class ConnectDB {

    public static Connection con;
    private final static String url = "jdbc:mysql://localhost:3306/insurance";
    private final static String username = "root";
    private final static String password = "03111999";

    public static Connection getConn() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Connected");


        return con;
    }


}
