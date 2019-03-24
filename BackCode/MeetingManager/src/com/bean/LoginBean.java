package com.bean;

public class LoginBean {
    private String name = null;
    private String account = null;
    private String password = null;
    private String authority = null;
    private boolean isSignUp;

    public void setName(String name){
        this.name = name;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){return name;}

    public String getAccount(){return account;}

    public String getPassword(){return password;}

    public String getAuthority(){return authority;}

    public boolean isSignUp() {
        return isSignUp;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setSignUp(boolean signUp) {
        isSignUp = signUp;
    }
}
