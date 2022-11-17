package org.network.domain;

public interface IFHost {
    void setComputerName(String computerName);
    void setIpv4(String ipv4);
    void printInfoAboutDomain(Host host);
    String getComputerName();
    String getIpv4();
}
