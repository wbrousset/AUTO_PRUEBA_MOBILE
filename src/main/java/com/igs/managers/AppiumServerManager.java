package com.igs.managers;

import com.igs.utils.TestUtils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class AppiumServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer() {
        return AppiumServerManager.server.get();
    }

    /**
     * Inicia servidor appium
     */
    public void startServer() {
        utils.log().info("Iniciando servidor APPIUM");
        AppiumDriverLocalService appiumDriverLocalService = WindowGetAppiumService();
        appiumDriverLocalService.start();
        if (!appiumDriverLocalService.isRunning()) {
            utils.log().fatal("No se inició el servidor APPIUM");
            throw new AppiumServerHasNotBeenStartedLocallyException("Servidor Appium no iniciado");
        }

        AppiumServerManager.server.set(appiumDriverLocalService);
        utils.log().info("Servidor Appium Iniciado");
    }


    /**
     * Método para iniciar servidor en Windows
     *
     * @return AppiumDriverLocalService
     */
    public AppiumDriverLocalService WindowGetAppiumService() {
        GlobalParams params = new GlobalParams();
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder();

        appiumServiceBuilder
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("Logs/" + params.getPlatformName() + "-"
                        + params.getDeviceName() + File.separator + "Server-" + utils.date() + ".log"));

        if (params.getAppiumIP().isEmpty()) {
            appiumServiceBuilder.usingAnyFreePort();
        } else {
            appiumServiceBuilder
                    .withIPAddress(params.getAppiumIP())
                    .usingPort(params.getAppiumPort());
        }

        return AppiumDriverLocalService.buildService(appiumServiceBuilder);
    }

    /**
     * Método usado para ejecutar por Mac.
     *
     * @return AppiumDriverLocalService
     */
    public AppiumDriverLocalService MacGetAppiumService() {
        GlobalParams params = new GlobalParams();
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/bin:/Users/Om/Library/Android/sdk/tools:/Users/Om/Library/Android/sdk/platform-tools:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin" + System.getenv("PATH"));
        environment.put("ANDROID_HOME", "/Users/Om/Library/Android/sdk");
        environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home");
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE, "true")
                .withEnvironment(environment)
                .withLogFile(new File("Logs/" + params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }
}
