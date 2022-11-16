package org.test.domain;

import org.network.domain.ServerDomain;

import java.time.LocalDateTime;
import java.util.Random;

public class TestData{
    //  arguments for User
    public String userNameForSignInDomain;
    public String fullUserName;
    public String  userPassword;
    public LocalDateTime timeSignIn;
    // arguments for Host
    public String computerName;
    public String ipv4;

    public void perhapsSetBadFieldForUser(String field,
                                   boolean isUserNameForSignInDomain, boolean isFullUserName, boolean isUserPassword, boolean isTimeSignIn){
        Random randPerhapsIncorrectField = new Random();
        byte numberOfInputField = 0b0000;
        int upperbound = 100;
        int int_random = randPerhapsIncorrectField.nextInt(upperbound);
        boolean isIncorrectField = false;

        if (int_random < 25){
            isIncorrectField = true;

        }



        if (isIncorrectField){

        }

    }

    public void perhapsSetBadFieldForHost(String field,
                                          boolean isComputerName, boolean isIpv4){

    }


}