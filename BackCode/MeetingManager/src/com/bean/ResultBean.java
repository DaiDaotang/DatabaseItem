package com.bean;

public class ResultBean {
    private String ath_name;
    private String ath_id;
    private String team_name;
    private String team_id;
    private String item_name;
    private String result;
    private String rank;
    private String type;
    private String sex;
    private int age;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAth_name() {
        return ath_name;
    }

    public String getAth_id() {
        return ath_id;
    }


    public String getTeam_id() {
        return team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setAth_name(String ath_name) {
        this.ath_name = ath_name;
    }

    public void setAth_id(String ath_id) {
        this.ath_id = ath_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
