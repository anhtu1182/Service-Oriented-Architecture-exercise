package com.tcp;

public class Student {
    String student_name;
    String student_ID;
    String student_class;
    String student_phone;
    String student_email;
    String student_address;

    public Student(){

    }

    public Student(String student_name, String student_ID, String student_class,
                    String student_phone, String student_email, String student_address){
        setStudent_name(student_name);
        setStudent_ID(student_ID);
        setStudent_class(student_class);
        setStudent_phone(student_phone);
        setStudent_email(student_email);
        setStudent_address(student_address);
    }
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    @Override
    public String toString() {
        return "Name: " + getStudent_name() + "; ID: "+ getStudent_ID() + "; Class: " + getStudent_class() +
                "; Phone number: " + getStudent_phone() + "; Email: " + getStudent_email() + "; Address: " + getStudent_address();
    }
}
