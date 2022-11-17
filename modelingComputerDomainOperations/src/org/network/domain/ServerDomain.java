package org.network.domain;


import java.util.Arrays;
public class ServerDomain extends Host implements IFServerDomain {

    private final DomainHosts domainHosts = new DomainHosts();
    private final DomainUsers domainUsers = new DomainUsers();

    public ServerDomain(String computerName, String ipv4) {
        super(computerName, ipv4);

    }

    private String ifValidIpv4(String ipv4){
        String[] fieldsIpv4 = ipv4.split("\\.");
        try {
            if (fieldsIpv4.length != 4){
                throw new Exception();
            }

            int i;

            for (int k = 0; k < fieldsIpv4.length; k++){
                fieldsIpv4[k] = fieldsIpv4[k].trim();
                i = Integer.parseInt(fieldsIpv4[k]);
                if (i > 255 || i < 0){
                    throw new Exception();
                }

            }
        }
        catch (Exception e){
            return "";
        }

        return String.join(".", Arrays.asList(fieldsIpv4));
    }

    private boolean isUserNotIncludeInDomain(User user){
        for (User userInDomain: domainUsers.getDomainUsers()) {
            if (user.getFullUserName().equalsIgnoreCase(userInDomain.getFullUserName()) ||
            user.getUserNameForSignInDomain().equalsIgnoreCase(userInDomain.getUserNameForSignInDomain()) ){
                return false;
            }
        }
        return true;
    }
    private  boolean isHostNotIncludeInDomain(Host host){
        for (Host hostInDomain: domainHosts.getDomainHosts()) {
            if (hostInDomain.getComputerName().equals(host.getComputerName()) ||
            hostInDomain.getIpv4().equals(host.getIpv4())){
               return false;
            }
        }
        return true;
    }
    public boolean addUserToDomainUsers (String userNameForSignInDomain, String fullUserName,
                                      String  userPassword,
                                      String timeSignIn){
        User newUser = new User(userNameForSignInDomain,fullUserName,
                userPassword,
                timeSignIn);
        if (domainUsers.getDomainUsers().size() == 0){
            domainUsers.addHostToList(newUser);
            return true;
        }
        if (isUserNotIncludeInDomain(newUser)){
            domainUsers.addHostToList(newUser);
            return true;
        }
        return false;
    }
    public boolean addHostToDomainHosts (String computerName, String ipv4){
        if (ifValidIpv4(ipv4).equals("")){
            return false;
        }
        Host newHost = new Host(computerName, ipv4);
        if (domainHosts.getDomainHosts().size() == 0){
            domainHosts.addHostToList(newHost);
            this.setIpv4(ipv4);
            this.setComputerName(computerName);
            return true;
        }
        if (isHostNotIncludeInDomain(newHost)){
            domainHosts.addHostToList(newHost);
            this.setIpv4(ipv4);
            this.setComputerName(computerName);
            return true;
        }
        return false;
    }
    public boolean dellHostFromDomainHosts(String computerName, String ipv4){
        for (Host host: domainHosts.getDomainHosts()) {
            if (host.getIpv4().equals(ipv4) ||
                host.getComputerName().equals(ipv4)){
                return domainHosts.getDomainHosts().remove(host);
            }
        }
        return false;

    }
    public boolean dellUserFromDomainUsers(String userNameForSignInDomain, String fullUserName){
        for (User user: domainUsers.getDomainUsers()) {
            if (user.getFullUserName().equals(fullUserName) ||
                    user.getUserNameForSignInDomain().equals(userNameForSignInDomain)){
                return domainUsers.getDomainUsers().remove(user);
            }
        }
        return false;

    }
    public void printDomainName(){
        for (User host: domainUsers.getDomainUsers() ) {
            System.out.printf("Full_name: %s Name: %s Last_Sign-In: %s%n",
                    host.getFullUserName(), host.getUserNameForSignInDomain(), host.getTimeLastSignIn());
        }


    }
    public void printDomainHosts(){
        for (Host host: domainHosts.getDomainHosts()) {
           super.printInfoAboutDomain(host);
        }
    }
    public void printDomainUsers(){
        for (User user: domainUsers.getDomainUsers()) {
            System.out.printf("Full_name: %s Name: %s Last_Sign-In: %s%n",
                    user.getFullUserName(), user.getUserNameForSignInDomain(), user.getTimeLastSignIn());
        }
    }
    public void printIndividualUser(String userNameForSignInDomain, String fullUserName){ // may use only one field for search
        System.out.println("Print info about User:");
        for (User userInDomain: domainUsers.getDomainUsers()) {
            if (userInDomain.getUserNameForSignInDomain().equalsIgnoreCase(userNameForSignInDomain) ||
                userInDomain.getFullUserName().equalsIgnoreCase(fullUserName)){
                System.out.printf("Full name: %s Name: %s Last Sign-In: %s%n",
                        userInDomain.getFullUserName(), userInDomain.getUserNameForSignInDomain(), userInDomain.getTimeLastSignIn());

                break;
            }
        }
    }
    public void printIndividualHost(String computerName, String ipv4){
        System.out.println("Print info about Host:");
        for (Host userInDomain: domainHosts.getDomainHosts()) {
            if (userInDomain.getComputerName().equalsIgnoreCase(computerName) ||
                    userInDomain.getIpv4().equalsIgnoreCase(ipv4)){
                userInDomain.printInfoAboutDomain(userInDomain);
                break;
            }
        }
    }

}
