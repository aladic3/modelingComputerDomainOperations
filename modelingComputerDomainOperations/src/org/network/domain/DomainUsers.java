package org.network.domain;

import java.util.ArrayList;

public class DomainUsers {
    private final ArrayList<User> users;

    public DomainUsers(){
        this.users = new ArrayList<>();
    }

    public void addHostToList(User user){
        this.users.add(user);
    }

    public ArrayList<User> getDomainUsers(){
        return this.users;
    }

}
