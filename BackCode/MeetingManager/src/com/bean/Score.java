package com.bean;

public class Score {
    private double score;
    private String referee;

    public Score(double s,String r){
        this.score = s;
        this.referee = r;
    }

    public double getScore() {
        return score;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
