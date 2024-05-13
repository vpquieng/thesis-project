package com.example.test;

public class User {
    private int id;
    private String uname;
    private String lname;
    private String fname;
    private String mname;
    private String address;
    private String pass;
    private String branch;
    private String designation;
    private String role;
    private byte[] pic;
    private String creationDate;
    private int creator;


    public User(){
        this.id = 0;
        this.uname = "";
        this.lname = "";
        this.fname = "";
        this.mname = "";
        this.address = "";
        this.pass = "";
        this.branch = "";
        this.designation = "";
        this.role = "";
        this.pic = new byte[0];
        this.creationDate = "";
        this.creator = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    public int getId() {
        return this.id;
    }

    public String getUname() {
        return this.uname;
    }

    public String getLname() {
        return this.lname;
    }

    public String getFname() {
        return this.fname;
    }

    public String getMname() {
        return this.mname;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPass() {
        return this.pass;
    }

    public String getBranch() {
        return this.branch;
    }

    public String getDesignation() {
        return this.designation;
    }

    public String getRole() {
        return this.role;
    }

    public byte[] getPic() {
        return this.pic;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public int getCreator() {
        return this.creator;
    }
}
