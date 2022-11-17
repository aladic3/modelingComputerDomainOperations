package org.network.domain;

import java.time.LocalDateTime;

public class User implements IFUser{
    private String userNameForSignInDomain;
    private String fullUserName;
    private String userPassword;
    private String timeSignIn;

    public User(String userNameForSignInDomain, String fullUserName,
                String  userPassword,
                String timeSignIn){
        setUserNameForSignInDomain(userNameForSignInDomain);
        setFullUserName(fullUserName);
        setUserPassword(userPassword);
        setTimeSignIn(timeSignIn);
    }

    // setters
    public void setUserNameForSignInDomain(String userNameForSignInDomain){
        this.userNameForSignInDomain = userNameForSignInDomain.trim();
    }
    public void setFullUserName(String fullUserName){
        this.fullUserName = fullUserName.trim();
    }
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword.trim();
    }
    public void setTimeSignIn(String timeSignIn){
        this.timeSignIn = timeSignIn;
    }

    // getters
    public String getUserNameForSignInDomain(){
        return this.userNameForSignInDomain;
    }
    public String getFullUserName(){
        return this.fullUserName;
    }
    public String getTimeLastSignIn(){
        return this.timeSignIn;
    }

    // other


    public boolean isConfirmedUserPassword(String userPassword){
        return  this.userPassword.equals(userPassword);
    }
}
