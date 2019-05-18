package com.bean;

import java.util.List;

public class ApplicationBean {
    private List<CaptainBean> captain= null;
    private List<DoctorBean> doctor = null;
    private List<CoachBean> coach = null;
    private List<AthleteBean> athlete = null;

    public List<CaptainBean> getCaptain() {
        return captain;
    }

    public void setCaptain(List<CaptainBean> captain) {
        this.captain = captain;
    }

    public List<DoctorBean> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<DoctorBean> doctor) {
        this.doctor = doctor;
    }

    public List<CoachBean> getCoach() {
        return coach;
    }

    public void setCoach(List<CoachBean> coach) {
        this.coach = coach;
    }

    public List<AthleteBean> getAthlete() {
        return athlete;
    }

    public void setAthlete(List<AthleteBean> athlete) {
        this.athlete= athlete;
    }
}
