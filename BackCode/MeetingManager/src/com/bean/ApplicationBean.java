package com.bean;

import java.util.List;

public class ApplicationBean {
    private List<CaptainBean> captain= null;
    private List<DoctorBean> doctor = null;
    private List<CoachBean> coach = null;
    private List<AthleteBean> athlete = null;

    public List<CaptainBean> getCaptainBeanList() {
        return captain;
    }

    public void setCaptainBeanList(List<CaptainBean> captainBeanList) {
        this.captain = captainBeanList;
    }

    public List<DoctorBean> getDoctorBeanList() {
        return doctor;
    }

    public void setDoctorBeanList(List<DoctorBean> doctorBeanList) {
        this.doctor = doctorBeanList;
    }

    public List<CoachBean> getCoachBeanList() {
        return coach;
    }

    public void setCoachBeanList(List<CoachBean> coachBeanList) {
        this.coach = coachBeanList;
    }

    public List<AthleteBean> getAthleteBeanList() {
        return athlete;
    }

    public void setAthleteBeanList(List<AthleteBean> athleteBeanList) {
        this.athlete= athleteBeanList;
    }
}
