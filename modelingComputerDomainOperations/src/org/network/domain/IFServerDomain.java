package org.network.domain;

import java.time.LocalDateTime;
import java.util.Arrays;

public interface IFServerDomain {

    public boolean addUserToDomainUsers (String userNameForSignInDomain, String fullUserName,
                                         String  userPassword,
                                         LocalDateTime timeSignIn);
    public boolean addHostToDomainHosts (String computerName, String ipv4);
    public boolean dellHostFromDomainHosts(Host host);
    public boolean dellUserFromDomainUsers(User user);
    public void printDomainName();
    public void printDomainHosts();
    public void printDomainUsers();
    public void printIndividualUser(String userNameForSignInDomain, String fullUserName);
    public void printIndividualHost(String computerName, String ipv4);

}
