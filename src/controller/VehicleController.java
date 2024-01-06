package controller;

import model.Vehicle;
import dao.VehicleDao;

public class VehicleController {

    VehicleDao vdo = new VehicleDao();

    public void register(int vno, String vtype, String cname, int engno, int chno, long phno, String itype, int preamo, String fd, String td, int uid) {
        Vehicle v = new Vehicle(vno, vtype, cname, engno, chno, phno, itype, preamo, fd, td, uid);

        try {
            vdo.create(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renewPolicy(int pno, int preamo) {
        Vehicle v = new Vehicle();
        v.setPno(pno);
        v.setPreamo(preamo);

        try {
            vdo.renew(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeType(int pno) {
        Vehicle v = new Vehicle();
        v.setPno(pno);
        v.setItype("Full Insurance");

        try {
            vdo.change(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAll(int uid) {
        Vehicle v = new Vehicle();
        v.setUid(uid);
        try {

            vdo.view(v);
        } catch (Exception e) {
            System.out.println("Error in VehicleController");
        }
    }
}
