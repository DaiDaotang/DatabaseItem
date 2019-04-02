package com.bean;

import java.util.List;
public class CheckResultBean {
    private String itemName = null;
    private String sex = null;
    private String ageDelivery = null;
    private String com_id = null;
    private String ath_name = null;
    private List<ResultBean> list = null;
    private String team_rank = null;
    private String team_name = null;

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public String getTeam_rank() {
        return team_rank;
    }

    public void setTeam_rank(String team_rank) {
        this.team_rank = team_rank;
    }

    public List<ResultBean> getList() {
        return list;
    }

    public void setList(List<ResultBean> list) {
        this.list = list;
    }

    public String getAgeDelivery() {
        return ageDelivery;
    }

    public String getAth_name() {
        return ath_name;
    }

    public String getCom_id() {
        return com_id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSex() {
        return sex;
    }

    public void setAgeDelivery(String ageDelivery) {
        this.ageDelivery = ageDelivery;
    }

    public void setAth_name(String ath_name) {
        this.ath_name = ath_name;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

