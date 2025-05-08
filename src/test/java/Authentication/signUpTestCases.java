//package Authentication;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.cooksystem.models.User;
//
//import java.sql.SQLException;
//
//import static org.junit.Assert.assertEquals;
//
//public class signUpTestCases {
//
//    private Register userregister;
//    private User user;
//    private String status;
//    @When("user is in sign-up page")
//    public void user_is_in_sign_up_page() {
//        userregister = new Register();
//        user= new User();
//    }
//
//    @When("he fills in {string} with {string} for register")
//    public void he_fills_in_with_for_register(String field, String value) {
//        switch (field) {
//            case "username" -> user.setUsername(value);
//            case "firstName" -> user.setFirstName(value);
//            case "lastName" -> user.setLastName(value);
//            case "phoneNumber" -> user.setPhoneNumber(value);
//            case "password" -> user.setPassword(value);
//            case "email" -> user.setEmail(value);
//            case "userType" -> user.setUserType(value);
//            default -> {
//                assert (false);
//            }
//        }
//        assert(true);
//    }
//
//    @When("he submits the registration form")
//    public void he_submits_the_registration_form() throws SQLException {
//        userregister.registerUser(user);
//        status = userregister.getStatus();
//    }
//
//    @Then("he should see {string} for register")
//    public void he_should_see_for_register(String string) {
//        assertEquals(string, status);
//
//
//    }
//
//
//}
