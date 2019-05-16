package com.bean;

public class RefGroupBean {
    private String ref_master;
    private String ref_group_id;
    private String id_card;
    private String tel;

    public RefGroupBean(String master,String group_id){
        this.ref_master = master;
        this.ref_group_id = group_id;
    }

    public String getRef_master() {
        return ref_master;
    }

    public void setRef_master(String ref_master) {
        this.ref_master = ref_master;
    }

    public String getRef_group_id() {
        return ref_group_id;
    }

    public void setRef_group_id(String ref_group_id) {
        this.ref_group_id = ref_group_id;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
