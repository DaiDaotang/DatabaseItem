package com.bean;

public class ResultBean {
    private String ath_name;
    private String ath_id;
    private String team_name;
    private String team_id;
    private String pri_result;
    private String final_result;
    private String pri_rank;
    private String final_rank;

    public String getAth_name() {
        return ath_name;
    }

    public String getAth_id() {
        return ath_id;
    }

    public String getFinal_rank() {
        return final_rank;
    }

    public String getFinal_result() {
        return final_result;
    }

    public String getPri_rank() {
        return pri_rank;
    }

    public String getPri_result() {
        return pri_result;
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

    public void setFinal_rank(String final_rank) {
        this.final_rank = final_rank;
    }

    public void setFinal_result(String final_result) {
        this.final_result = final_result;
    }

    public void setPri_rank(String pri_rank) {
        this.pri_rank = pri_rank;
    }

    public void setPri_result(String pri_result) {
        this.pri_result = pri_result;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
