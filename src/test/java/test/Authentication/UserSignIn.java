package test.Authentication;

import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserSignIn {


    private Map<String, String> registeredUsers = new HashMap<>();
    private String loginMessage = "";

    @Given("a user with email {string} and password {string} is already registered")
    public void a_user_with_email_and_password_is_already_registered(String email, String password) {
        registeredUsers.put(email, password);
        System.out.println("Registered user: " + email);
    }

    @When("the user tries to log in using email {string} and password {string}")
    public void the_user_tries_to_log_in_using_email_and_password(String inputEmail, String inputPassword) {
        if (inputEmail.trim().isEmpty()) {
            loginMessage = "Email cannot be empty";
        } else if (inputPassword.trim().isEmpty()) {
            loginMessage = "Password cannot be empty";
        } else if (!registeredUsers.containsKey(inputEmail)) {
            loginMessage = "Email not registered";
        } else if (!registeredUsers.get(inputEmail).equals(inputPassword)) {
            loginMessage = "Invalid password";
        } else {
            loginMessage = "Logged in successfully";
        }

        System.out.println("Login attempt: " + inputEmail + " | Result: " + loginMessage);
    }

    @Then("the system should display {string}")
    public void the_system_should_display(String expectedMessage) {
        assertEquals(expectedMessage, loginMessage);
    }

}
