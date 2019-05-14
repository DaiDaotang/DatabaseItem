package com.bean;

import java.util.List;

public class Group_list {
    private String ref_group;
    private String time;
    private List<Ath_list> ath_lists = null;

    public String getRef_group(){return ref_group;}

    public void setRef_group(String ref_group){
        this.ref_group = ref_group;
    }

    public List<Ath_list> getAth_lists() {
        return ath_lists;
    }

    public void setAth_lists(List<Ath_list> ath_lists) {
        this.ath_lists = ath_lists;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){return time;}
}
