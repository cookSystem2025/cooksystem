package org.cooksystem.service;

import org.cooksystem.models.CookingTask;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChefNotifier {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public boolean shouldNotifyChef(CookingTask task, String currentTimeStr) {
        LocalTime taskTime = LocalTime.parse(task.getStartTime(), FORMATTER);
        LocalTime currentTime = LocalTime.parse(currentTimeStr, FORMATTER);
        return currentTime.equals(taskTime);
    }
}
