package org.network.domain;



public class Host implements IFHost{
    private String computerName;
    private String ipv4;

    Host(String computerName, String ipv4){
        setComputerName(computerName);
        setIpv4(ipv4);
    }

    // setters
    public void setComputerName(String computerName){
        this.computerName = computerName.trim();
    }
    public void setIpv4(String ipv4) {

        this.ipv4 = ipv4;

    }

    // getters
    public String getComputerName(){
        return this.computerName;
    }
    public String getIpv4(){
        return this.ipv4;
    }

    // other
    public void printInfoAboutDomain(){
        System.out.printf("Domain: %s; IPv4: %s%n", getComputerName(), getIpv4());
    }


}