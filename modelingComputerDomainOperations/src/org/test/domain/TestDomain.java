package org.test.domain;

import org.junit.*;


import org.network.domain.ServerDomain;

import org.network.domain.Host;
import org.network.domain.User;
import java.time.LocalDateTime;

public class TestDomain {
    private ServerDomain testObject;
    TestDomain(){
        this.testObject = new ServerDomain("","");
    }

    @BeforeClass
    

    public static void testIfValidIpv4(){//String ipv4){

    }

    public static void testIsUserNotIncludeInDomain(User user){

    }

    public static void isHostNotIncludeInDomain(Host host){

    }

    public static void addUserToDomainUsers (String userNameForSignInDomain, String fullUserName,
                                        String  userPassword,
                                        LocalDateTime timeSignIn){

    }

    public static void addHostToDomainHosts(String computerName, String ipv4){

    }

    public static void dellHostFromDomainHosts(Host host){

    }
    public static void dellUserFromDomainUsers(User user){

    }
    public static void printDomainName(){

    }

    public static void printDomainHosts(){

    }

    public static void printDomainUsers(){

    }

    public static void printIndividualUser(String userNameForSignInDomain, String fullUserName){

    }

    public static void printIndividualHost(String computerName, String ipv4){

    }
}
