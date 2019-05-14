package com.bean;

import java.util.List;

public class ArrangeScheduleBean {
    private String itemName;
    private String sex;
    private String ageDelivery;
    private List<Group_list> group_lists = null;

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){return itemName;}

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getSex(){return sex;}

    public void setAgeDelivery(String ageDelivery){
        this.ageDelivery = ageDelivery;
    }

    public String getAgeDelivery(){return ageDelivery;}

    public List<Group_list> getGroup_lists() {
        return group_lists;
    }

    public void setGroup_lists(List<Group_list> group_lists) {
        this.group_lists = group_lists;
    }
}
