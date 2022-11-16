package org.test.domain;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class DataForTest{
    //  arguments for User
    public String userNameForSignInDomain;
    public String fullUserName;
    public String  userPassword;
    public LocalDateTime timeSignIn;
    // arguments for Host
    public String computerName;
    public String ipv4;

    // this method for generate some-think field for User
    public Object generatePerhapsSetBadFieldForUser(Object field, int numberOfData,
                                          Boolean isUserNameForSignInDomain,
                                          Boolean isFullUserName, Boolean isUserPassword,
                                          Boolean isTimeSignIn){

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
                case 0b100:
                    result = String.format(exampleUserNameForSignInDomain + lineIfBad +
                             Integer.toString(numberOfData));
                    return result;
                // generate fullUserName
                case 0b010:
                    result = String.format(exampleFullUserName + lineIfBad +
                            Integer.toString(numberOfData));
                    return result;

                // generate userPassword
                case 0b001:
                    result = String.format(exampleUserPassword + lineIfBad +
                            Integer.toString(numberOfData));
                    return result;

        }

        if (isTimeSignIn){
            return LocalDateTime.now();
        }

        return null;

    }

    // this method for generate some-think field for Host
    public String generatePerhapsSetBadFieldForHost(String field, int numberOfData,
                                          boolean isComputerName, boolean isIpv4){

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
            result = field + lineIfBad + Integer.toString(numberOfData);
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