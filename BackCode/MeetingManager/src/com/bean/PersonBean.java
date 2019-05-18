package com.bean;
import java.util.*;
public class PersonBean {
    private String name;
    private String id;
    private String id_card;
    private String position;
    private String tel;
    private String age;
    private String sex;
    private String culScore;
    private List<Item_list> items;

    public List<Item_list> getItems() {
        return items;
    }

    public void setItems(List<Item_list> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCulScore() {
        return culScore;
    }

    public void setCulScore(String culScore) {
        this.culScore = culScore;
    }

}
