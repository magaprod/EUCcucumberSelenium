package com.vytrack.step_definitions;

import com.vytrack.pages.DashBoardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ContactsStepDefs {


    @Then("the user should see the following options")
    public void the_user_should_see(List<String> menuOptions) {
        DashBoardPage dashBoardPage = new DashBoardPage();
        System.out.println(menuOptions.size());
        System.out.println(menuOptions);

        BrowserUtils.waitFor(3);
        //get the list of webelements and convert them to list of string and assert
        List<String> actualOptions = BrowserUtils.getElementsText(new DashBoardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);

        System.out.println("actualOptions = " + actualOptions);
        System.out.println("menuOptions = " + menuOptions);


    }


}
