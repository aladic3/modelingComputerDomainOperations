package org.test.domain;

import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.network.domain.ServerDomain;

import org.network.domain.Host;
import org.network.domain.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;


@RunWith(Parameterized.class)
public class TestDomain implements IFTestDomain{
    private ServerDomain testObject;
    private DataForTest testData;

    @BeforeClass
    void setUp(){
        testObject = new ServerDomain("","");
        testData = new DataForTest();
    }


    TestDomain(String userNameForSignInDomain, String fullUserName, String  userPassword, LocalDateTime timeSignIn,
               String computerName, String ipv4){
        // arguments for User
        testData.userNameForSignInDomain = userNameForSignInDomain;
        testData.fullUserName = fullUserName;
        testData.userPassword = userPassword;
        testData.timeSignIn = timeSignIn;
        // set arguments for Host
        testData.computerName = computerName;
        testData.ipv4 = ipv4;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        ArrayList<DataForTest> testData = new ArrayList<>();



        for (int i = 0; i < 50; i++){
            DataForTest newObjectData = new DataForTest();
            testData.add(newObjectData);
        }

        return  Arrays.asList(testData);
        //Object[] testData = new Object[]{   {" userNameForSignInDomain_0 "," Full User Name_0 ", "userPassword_0 ", LocalDateTime.now() };

    }

    @Test
    public void addUserToDomainUsers(){
        ;
    }

    @Test
    public void addHostToDomainHosts(){

    }

    @Test
    public void dellHostFromDomainHosts(){

    }
    @Test
    public void dellUserFromDomainUsers(){

    }

    @Test
    public void printDomainName(){

    }

    @Test
    public void printDomainHosts(){

    }

    @Test
    public void printDomainUsers(){

    }

    @Test
    public void printIndividualUser(){

    }

    @Test
    public void printIndividualHost(){

    }
}
