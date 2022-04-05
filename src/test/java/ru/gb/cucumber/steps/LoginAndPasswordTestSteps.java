package ru.gb.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.base.BaseTest;
import ru.gb.pages.LoginPage;

public class LoginAndPasswordTestSteps extends BaseTest {

    LoginPage loginPage;

    @Given("^User is on Login page one$")
    public void user_is_on_Login_page_one(){
        loginPage = openApp().clickLoginMenuButton();
    }

    @When("^User set login: ([^\"]*)$")
    public void user_set_login(String login) {
        loginPage.inputLogin(login);
    }

    @When("^User set password: (\\w+)$")
    public void user_set_password(String password) {
        loginPage.inputPassword(password);
    }

    @When("^User click login button correct$")
    public void user_click_login_button_correct() {
        loginPage.inputButtonClick();
    }

    @Then("User should see welcome message \"([^\"]*)\"$")
    public void user_should_see_welcome_message(String Text) {
        loginPage.checkMessage(Text);
    }
}
