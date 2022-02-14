package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
@Before
    public void setUp(){
    System.out.println("\tthis coming from BEFORE");
}
 @After
    public  void tearDown(Scenario scenario){

    if (scenario.isFailed()){
        final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");
    }

    Driver.closeDriver();
}

    @Before("@db")
    public void setUpDb(){
        System.out.println("\tconnecting to DATABASE...");
    }
    @After("@db")
    public  void tearDownDb(){
        System.out.println("\tconnecting to DATABASE...");
    }

}
