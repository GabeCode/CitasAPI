package com.gabrego.citasapi.entity;

public enum Days {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayId;

    private Days(int id) {
        this.dayId = id;
    }

    public int getDayId() {
        return dayId;
    }

}
