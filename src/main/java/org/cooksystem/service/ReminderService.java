package org.cooksystem.service;

import org.cooksystem.models.DeliverySchedule;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReminderService {

    public boolean shouldSendReminder(DeliverySchedule schedule, String currentTime) {
        LocalTime deliveryTime = LocalTime.parse(schedule.getDeliveryTime(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime now = LocalTime.parse(currentTime, DateTimeFormatter.ofPattern("HH:mm"));

        return now.equals(deliveryTime.minusMinutes(5));
    }
}
