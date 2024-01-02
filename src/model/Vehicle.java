package model;

public class Vehicle {

    int pno;
    String vno;
    String vtype;
    String cname;
    int engno;
    int chno;
    long phno;
    String itype;
    int preamo;
    String fd;
    String td;
    int uid;

    public Vehicle() {
    }

    public Vehicle( String vno, String vtype, String cname, int engno, int chno, long phno, String itype, int preamo, String fd, String td, int uid) {
        this.vno = vno;
        this.vtype = vtype;
        this.cname = cname;
        this.engno = engno;
        this.chno = chno;
        this.phno = phno;
        this.itype = itype;
        this.preamo = preamo;
        this.fd = fd;
        this.td = td;
        this.uid = uid;
    }

    public int getPno() {
        return pno;
    }



    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public String getVtype() {
        return vtype;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getEngno() {
        return engno;
    }

    public void setEngno(int engno) {
        this.engno = engno;
    }

    public int getChno() {
        return chno;
    }

    public void setChno(int chno) {
        this.chno = chno;
    }

    public long getPhno() {
        return phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }

    public String getItype() {
        return itype;
    }

    public void setItype(String itype) {
        this.itype = itype;
    }

    public int getPreamo() {
        return preamo;
    }

    public void setPreamo(int preamo) {
        this.preamo = preamo;
    }

    public String getFd() {
        return fd;
    }

    public void setFd(String fd) {
        this.fd = fd;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }



    public void setUid(int uid) {
        this.uid = uid;
    }
}
