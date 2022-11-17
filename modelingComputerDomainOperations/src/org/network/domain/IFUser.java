package org.network.domain;

import java.time.LocalDateTime;

public interface IFUser {
    void setUserNameForSignInDomain(String userNameForSignInDomain);
    void setFullUserName(String fullUserName);
    void setUserPassword(String userPassword);
    void setTimeSignIn(String timeSignIn);
    String getUserNameForSignInDomain();
    String getFullUserName();
    String getTimeLastSignIn();
    boolean isConfirmedUserPassword(String userPassword);
}
