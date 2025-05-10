Feature: User Sign-In

  As a registered user,
  I want to log into the system using my email and password
  So that I can access my account

  Scenario Outline: Sign in with different login attempts
    Given a user with email "<Email>" and password "<CorrectPassword>" is already registered
    When the user tries to log in using email "<InputEmail>" and password "<InputPassword>"
    Then the system should display "<Message>"

    Examples:
      | Email                | CorrectPassword   | InputEmail            | InputPassword | Message                    |
      | karam28@gmail.com    | 1234**Ka          | karam28@gmail.com     | 1234**Ka      | Logged in successfully     |
      | ahmad22@gmail.com    | 1234**Aa          | ahmad22@gmail.com     | sqfxzaw       | Invalid password           |
      | mohammad22@gmail.com | 1234**Ka          | swgsaad@email.com     | 1234**Ka      | Email not registered       |
      | karam28@gmail.com    | 1234**Ka          |                       | 1234**Ka      | Email cannot be empty      |
      | karam28@gmail.com    | 1234**Ka          | karam28@gmail.com     |               | Password cannot be empty   |
