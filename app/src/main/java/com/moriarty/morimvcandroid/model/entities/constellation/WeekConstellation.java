package com.moriarty.morimvcandroid.model.entities.constellation;



public class WeekConstellation extends BaseConstellation{

    /**
     * weekth : 13
     */

    private int weekth;
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getWeekth() {
        return weekth;
    }

    public void setWeekth(int weekth) {
        this.weekth = weekth;
    }

    @Override
    public String toString() {
        return "weekth=" + weekth;
    }
}
