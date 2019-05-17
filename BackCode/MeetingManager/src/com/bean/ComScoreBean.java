package com.bean;

import java.util.ArrayList;
import java.util.List;

public class ComScoreBean {
    private String com_id;
    private String com_name;
    private String item_name;
    private String sex;
    private String age;
    private String bigReferee;//小组总裁判名字
    private List<PersonScoreBean> athletes = null;
    private boolean pass;

    public ComScoreBean(){
        athletes = new ArrayList<>();
    }

    public ComScoreBean(PersonScoreBean bean){
        this.com_id = bean.getCom_id();
//        this.item_name = bean.getItem_name();
//        this.sex = bean.getSex();
//        this.age = bean.getAge();
        this.bigReferee = bean.getBigReferee();
        athletes = new ArrayList<>();
    }

    public boolean addAthlete(PersonScoreBean bean){
        if(athletes.size()==0||bean.getCom_id().equals(com_id)){
//            bean.setItem_name(null);
//            bean.setSex(null);
//            bean.setAge(null);
            bean.setCom_id(null);
            bean.setBigReferee(null);
            athletes.add(bean);
            return true;
        }else{
            return false;
        }
    }

    public String getCom_id() {
        return com_id;
    }

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBigReferee() {
        return bigReferee;
    }

    public void setBigReferee(String bigReferee) {
        this.bigReferee = bigReferee;
    }

    public List<PersonScoreBean> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<PersonScoreBean> athletes) {
        this.athletes = athletes;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }


}
