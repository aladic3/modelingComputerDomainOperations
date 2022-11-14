package org.network.domain;

public interface IFHost {
    void setComputerName(String computerName);
    boolean setIpv4(String ipv4);
    void printInfo();
    String getComputerName();
    String getIpv4();
}
