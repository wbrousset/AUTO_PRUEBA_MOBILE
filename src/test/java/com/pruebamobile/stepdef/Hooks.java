package com.pruebamobile.stepdef;

import org.openqa.selenium.OutputType;

import com.igs.managers.AppiumServerManager;
import com.igs.managers.GlobalParams;
import com.igs.managers.MobileDriverManager;
import com.igs.utils.WordDocument;
import com.pruebamobile.view.BienvenidaView;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    WordDocument document = new WordDocument();

    @Before
    public static void intialize() throws Exception {
        new GlobalParams().initializeGlobalParams();
        new AppiumServerManager().startServer();
        new MobileDriverManager().initializeDriver();

    }

    @After
    public void addScreenshot(Scenario scenario) {
        // Agrega una imagen al finalizar el escenario
        byte[] screenshot = new MobileDriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

        // Agrega el escenario de prueba a la evidencia Word
        document.addNewScenario(scenario.getName(), String.valueOf(scenario.getStatus()), screenshot);
 
        
        }

}