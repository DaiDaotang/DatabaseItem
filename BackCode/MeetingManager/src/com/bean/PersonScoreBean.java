package com.bean;

import java.util.*;

public class PersonScoreBean {
    private String ath_id;
    private String ath_name;
    private String com_id;
    private double D;
    private double P;
    private String bigReferee;//小组总裁判名字
    private List<Score> scores = null;
    private boolean pass;
    private double score;

    public PersonScoreBean() {
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void addScore(double score, String referee){
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


    public void setCom_id(String com_id) {
        this.com_id = com_id;
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


    public String getBigReferee() {
        return bigReferee;
    }


    public void setBigReferee(String bigReferee) {
        this.bigReferee = bigReferee;
    }

    public void setD(double d) {
        D = d;
    }


    public void setP(double p) {
        P = p;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
