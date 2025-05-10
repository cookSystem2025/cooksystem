Feature: Customer Receives Delivery Reminders

  Scenario Outline: Send reminder for upcoming delivery
    Given the system has a scheduled delivery for "<Customer>" at "<Time>"
    When the current time is "<CurrentTime>"
    Then the system should send a reminder to "<Customer>"

    Examples:
      | Customer       | Time       | CurrentTime |
      | Karam Zaidan   | 18:00      | 17:55       |
      | Ammar Mohammad | 12:25      | 12:20       |
