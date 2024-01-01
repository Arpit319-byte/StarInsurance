package model;

public class UnderWriter {

    private int uwId;
    private String name;
    private String dob;
    private String doj;
    private String password;

    public UnderWriter(int uwId, String name, String dob, String doj, String password) {
        this.uwId = uwId;
        this.name = name;
        this.dob = dob;
        this.doj = doj;
        this.password = password;
    }

    public UnderWriter() {
    }


    public int getUwId() {
        return uwId;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getDoj() {
        return doj;
    }

    public String getPassword() {
        return password;
    }

    public void setUwId(int uwId) {
        this.uwId = uwId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}