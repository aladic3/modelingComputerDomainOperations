package org.test.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DataForTest{
    //  arguments for User
    private String userNameForSignInDomain;
    private String fullUserName;
    private String  userPassword;
    private String timeSignIn;
    private ArrayList<String> userData;
    // arguments for Host
    private String computerName;
    private String ipv4;
    private ArrayList<String> hostData;




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
        this.timeSignIn = timeSignIn.toString();
    }
    public void setUserData(){
        userData = new ArrayList<String>(Arrays.asList(userNameForSignInDomain,fullUserName,userPassword,timeSignIn));
    }

    // for Host
    public void setComputerName(Object computerName){
        this.computerName = (String)computerName;
    }
    public void setIpv4(Object ipv4) {

        this.ipv4 = (String) ipv4;

    }
    public void setHostData(){
        hostData = new ArrayList<String>(Arrays.asList(computerName,ipv4));
    }


    // getters
    // for User
    public String getUserNameForSignInDomain(){
        return userNameForSignInDomain;
    }
    public String getFullUserName(){
        return fullUserName;
    }
    public String getTimeLastSignIn(){
        return timeSignIn;
    }
    public String getUserPassword(){return this.userPassword; }
    public ArrayList<String> getUserData(){
        return userData;
    }
    // for Host
    public String getComputerName(){
        return computerName;
    }
    public String getIpv4(){
        return ipv4;
    }
    public ArrayList<String> getHostData(){
        return hostData;
    }

    private static final int PERHAPS_BAD = 99;

    // this method for generate some-think field for User
    public Object generatePerhapsSetBadFieldForUser( Boolean isUserNameForSignInDomain,
                                          Boolean isFullUserName, Boolean isUserPassword,
                                          Boolean isTimeSignIn, int numberOfData, boolean isRunRandom){


        Random random = new Random();
        ArrayList<Boolean> lstBoolVariable = new ArrayList<>(Arrays.asList(isUserNameForSignInDomain,
                isFullUserName, isUserPassword));
        Object result;



        String exampleUserNameForSignInDomain = "UserNameForSignInDomain_";
        String exampleFullUserName = "Full_User_Name_";
        String exampleUserPassword = "UserPassword_";


        int forRepeatData = 0;

        int upperbound = 100;
        int countVariable = lstBoolVariable.size();
        byte numberOfInputField = 0b000; // for get info about input value (for realizing switch)
        boolean isIncorrectField = false;

        int int_random = random.nextInt(upperbound);


        if (int_random < PERHAPS_BAD && isRunRandom){
            isIncorrectField = true;
            forRepeatData = -random.nextInt(10);
        }

        // init numberOfInputField
        for (int i = 0; i < countVariable ; i++){
            if (lstBoolVariable.get(i).equals(true)) {
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
                result = String.format(exampleUserNameForSignInDomain  +
                        Integer.toString(numberOfData + forRepeatData));
                userNameForSignInDomain = result.toString();
                return result;
            }
            // generate fullUserName
            case 0b010 -> {
                result = String.format(exampleFullUserName +
                        Integer.toString(numberOfData + forRepeatData));
                fullUserName = result.toString();
                return result;
            }

            // generate userPassword
            case 0b001 -> {
                result = String.format(exampleUserPassword  +
                        Integer.toString(numberOfData));
                userPassword = result.toString();
                return result;
            }
        }

        if (isTimeSignIn){
            result = LocalDateTime.now().toString();
            timeSignIn = result.toString();
            return result;
        }

        return null;

    }

    private static final int PERHAPS_BAD_U = 50;
    // this method for generate some-think field for Host
    public String generatePerhapsSetBadFieldForHost(boolean isComputerName, boolean isIpv4,  int numberOfData,
    boolean isRunRandom){

        Random random = new Random();
        ArrayList<Boolean> lstBoolVariable = new ArrayList<>(Arrays.asList(isComputerName, isIpv4));
        String result = "";

        String exampleComputerName = "ComputerName_";
        String exampleIpv4;



        int ipUpperBound = 256;
        int upperbound = 100;
        int variantBadIp = -1; // -1 in switch it is correct ip
        int forRepeatData = 0;
        int countVariable = lstBoolVariable.size();
        boolean isIncorrectField = false;

        int int_random = random.nextInt(upperbound);


        if (int_random < PERHAPS_BAD_U && isRunRandom){
            isIncorrectField = true;
            variantBadIp = random.nextInt(3); // generate type of bad
            forRepeatData = -1;
        }

        // generating field
        if (isComputerName){
            result = exampleComputerName + Integer.toString(numberOfData + forRepeatData);
            computerName = result.toString();
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
            ipv4 = result.toString();

        }




        return result;

    }


}