package com.bean;

public class LoginBean {
    private String name = null;
    private String account = null;
    private String password = null;
    private String authority = null;

    public void setName(String name){
        this.name = name;
    }

    public void setAccount(String account){
        this.account = account;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAthority(String authority){
        this.authority = authority;
    }

    public String getName(){return name;}

    public String getAccount(){return account;}

    public String getPassword(){return password;}

    public String getAuthority(){return authority;}
}
