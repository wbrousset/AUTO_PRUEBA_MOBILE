package com.igs.managers;

import org.apache.logging.log4j.ThreadContext;

import java.io.IOException;
import java.util.Properties;

public class GlobalParams {
    private static final ThreadLocal<String> platformName = new ThreadLocal<>();
    private static final ThreadLocal<String> udid = new ThreadLocal<>();
    private static final ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static final ThreadLocal<String> systemPort = new ThreadLocal<>();
    private static final ThreadLocal<String> chromeDriverPort = new ThreadLocal<>();
    private static final ThreadLocal<String> wdaLocalPort = new ThreadLocal<>();
    private static final ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<>();
    private static final ThreadLocal<String> appiumIP = new ThreadLocal<>();
    private static final ThreadLocal<Integer> appiumPort = new ThreadLocal<Integer>();

    public void setPlatformName(String spn) {
        platformName.set(spn);
    }

    public String getPlatformName() {
        return platformName.get();
    }

    public void setAppiumIP(String saip) {
        appiumIP.set(saip);
    }

    public void setAppiumPort(String sap) {
        appiumPort.set(Integer.valueOf(sap));
    }

    public String getAppiumIP() {
        return appiumIP.get();
    }

    public Integer getAppiumPort() {
        return appiumPort.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String sUdid) {
        udid.set(sUdid);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String sdn) {
        deviceName.set(sdn);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void initializeGlobalParams() {
        Properties properties = new PropertyManager().getProps();

        setPlatformName(System.getProperty("platformName", properties.getProperty("platformName")));
        setUDID(System.getProperty("udid", properties.getProperty("udid")));
        setDeviceName(System.getProperty("deviceName", properties.getProperty("deviceName")));
        setAppiumIP(System.getProperty("appiumIP", properties.getProperty("appiumIP")));
        setAppiumPort(System.getProperty("appiumPort", properties.getProperty("appiumPort")));

        ThreadContext.put("ROUTINGKEY", properties.getProperty("platformName") + "-" + properties.getProperty("deviceName"));
    }
}
