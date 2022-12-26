package com.pruebamobile.view;

import java.util.concurrent.TimeUnit;

import com.igs.utils.MobileDriverDOM;
import com.igs.utils.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormsView extends MobileDriverDOM {
    TestUtils utils = new TestUtils();
	
    // ==================================== Elementos ====================================
    @AndroidFindBy(xpath  = "//android.widget.TextView[@text='Forms']")
    private MobileElement btnMenuForms;
    
    @AndroidFindBy(xpath  = "//android.widget.EditText[@content-desc='text-input']")
    private MobileElement txtInput;

    @AndroidFindBy(xpath  = "//android.widget.Switch[@content-desc='switch']")
    private MobileElement btnSwitch;

    @AndroidFindBy(xpath  = "//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText")
    private MobileElement btnDropDown;

    @AndroidFindBy(xpath  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
    private MobileElement selDropDown;

    @AndroidFindBy(xpath  = "//android.view.ViewGroup[@content-desc='button-Active']")
    private MobileElement btnActivar;
    
	// ==================================== Métodos ====================================
    public void ingresarmMenuForms() {
    	btnMenuForms.click();	
	}
    
    public void ingresoInput(String input) {
    	sendKeys(txtInput, input, "Digitando el usuario: "+ input);
    }
    
    public void seleccionarSwitch() {
    	btnSwitch.click();
    }

    public void seleccionarDropDown() {
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
		
		String uiSelector = "new UiSelector().textMatches(\"Active\")";

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
		                 + uiSelector + ");";
		
		driver.findElement(MobileBy.AndroidUIAutomator(command));
    	btnDropDown.click();
    	selDropDown.click();
    }
    
    public void activar() {
    	
    }
    
    public boolean validarActivacion() {
    	btnActivar.click();
    	sleep(2);
    	
		
		if(driver.switchTo().alert().getText().contains("active")) {
			driver.switchTo().alert().accept();
			return true;
		}
    	System.out.println(driver.switchTo().alert().getText());
    	return false;
    }
    
    
}
