package org.test.domain;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class DataForTest{
    //  arguments for User
    private String userNameForSignInDomain;
    private String fullUserName;
    private String  userPassword;
    private LocalDateTime timeSignIn;
    // arguments for Host
    private String computerName;
    private String ipv4;

    // setters
    // for User
    public void setUserNameForSignInDomain(Object userNameForSignInDomain){
        this.userNameForSignInDomain = (String) userNameForSignInDomain;
    }
    public void setFullUserName(Object fullUserName){
        this.fullUserName = (String) fullUserName;
    }
    public void setUserPassword(Object userPassword){
        this.userPassword = (String) userPassword;
    }
    public void setTimeSignIn(Object timeSignIn){
        this.timeSignIn = (LocalDateTime) timeSignIn;
    }
    // for Host
    public void setComputerName(Object computerName){
        this.computerName = (String)computerName;
    }
    public void setIpv4(Object ipv4) {

        this.ipv4 = (String) ipv4;

    }

    // getters
    // for User
    public String getUserNameForSignInDomain(){
        return this.userNameForSignInDomain;
    }
    public String getFullUserName(){
        return this.fullUserName;
    }
    public LocalDateTime getTimeLastSignIn(){
        return this.timeSignIn;
    }
    public String getUserPassword(){return this.userPassword; }
    // for Host
    public String getComputerName(){
        return this.computerName;
    }
    public String getIpv4(){
        return this.ipv4;
    }


    // this method for generate some-think field for User
    static public Object generatePerhapsSetBadFieldForUser( Boolean isUserNameForSignInDomain,
                                          Boolean isFullUserName, Boolean isUserPassword,
                                          Boolean isTimeSignIn, int numberOfData){

        Random random = new Random();
        ArrayList<Boolean> lstBoolVariable = new ArrayList<>(Arrays.asList(isUserNameForSignInDomain,
                isFullUserName, isUserPassword));
        Object result;



        String exampleUserNameForSignInDomain = "UserNameForSignInDomain_";
        String exampleFullUserName = "Full User Name_";
        String exampleUserPassword = "UserPassword_";
        String lineIfBad = "";

        int percentOfPerhapsBad = 5;
        int upperbound = 100;
        int countVariable = lstBoolVariable.size();
        byte numberOfInputField = 0b000; // for get info about input value (for realizing switch)
        boolean isIncorrectField = false;

        int int_random = random.nextInt(upperbound);


        if (int_random < percentOfPerhapsBad){
            isIncorrectField = true;
            lineIfBad = "Bad_";
        }

        // init numberOfInputField
        for (int i = 0; i < countVariable ; i++){
            if (lstBoolVariable.get(i) != null) {
                numberOfInputField |= 1;
                numberOfInputField <<= (countVariable - i - 1);
                break;
            }
            numberOfInputField <<= 1;

        }


        // generating field
        switch (numberOfInputField) {
            // generate userNameForSignInDomain
            case 0b100 -> {
                result = String.format(exampleUserNameForSignInDomain + lineIfBad +
                        Integer.toString(numberOfData));
                return result;
            }
            // generate fullUserName
            case 0b010 -> {
                result = String.format(exampleFullUserName + lineIfBad +
                        Integer.toString(numberOfData));
                return result;
            }

            // generate userPassword
            case 0b001 -> {
                result = String.format(exampleUserPassword + lineIfBad +
                        Integer.toString(numberOfData));
                return result;
            }
        }

        if (isTimeSignIn){
            return LocalDateTime.now();
        }

        return null;

    }

    // this method for generate some-think field for Host
    static public String generatePerhapsSetBadFieldForHost(boolean isComputerName, boolean isIpv4,  int numberOfData){

        Random random = new Random();
        ArrayList<Boolean> lstBoolVariable = new ArrayList<>(Arrays.asList(isComputerName, isIpv4));
        String result = "";

        String exampleComputerName = "ComputerName_";
        String exampleIpv4;
        String lineIfBad = "";

        int percentOfPerhapsBad = 5;
        int ipUpperBound = 256;
        int upperbound = 100;
        int variantBadIp = -1;
        int countVariable = lstBoolVariable.size();
        boolean isIncorrectField = false;

        int int_random = random.nextInt(upperbound);


        if (int_random < percentOfPerhapsBad){
            isIncorrectField = true;
            lineIfBad = "Bad_";
            variantBadIp = random.nextInt(3); // generate type of bad
        }

        // generating field
        if (isComputerName){
            result = exampleComputerName + lineIfBad + Integer.toString(numberOfData);
        }

        if (isIpv4){
            ArrayList<String> fieldsForIpv4 = new ArrayList<>();

            char ifIncludingChar = 0;

            switch (variantBadIp) {
                // correct ip
                case -1:
                    for (int i = 0; i < 4; i++){
                        fieldsForIpv4.add(Integer.toString(random.nextInt(ipUpperBound)));
                    }
                    break;

                // incorrect count fields ip
                case 1:
                    int countFieldsIp = 4 + (random.nextBoolean()? -1: 1);
                    for (int i = 0; i < countFieldsIp; i++){
                        fieldsForIpv4.add(Integer.toString(random.nextInt(ipUpperBound)));;
                    }
                    break;

                // incorrect number field ip
                case 2:
                    for (int i = 0; i < 4; i++){
                        int badIp = (random.nextBoolean()? -random.nextInt(ipUpperBound)
                                : 255 + random.nextInt(ipUpperBound));
                        fieldsForIpv4.add(Integer.toString(badIp));
                    }
                    break;

                // including char
                case 3:
                    ifIncludingChar = 'b';
                    for (int i = 0; i < 4; i++){
                        fieldsForIpv4.add(Integer.toString(random.nextInt(ipUpperBound))+ifIncludingChar) ;
                    }
                    break;

            }
            result = String.join(".", fieldsForIpv4);

        }




        return result;

    }


}