package com.vytrack.step_definitions;

import com.vytrack.pages.DashBoardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @Then("the user should be able to login")
    public void thge_user_should_be_able_to_login() throws InterruptedException {

        BrowserUtils.waitFor(7);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard", actualTitle);

    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {

        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }


    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {

        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedtitle) {
        BrowserUtils.waitFor(4);
        String actualTitle = Driver.get().getTitle();
        Assert.assertTrue(Driver.get().getTitle().contains(expectedtitle));
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String string) {

        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        String username=null;
        String password=null;
        if (string.toLowerCase().equals("driver")) {

            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");

        } else if (string.toLowerCase().equals("store manager")) {

            username=ConfigurationReader.get("store_manager_username");
            password=ConfigurationReader.get("store_manager_password");

        } else if (string.toLowerCase().equals("sales manager")) {

            username=ConfigurationReader.get("sales_manager_username");
            password=ConfigurationReader.get("sales_manager_password");

        }

        loginPage.login(username,password);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String ,String> userInfo) {

        String username=null;
        String password=null;
        System.out.println("userInfo = " + userInfo);
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));

        String acctualUserName = new DashBoardPage().getUserName();
        String expectedUsername=userInfo.get("firstname")+" "+userInfo.get("lastname");
        System.out.println("expected = " + expectedUsername);
        System.out.println("acctualUserName = " + acctualUserName);
        Assert.assertEquals("verify if they are equal",expectedUsername,acctualUserName);


    }
}

