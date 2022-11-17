package org.network.domain;

public interface IFServerDomain {

    public boolean addUserToDomainUsers (String userNameForSignInDomain, String fullUserName,
                                         String  userPassword,
                                         String timeSignIn);
    public boolean addHostToDomainHosts (String computerName, String ipv4);
    public boolean dellHostFromDomainHosts(String computerName, String ipv4);
    public boolean dellUserFromDomainUsers(String userNameForSignInDomain, String fullUserName);
    public void printDomainName();
    public void printDomainHosts();
    public void printDomainUsers();
    public void printIndividualUser(String userNameForSignInDomain, String fullUserName);
    public void printIndividualHost(String computerName, String ipv4);

}
