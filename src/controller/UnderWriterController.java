package controller;

import dao.UnderWriterDao;
import model.UnderWriter;

import java.sql.SQLException;

public class UnderWriterController {
    UnderWriterDao und = new UnderWriterDao();

    public void createUnderWriter(int uwId, String name, String dob, String doj, String password) {
        UnderWriter underWriter = new UnderWriter(uwId, name, dob, doj, password);

        try {
            und.insert(underWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("UnderWriter Registered Successfully in controller");
    }

    public void searchUnderWriter(int uwId) {
        UnderWriter underWriter = new UnderWriter();
        underWriter.setUwId(uwId);

        try {
            und.search(underWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUnderWriter(int uwId) {
        UnderWriter underWriter = new UnderWriter();
        underWriter.setUwId(uwId);

        try {
            und.delete(underWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUnderWriter(int uwId, String pass1, String pass2) {
        UnderWriter underWriter = new UnderWriter();
        underWriter.setUwId(uwId);
        underWriter.setPassword(pass1);

        try {
            und.update(underWriter, pass2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewAllUnderWriter() {

        try {
            und.viewAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean validate(int uwId ,String password){
        boolean ans=false;
        try{
            ans= und.validateUnderWriter(uwId,password);
        }catch(Exception e){
            e.printStackTrace();
        }

        return ans;
    }


}
