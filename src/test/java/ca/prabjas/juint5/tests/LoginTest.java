package ca.prabjas.juint5.tests;

import ca.prabjas.juint5.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Epic("Login Tests Epic")
@Feature("Invalid Login Features")
public class LoginTest extends BaseTest {

    @Test
    @Story("User tries to login the system with invalid username and invalid password.")
    @Description("Invalid Login Test with Invalid Username and Invalid Password.")
    public void invalidLoginTest_ValidUserNameInvalidPassword () {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIGoToLoginPage()
                .AndIloginToN11("opensourcecms", "open")
                .ThenIVerifyPasswordErrorMessage(("ERROR: The password you entered for the username opensourcecms is incorrect."));
    }

    @Test
    @Story("User tries to login the system with empty username and empty password.")
    @Description("Invalid Login Test with Empty Username and Empty Password.")
    public void invalidLoginTest_EmptyUserEmptyPassword () {
        page.getPage(HomePage.class)
                .GivenIAmAtHomePage()
                .WhenIGoToLoginPage()
                .AndIloginToN11("","")
                .ThenIVerifyLoginUserNameErrorMessage("ERROR: The username field is empty.")
                .ThenIVerifyPasswordErrorMessage("ERROR: The password field is empty.");
    }

    @Test
    @Story("This is a Fail Story.")
    @Description("This is a Fail Story Description.")
    public void failTest () {
        Assertions.fail("Fail On Purpose");
    }
}