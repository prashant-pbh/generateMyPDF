package com.pdfreportcard.model;

public class InputRequest
{
    private Student student;
    private String userName;
    private int password;

    public InputRequest() {

    }

    public InputRequest(Student student, String userName, int password) {
        this.student = student;
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
