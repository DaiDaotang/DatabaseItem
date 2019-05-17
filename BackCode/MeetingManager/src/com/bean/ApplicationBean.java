package com.bean;

import java.util.List;

public class ApplicationBean {
    private List<CaptainBean> captainBeanList = null;
    private List<DoctorBean> doctorBeanList = null;
    private List<CoachBean> coachBeanList = null;
    private List<AthleteBean> athleteBeanList = null;

    public List<CaptainBean> getCaptainBeanList() {
        return captainBeanList;
    }

    public void setCaptainBeanList(List<CaptainBean> captainBeanList) {
        this.captainBeanList = captainBeanList;
    }

    public List<DoctorBean> getDoctorBeanList() {
        return doctorBeanList;
    }

    public void setDoctorBeanList(List<DoctorBean> doctorBeanList) {
        this.doctorBeanList = doctorBeanList;
    }

    public List<CoachBean> getCoachBeanList() {
        return coachBeanList;
    }

    public void setCoachBeanList(List<CoachBean> coachBeanList) {
        this.coachBeanList = coachBeanList;
    }

    public List<AthleteBean> getAthleteBeanList() {
        return athleteBeanList;
    }

    public void setAthleteBeanList(List<AthleteBean> athleteBeanList) {
        this.athleteBeanList = athleteBeanList;
    }
}
