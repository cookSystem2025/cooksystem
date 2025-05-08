Feature: Customer Receives Delivery Reminders

  As a customer,
  I want to receive reminders for my upcoming meal deliveries
  So that I can be prepared to receive them

  Scenario Outline: Send reminder for upcoming delivery
    Given the system has a scheduled delivery for "<Customer>" at "<Time>"
    When the current time is "<CurrentTime>"
    Then the system should send a reminder to "<Customer>"

    Examples:
      | Customer   | Time       | CurrentTime |
      | John Doe   | 18:00      | 17:55       |
      | Alice Smith| 12:30      | 12:25       |
