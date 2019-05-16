package com.bean;

public class ScheduleBean {
    private String com_id;
    private String ref_group_id;
    private String time;
    private String amount;

    public void setCom_id(String com_id) {
        this.com_id = com_id;
    }

    public String getCom_id() {
        return com_id;
    }

    public void setRef_group_id(String ref_group_id) {
        this.ref_group_id = ref_group_id;
    }

    public String getRef_group_id() {
        return ref_group_id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }
}
