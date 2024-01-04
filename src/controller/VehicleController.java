package controller;

import model.Vehicle;

public class VehicleController {

    public void register( int vno, String vtype, String cname, int engno, int chno, long phno, String itype, int preamo, String fd, String td, int uid) {
        Vehicle v=new Vehicle(vno, vtype, cname, engno, chno, phno, itype, preamo, fd, td, uid);

        try{

        } catch (Exception e) {
            System.out.println("Error in VehicleController");
        }
    }
}
