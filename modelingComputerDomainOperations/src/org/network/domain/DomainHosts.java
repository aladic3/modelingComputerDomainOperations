package org.network.domain;

import java.util.ArrayList;

public class DomainHosts {
    private final ArrayList<Host> hosts;

    public DomainHosts(){
        this.hosts = new ArrayList<>();
    }

    public void addHostToList(Host host){
        this.hosts.add(host);
    }

    public ArrayList<Host> getDomainHosts(){
        return this.hosts;
    }
}
