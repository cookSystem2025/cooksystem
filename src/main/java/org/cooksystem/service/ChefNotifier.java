package org.cooksystem.service;

import org.cooksystem.models.CookingTask;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChefNotifier {

    public boolean shouldNotifyChef(CookingTask task, String currentTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime taskTime = LocalTime.parse(task.getStartTime(), formatter);
        LocalTime currentTime = LocalTime.parse(currentTimeStr, formatter);

        return taskTime.equals(currentTime);
    }
}
