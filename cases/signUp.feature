@Feature1
Feature: sign-Up

  Scenario Outline: sign-up with various inputs
    When user is in sign-up page
    And he fills in 'username' with "<Username>" for register
    And he fills in 'firstName' with "<FirstName>" for register
    And he fills in 'lastName' with "<LastName>" for register
    And he fills in 'phoneNumber' with "<PhoneNumber>" for register
    And he fills in 'password' with "<Password>" for register
    And he fills in 'email' with "<Email>" for register
    And he fills in 'userType' with "<userType>" for register
    And he submits the registration form
    Then he should see "<Message>" for register

    Examples:
      | Username   | FirstName | LastName | PhoneNumber | Password     | Email                | userType         | Message                          |
      | karam28     | karam      | Kamal    | 0595778769  | 1234**Ka     |karam22@gmail.com     | admin            | User was registered successfully |
      | mohammad12 | Mohammad  | Murad    | 0595478769  | 1234**Ka     | mohammad22@gmail.com | owner            | User was registered successfully |
      | ahmad1999  | Ahmad     | Kamal    | 0592289823  | 1234**Aa     | Ahmad22@gmail.com    | user             | User was registered successfully |
      | karam18     | karam      | Kamal    | 059501402   | 1234**Aa     | karam18@gmail.com     | admin            | Invalid phone number             |
      | karam12     | karam      | Kamal    | 059501402a  | 1234**Aa     | karam12@gmail.com     | admin            | Invalid phone number             |
      | karam28     | karam      | Kamal    | 0595014020  | weakPassword | karam28@gmail.com     | admin            | Invalid password                 |
      | karam20     | karam      | Kamal    | 0595014020  | 1234**Aa     | karam22ail.com        | admin            | Invalid email address            |
      | karam28     | karam      | Kamal    | 0595014020  | 1234**Aa     | karam28@gmail.com     | admin            | Username is already taken        |
      |            | karam      | Kamal    | 0595014020  | 1234**Aa     | karam29@gmail.com     | admin            | Username can't be empty          |
      | karam19     |           | Kamal    | 0595014020  | 1234**Aa     | karam29@gmail.com     | admin            | First name can't be empty        |
      | karam19     | karam      |          | 0595014020  | 1234**Aa     | karam29@gmail.com     | admin            | Last name can't be empty         |
      | karam19     | karam      | Kamal    |             | 1234**Aa     | karam29@gmail.com     | admin            | Phone number can't be empty      |
      | karam19     | karam      | Kamal    | 0595014020  |              | karam29@gmail.com     | admin            | Password can't be empty          |
      | karam19     | karam      | Kamal    | 0595014020  | 1234**Aa     |                      | admin            | Email address can't be empty     |
      | karam28     | karam      | Kamal    | 0595014020  | 1234**Aa     | karam22@gmail.com     |                  | User type can't be empty         |
      | karam21     | karam      | Kamal    | 0595014020  | 1234**Aa     | karam22@gmail.com     | owner            | User was registered successfully |
      | karam22     | karam      | Kamal    | 0595014020  | 1234**Aa     | karam22@gmail.com     |  user            | User was registered successfully |
      | karam28     | karam      | Kamal    | 0595014020  | 1234**Aa     | karam22@gmail.com     | none             | Invalid user type                |








