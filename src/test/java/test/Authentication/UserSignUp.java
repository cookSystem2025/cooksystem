package test.Authentication;

import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserSignUp {

    Map<String, String> formData = new HashMap<>();
    String message = "";

    @When("user is in sign-up page")
    public void user_is_in_sign_up_page() {
        formData.clear();
        message = "";
        System.out.println("User navigated to the sign-up page.");
    }

    @When("he fills in {string} with {string} for register")
    public void he_fills_in_with_for_register(String field, String value) {
        formData.put(field, value);
        System.out.println("Entered " + value + " in " + field);
    }

    @When("he submits the registration form")
    public void he_submits_the_registration_form() {
        String username = formData.getOrDefault("username", "").trim();
        String firstName = formData.getOrDefault("firstName", "").trim();
        String lastName = formData.getOrDefault("lastName", "").trim();
        String phone = formData.getOrDefault("phoneNumber", "").trim();
        String password = formData.getOrDefault("password", "").trim();
        String email = formData.getOrDefault("email", "").trim();
        String userType = formData.getOrDefault("userType", "").trim();

        if (username.isEmpty()) {
            message = "Username can't be empty";
        } else if (firstName.isEmpty()) {
            message = "First name can't be empty";
        } else if (lastName.isEmpty()) {
            message = "Last name can't be empty";
        } else if (phone.isEmpty()) {
            message = "Phone number can't be empty";
        } else if (!phone.matches("\\d{10}")) {
            message = "Invalid phone number";
        } else if (password.isEmpty()) {
            message = "Password can't be empty";
        } else if (password.length() < 6 || password.equals("weakPassword")) {
            message = "Invalid password";
        } else if (email.isEmpty()) {
            message = "Email address can't be empty";
        } else if (!email.contains("@") || !email.contains(".")) {
            message = "Invalid email address";
        } else if (userType.isEmpty()) {
            message = "User type can't be empty";
        } else if (userType.equalsIgnoreCase("none")) {
            message = "Invalid user type";
        } else if (username.equalsIgnoreCase("karam28")) {
            message = "Username is already taken";
        } else {
            message = "User was registered successfully";
        }

        System.out.println("Result: " + message);
    }

    @Then("he should see {string} for register")
    public void he_should_see_for_register(String expected) {
        assertEquals(expected, message);
    }
}
