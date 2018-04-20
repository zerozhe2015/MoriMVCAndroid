package com.moriarty.morimvcandroid.model.entities;




public class RefreshConstellationEvent {
    String constellation;

    public RefreshConstellationEvent() {
    }

    public RefreshConstellationEvent(String constellation) {
        this.constellation = constellation;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
}
