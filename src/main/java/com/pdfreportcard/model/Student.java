package com.pdfreportcard.model;

import java.util.Map;

public class Student
{
    private int rollNum;
    private String name;
    private String fatherName;
    private String motherName;
    private String birthDate;
    private String birthPlace;
    private Map<String, Integer> subjects;

    public Student(int rollNum, String name, String fatherName, String motherName, String birthDate, String birthPlace, Map<String, Integer> subjects) {
        this.rollNum = rollNum;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.subjects = subjects;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<String, Integer> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
