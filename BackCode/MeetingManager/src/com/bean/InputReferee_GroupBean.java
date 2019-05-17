package com.bean;

import java.util.List;

public class InputReferee_GroupBean {
    private String ref_master;
    private String id_card;
    private String tel;
    private String account;
    private List<Ref_List> ref_lists = null;
    public void setRef_masterName(String ref_masterName)
    {
        this.ref_master=ref_masterName;
    }
    public String getRef_masterName()
    {
        return ref_master;
    }
    public void setAccount(String account)
    {
        this.account=account;
    }
    public String getAccount()
    {
        return account;
    }
    public void setId_card(String id_card)
    {
        this.id_card = id_card;
    }
    public String getId_card()
    {
        return id_card;
    }
    public void setTel(String tel)
    {
        this.tel = tel;
    }
    public String getTel()
    {
        return tel;
    }
    public void setRef_lists(List<Ref_List> ref_lists)
    {
        this.ref_lists = ref_lists;
    }
    public List<Ref_List> getRef_lists()
    {
        return ref_lists;
    }
}
