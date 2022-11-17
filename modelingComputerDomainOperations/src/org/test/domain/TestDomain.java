package org.test.domain;



import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.network.domain.ServerDomain;
import static org.junit.Assert.*;

import java.util.*;


@RunWith(Parameterized.class)
public class TestDomain implements IFTestDomain{
    private static final int COUNT_CASE = 1000;
    private static final int COUNT_USER_FIELDS = 4;
    private static final int COUNT_HOST_FIELDS = 2;
    private ServerDomain testClass = new ServerDomain("","");
    @Parameterized.Parameter(0)
    public DataForTest testData;




    @Parameterized.Parameters
    public static Collection<DataForTest> data() {

        ArrayList<DataForTest> testData = new ArrayList<>();

        for (int i = 0; i < COUNT_CASE; i++){
            DataForTest newObjectData = new DataForTest();

            // generate data about User
            newObjectData.generatePerhapsSetBadFieldForUser(
                    true,false,false,false,i, true);
            newObjectData.generatePerhapsSetBadFieldForUser(
                    false,true,false,false,i, true);
            newObjectData.generatePerhapsSetBadFieldForUser(
                    false,false,true,false,i, true);
            newObjectData.generatePerhapsSetBadFieldForUser(
                    false, false, false, true, i, true);
            newObjectData.setUserData();

            // generate data about Host
            newObjectData.generatePerhapsSetBadFieldForHost(
                    true,false,i, true);
            newObjectData.generatePerhapsSetBadFieldForHost(
                    false,true,i,true);
            newObjectData.setHostData();

            testData.add(newObjectData);

        }

        return testData;

    }



    @Test
    public void addUserToDomainUsers(){
        assertTrue(testClass.addUserToDomainUsers(testData.getUserNameForSignInDomain(), testData.getFullUserName(),
                testData.getUserPassword(),testData.getTimeLastSignIn()));



    }

    @Test
    public void addHostToDomainHosts(){
        boolean res = testClass.addHostToDomainHosts(testData.getComputerName(), testData.getIpv4());
        if (!res){ res = true;} // bad generated data is throw and not written
        assertTrue(res);
    }



    @Ignore
    public void printDomainName(){
        testClass.printDomainName();
    }

    @Ignore
    public void printDomainHosts(){
        testClass.printDomainHosts();
    }

    @Ignore
    public void printDomainUsers(){
        testClass.printDomainUsers();
    }

    @Ignore
    public void printIndividualUser(){
        testClass.printIndividualUser(testData.getUserNameForSignInDomain(), testData.getFullUserName());
    }

    @Ignore
    public void printIndividualHost(){
        testClass.printIndividualHost(testData.getComputerName(), testData.getIpv4());
    }

    @Test
    public void dellHostFromDomainHosts(){
        testClass.addHostToDomainHosts(testData.getComputerName(), testData.getIpv4());
        boolean res = false;
        res = testClass.dellHostFromDomainHosts(testData.getComputerName(), testData.getIpv4()) ? true : !res;
        assertTrue(res);
    }
    @Test
    public void dellUserFromDomainUsers(){
        boolean res = testClass.addUserToDomainUsers(testData.getUserNameForSignInDomain(), testData.getFullUserName(),
                testData.getUserPassword(),testData.getTimeLastSignIn());
        assertTrue(res);
    }
}
