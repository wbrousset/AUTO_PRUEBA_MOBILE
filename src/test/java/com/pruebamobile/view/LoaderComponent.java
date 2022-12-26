package com.pruebamobile.view;

import com.igs.utils.MobileDriverDOM;
import com.igs.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoaderComponent extends MobileDriverDOM {
    TestUtils utils = new TestUtils();

//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'linearLayout')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Cargando..')]")
    private MobileElement loaderImage;

    public void esperaLoaderOculto() {
        try {
            while (find(loaderImage, 3)) {
                utils.log().info("Esperando que se oculte el loader.");
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            utils.log().info("Loader ya no es visible. " + e.getMessage());
        }
    }
}
