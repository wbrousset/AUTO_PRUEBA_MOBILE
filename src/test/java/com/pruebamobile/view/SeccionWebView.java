package com.pruebamobile.view;

import com.igs.utils.MobileDriverDOM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SeccionWebView extends MobileDriverDOM {
	
	// ==================================== Elementos ====================================
    
    @AndroidFindBy(xpath  = "//android.widget.Button[@content-desc=\"Webview\"]")
    private MobileElement btnMenuWebView;
    
    @AndroidFindBy(xpath  = "//android.widget.Button[@text='Search']")
    private MobileElement btnBusqueda;

    @AndroidFindBy(xpath  = "//android.widget.EditText[@resource-id='docsearch-input']")
    private MobileElement txtBusqueda;

    @AndroidFindBy(xpath  = "//android.widget.Button[@text='Navigation bar toggle']")
    private MobileElement btnTab;
  
    @AndroidFindBy(xpath  = "//android.view.View[@text='Docs']")
    private MobileElement btnDocs;
    
    @AndroidFindBy(xpath  = "//android.view.View[@text='API']")
    private MobileElement btnApi;

    @AndroidFindBy(xpath  = "//android.view.View[@text='Blog']")
    private MobileElement btnBlog;

    @AndroidFindBy(xpath  = "//android.view.View[@text='Contribute']")
    private MobileElement btnContribute;

    @AndroidFindBy(xpath  = "//android.view.View[@text='Community']")
    private MobileElement btnCommunity;

    @AndroidFindBy(xpath  = "//android.view.View[@text='v8']")
    private MobileElement btnVersion;
 
  
    // ==================================== Métodos ====================================
    
    public void ingresarmMenuWebView() {
    	btnMenuWebView.click();
    }
    
    public void busqueda(String palabra) {
    	sleep(4);
    	btnBusqueda.click();
    	sleep(2);
    	sendKeys(txtBusqueda, palabra, "Digitando la busqueda: "+ palabra);
    }
    
    public boolean validarBusqueda() {
    	return true;
    }
    
    public void tabNavegacion() {
    	btnTab.click();
    }
    
    public void tabDocs() {
    	btnDocs.click();
    }
    
    public boolean validarDocs() {
    	return true;
    }
    
    public void tabHelp() {
    	btnCommunity.click();
    }
    public boolean validarHelp() {
    	return true;
    }
    
    public void tabVersion() {
    	btnVersion.click();
    }
    
    public boolean validarVersion() {
    	return true;
    }
    
    public void tabBlog() {
    	btnBlog.click();
    }
    
    public boolean validarBlog() {
    	return true;
    }
    
    public void tabContribute() {
    	btnContribute.click();
    }
    
    public boolean validarContribute() {
    	return true;
    }
}
