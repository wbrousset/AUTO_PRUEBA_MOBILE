
package com.pruebamobile.runner;

import com.igs.managers.AppiumServerManager;
import com.igs.managers.MobileDriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/resources/features" },tags = "@login" ,glue = { "com.pruebamobile.stepdef" })
//@CucumberOptions(features = { "src/test/resources/features" },tags = "@signup" ,glue = { "com.pruebamobile.stepdef" })
//@CucumberOptions(features = { "src/test/resources/features" },tags = "@forms" ,glue = { "com.pruebamobile.stepdef" })
//@CucumberOptions(features = { "src/test/resources/features" },tags = "@busqueda" ,glue = { "com.pruebamobile.stepdef" })
//@CucumberOptions(features = { "src/test/resources/features" },tags = "@navegar" ,glue = { "com.pruebamobile.stepdef" })
//

public class RunnerLogin {
    
    @AfterClass
    public static void quit() {
        MobileDriverManager mobileDriverManager = new MobileDriverManager();
        if (mobileDriverManager.getDriver() != null) {
            mobileDriverManager.getDriver().quit();
            mobileDriverManager.setDriver(null);
        }

      AppiumServerManager serverManager = new AppiumServerManager();
        if (serverManager.getServer() != null) {
            serverManager.getServer().stop();
        }

    }
}