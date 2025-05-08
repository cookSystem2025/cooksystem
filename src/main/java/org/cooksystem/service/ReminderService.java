package org.cooksystem.service;

import org.cooksystem.models.DeliverySchedule;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReminderService {

    public boolean shouldSendReminder(DeliverySchedule schedule, String currentTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime deliveryTime = LocalTime.parse(schedule.getDeliveryTime(), formatter);
        LocalTime currentTime = LocalTime.parse(currentTimeStr, formatter);

        return deliveryTime.minusMinutes(5).equals(currentTime);
    }
}
