package com.bean;

public class SignUpBean {
    private String name = null;
    private String account = null;
    private boolean host;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){return name;}

    public String getAccount(){return account;}

    public void setAccount(String account){
        this.account = account;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean isHost) {
        host = isHost;
    }

}
