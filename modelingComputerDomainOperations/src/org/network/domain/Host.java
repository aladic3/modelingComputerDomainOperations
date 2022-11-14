package org.network.domain;

import java.util.Arrays;

public class Host implements IFHost{
    private String computerName;
    private String ipv4;

    // setters
    public void setComputerName(String computerName){
        this.computerName = computerName.trim();
    }
    public boolean setIpv4(String ipv4) {
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
            return false;
        }
        
        this.ipv4 = String.join(".", Arrays.asList(fieldsIpv4));
        return true;
    }

    // getters
    public String getComputerName(){
        return this.computerName;
    }
    public String getIpv4(){
        return this.ipv4;
    }

    // other
    public void printInfo(){
        System.out.printf("Computer name: %s; Ipv4-address: %s%n", getComputerName(), getIpv4());

    }


}