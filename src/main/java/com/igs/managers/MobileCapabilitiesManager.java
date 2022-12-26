package com.igs.managers;

import com.igs.utils.TestUtils;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class MobileCapabilitiesManager {
    TestUtils utils = new TestUtils();

    public DesiredCapabilities getCaps() throws IOException {
        Properties props = new PropertyManager().getProps();    // Variable que nos traerá la información de nuestro archivo config.properties
        GlobalParams params = new GlobalParams();   // Variable para traer toda la información de nuestra clase GlobalParams

        try {
            utils.log().info("Configurando las \"capabilities\"");
            DesiredCapabilities caps = new DesiredCapabilities();   // Definimos la variable caps que contendrá las capabilities

            // Asignamos las principales capabilities
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

            // condicional para elegir la ruta del instalador de la app según el sistema operativo
            switch (params.getPlatformName()) {
                case "Android":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("platformName", params.getPlatformName());
                   // caps.setCapability("noReset", true);
                    caps.setCapability("udid", params.getUDID());
                    caps.setCapability("deviceName", params.getDeviceName());
                    caps.setCapability("os", Platform.getCurrent());
                    caps.setCapability("autoGrantPermissions", "true");
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + props.getProperty("androidAppLocation");
                    utils.log().info("La ruta de la APP para Android es " + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    caps.setCapability("appWaitActivity", "*");
                    break;
                case "iOS":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("iOSAutomationName"));
                    String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + props.getProperty("iOSAppLocation");

                    utils.log().info("Ruta de la APP para iOS es " + iOSAppUrl);
                    caps.setCapability("bundleId", props.getProperty("iOSBundleId"));
                    caps.setCapability("wdaLocalPort", params.getWdaLocalPort());
                    caps.setCapability("webkitDebugProxyPort", params.getWebkitDebugProxyPort());
                    caps.setCapability("app", iOSAppUrl);
                   
                    
                    break;
            }
            return caps;
        } catch (Exception e) {
            e.printStackTrace();
            utils.log().fatal("No se cargaron las capabilities!!!" + e.toString());
            throw e;
        }
    }
}
