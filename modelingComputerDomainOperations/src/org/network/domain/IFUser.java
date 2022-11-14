package org.network.domain;

import java.time.LocalDateTime;

public interface IFUser {
    void setUserNameForSignInDomain(String userNameForSignInDomain);
    void setFullUserName(String fullUserName);
    void setUserPassword(String userPassword);
    void setTimeSignIn(LocalDateTime timeSignIn);
    String getUserNameForSignInDomain();
    String getFullUserName();
    LocalDateTime getTimeLastSignIn();
    boolean isConfirmedUserPassword(String userPassword);
}
