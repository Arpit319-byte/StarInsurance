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


}