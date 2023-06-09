package com.all.utilities;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hooks {
    @After
    public void tearDownScenario(Scenario scenario)throws InterruptedException{
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }
}

