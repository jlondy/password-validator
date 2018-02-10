package com.example.jasonlalonde.assignment2;

/**
 * Created by Jason Lalonde on 2/9/2018.
 */

public class Validator {
    private String password;
    public Validator(){}
    public Validator(String s){
        password=s;
    }
    public void setPassword(String s){
        password=s;
    }
    public String getPassword(){
        return password;
    }
    public boolean isLength(){
        if(password.length()<8){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean isCorrect(){
        if(password.equalsIgnoreCase("password") || password.equals("")){
            return false;
        }
        else{
            return true;
        }
    }
}
