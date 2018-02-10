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
    //has special character
    public boolean hasSpec(){
        int size=password.length();
        for(int i=0; i<size; i++){
            char next= password.charAt(i);
            if((!Character.isLetter(next)) && (!Character.isDigit(next)) && (next!=' ')){
                return true;
            }
        }
        return false;
    }
    //has digit
    public boolean hasDigit(){
        int size=password.length();
        for(int i=0; i<size; i++){
            char next= password.charAt(i);
            if(Character.isDigit(next)){
                return true;
            }
        }
        return false;
    }
    //has lower and upper case
    public boolean hasLowerAndUpper(){
        int count=0;
        int size=password.length();
        for(int i=0; i<size; i++){
            char next= password.charAt(i);
            if(Character.isLowerCase(next) && count==0){
                count++;
            }
            if(Character.isUpperCase(next)){
                count++;
            }
            if(count==2){
                return true;
            }
        }
        return false;
    }
}
