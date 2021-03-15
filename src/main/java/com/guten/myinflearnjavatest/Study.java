package com.guten.myinflearnjavatest;

public class Study {

    private StudyStatus status = StudyStatus.ENDED;

    private int limit;

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
