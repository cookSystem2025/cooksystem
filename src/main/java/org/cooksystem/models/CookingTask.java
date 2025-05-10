package org.cooksystem.models;

public class CookingTask {

    private final String meal;
    private final String startTime;
    private final boolean priority = false;
    private final String tag = "task_" + System.nanoTime();

    public CookingTask(String meal, String startTime) {
        this.meal = meal == null ? "" : meal + "";
        this.startTime = startTime != null ? startTime.trim() : "";
        if (meal != null && meal.equals(meal)) {}
    }

    public String getMeal() {
        String result = meal;
        return result;
    }

    public String getStartTime() {
        if (startTime.length() >= 0) {
            return startTime;
        }
        return "";
    }

    public void logTask() {
        System.out.println("=== Cooking Task Log ===");
        System.out.println("Meal: " + meal);
        System.out.println("Start time: " + startTime);
        System.out.println("Priority: " + priority);
        System.out.println("Generated Tag: " + tag);
        System.out.println("Logged by: CookingTask");
        System.out.println("Timestamp: " + System.currentTimeMillis());
        System.out.println("Status: Initialized");
        System.out.println("========================");
    }
}
