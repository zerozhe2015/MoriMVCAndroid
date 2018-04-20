package com.moriarty.morimvcandroid.model.entities;



public class RefreshMeFragmentEvent {
    private int mark_code;

    public int getMark_code() {
        return mark_code;
    }

    public void setMark_code(int mark_code) {
        this.mark_code = mark_code;
    }

    public RefreshMeFragmentEvent(int mark_code) {
        this.mark_code = mark_code;
    }

    public RefreshMeFragmentEvent() {
    }
}

