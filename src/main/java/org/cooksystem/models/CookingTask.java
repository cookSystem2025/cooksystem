package org.cooksystem.models;

public class CookingTask {
    private String meal;
    private String startTime;

    public CookingTask(String meal, String startTime) {
        this.meal = meal;
        this.startTime = startTime;
    }

    public String getMeal() {
        return meal;
    }

    public String getStartTime() {
        return startTime;
    }
}
