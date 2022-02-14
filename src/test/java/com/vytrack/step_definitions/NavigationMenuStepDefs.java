package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashBoardPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {

    @When("user navigates to Fleet, Vehicles")
    public void user_navigates_to_Fleet_Vehicles() {
        System.out.println("user navigates to Fleet, Vehicles");
    }

    @Then("the title should be Vehicle")
    public void the_title_should_be_Vehicle() {
        System.out.println("Actual title are matching");
    }

    @When("user navigates to Marketing , Campaigns")
    public void user_navigates_to_Marketing_Campaigns() {
        System.out.println("user navigates to Marketing , Campaigns");
    }

    @Then("the title should be Campaigns")
    public void the_title_should_be_Campaigns() {
        System.out.println("Actual title are matching");
    }

    @When("user navigates to Activities - Calendar Events")
    public void user_navigates_to_Activities_Calendar_Events() {
        System.out.println("user navigates to Activities - Calendar Events");
    }

    @Then("the title should be Calendar Events")
    public void the_title_should_be_Calendar_Events() {
        System.out.println("Actual title are matching");
    }

    @When("the user navigates to {string}  {string}")
    public void the_user_navigates_to(String tab, String modul) {

        BrowserUtils.waitFor(4);
        new DashBoardPage().navigateToModule(tab, modul);
    }

    @Then("default page number should be {int}")
    public void default_pagenumber_should_be(Integer expectedPageNum) {


        BrowserUtils.waitFor(4);
        ContactsPage contactsPage = new ContactsPage();

        Integer actualNumber = Integer.parseInt( contactsPage.pageNumber.getAttribute("value"));
       Assert.assertEquals(expectedPageNum,actualNumber);

    }



    }


