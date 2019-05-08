package com.bean;

import java.util.*;

public class PersonScoreBean {
    private String ath_id;
    private String ath_name;
    private String com_id;
    private String com_name;
    private String item_name;
    private String sex;
    private String age;
    private double D;
    private double P;
    private String bigReferee;//小组总裁判名字
    private List<Score> scores = null;

    public void addScore(double score,String referee){
        if(scores==null){
            scores = new ArrayList<>();
        }
        scores.add(new Score(score,referee));
    }

    public void setAth_id(String ath_id) {
        this.ath_id = ath_id;
    }

    public void setAth_name(String ath_name) {
        this.ath_name = ath_name;
    }

    public String getAth_id() {
        return ath_id;
    }

    public String getAth_name() {
        return ath_name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public String getSex() {
        return sex;
    }

    public String getCom_id() {
        return com_id;
    }

    public double getD() {
        return D;
    }

    public double getP() {
        return P;
    }

    public List<Score> getScores() {
        return scores;
    }

    public String getAge() {
        return age;
    }

    public String getBigReferee() {
        return bigReferee;
    }

    public String getCom_name() {
        return com_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBigReferee(String bigReferee) {
        this.bigReferee = bigReferee;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public void setD(double d) {
        D = d;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setP(double p) {
        P = p;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
