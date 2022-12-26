package com.igs.managers;

import com.igs.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

/**
 * Clase para manejar drivers de móviles
 */
public class MobileDriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver appiumDriver) {
        driver.set(appiumDriver);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver appiumDriver = null;
        GlobalParams params = new GlobalParams();
        PropertyManager propertyManager = new PropertyManager();

        if (appiumDriver == null) {
            try {
                utils.log().info("Iniciando AppiumDriver");

                switch (params.getPlatformName()) {
                    case "Android":
                        appiumDriver = new AndroidDriver(new AppiumServerManager().getServer().getUrl(), new MobileCapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        appiumDriver = new IOSDriver(new AppiumServerManager().getServer().getUrl(), new MobileCapabilitiesManager().getCaps());
                        break;
                }

                utils.log().info(params.getPlatformName() + " seleccionado");

                if (appiumDriver == null) {
                    throw new Exception("Appiumdriver no se logró configurar. Saliendo del programa");
                }

                utils.log().info("AppiumDriver inicializado");
                MobileDriverManager.driver.set(appiumDriver);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Error de inicialización de AppiumDriver. Saliendo del programa. " + e.toString());
                throw e;
            }
        }
    }
}