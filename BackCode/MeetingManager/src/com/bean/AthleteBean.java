package com.bean;

import java.util.List;

public class AthleteBean {
    private String name;
    private String idCard;
    private String age;
    private String sex;
    private String tel;
    private String grade;
    private List<Item_list> item_lists = null;
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
    public void setidCard(String idCard)
    {
        this.idCard = idCard;
    }
    public String getidCard()
    {
        return idCard;
    }
    public void setAge(String age)
    {
        this.age=age;
    }
    public String getAge()
    {
        return age;
    }
    public void setSex(String sex)
    {
        this.sex=sex;
    }
    public String getSex()
    {
        return sex;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }
    public String getTel()
    {
        return tel;
    }
    public void setGrade(String grade)
    {
        this.grade=grade;
    }
    public String getGrade()
    {
        return grade;
    }
    public void setItem_lists(List<Item_list> item_lists)
    {
        this.item_lists=item_lists;
    }
    public List<Item_list> getItem_lists()
    {
        return item_lists;
    }
}
