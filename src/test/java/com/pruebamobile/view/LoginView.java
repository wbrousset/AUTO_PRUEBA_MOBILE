package com.pruebamobile.view;

import com.igs.utils.MobileDriverDOM;
import com.igs.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginView extends MobileDriverDOM {
    TestUtils utils = new TestUtils();

    // ==================================== Elementos ====================================
    
    @AndroidFindBy(xpath  = "//android.widget.EditText[@content-desc='input-email']")
    private MobileElement txtUsuario;
    
    @AndroidFindBy(xpath  = "//android.widget.EditText[@content-desc='input-password']")
    private MobileElement txtContrasenia;

    @AndroidFindBy(xpath  = "//android.widget.TextView[@text='Login']")
    private MobileElement btnMenuLogin;
    
    @AndroidFindBy(xpath  = "//android.view.ViewGroup[@content-desc='button-LOGIN']")
    private MobileElement btnLogin;

    @AndroidFindBy(xpath  = "//android.widget.TextView[@text='Sign up']")
    private MobileElement btnMenuSignUp;

    @AndroidFindBy(xpath  = "//android.widget.EditText[@content-desc='input-email']")
    private MobileElement txtCorreo;

    @AndroidFindBy(xpath  = "//android.widget.EditText[@content-desc='input-password']")
    private MobileElement txtContraseniad;
    
    @AndroidFindBy(xpath  = "//android.widget.EditText[@content-desc='input-repeat-password']")
    private MobileElement txtContraseniaConfi;
    
    @AndroidFindBy(xpath  = "//android.view.ViewGroup[@content-desc='button-SIGN UP']")
    private MobileElement btnSignUp;
  
  

    
    // ==================================== Métodos ====================================
    public void ingresarmMenuLogin() {
    	btnMenuLogin.click();
    }
    
    public void ingresar(String usuario,String contrasenia){    	
    	sendKeys(txtUsuario, usuario, "Digitando el usuario: "+ usuario);
    	sleep(1);
    	sendKeys(txtContrasenia, contrasenia, "Digitando la contraseña: "+ contrasenia);
    }
    
    public void btnLogin(){
    	
    }
    
    public boolean validarUsuario() {
    	btnLogin.click();
    	sleep(2);
    	System.out.println(driver.switchTo().alert().getText());
    	if(driver.switchTo().alert().getText().contains("Success")) {
			driver.switchTo().alert().accept();
			return true;
		}
    	return false;
    }
    
    public void ingresarSignUp() {
    	btnMenuSignUp.click();
    }
    
    public void ingresoDatos(String correo, String contrasenia, String contraseniaconfi) {
    	sendKeys(txtCorreo, correo, "Digitando la correo: "+ correo);
    	sendKeys(txtContraseniad, contrasenia, "Digitando la contrasenia: "+ contrasenia);
    	sendKeys(txtContraseniaConfi, contraseniaconfi, "Digitando la confirmacion de la contrasenia: "+ contraseniaconfi);
    	
    }
    
    public boolean validarUsuarioCreado() {
    	btnSignUp.click();
    	sleep(2);
    	System.out.println(driver.switchTo().alert().getText());
    	if(driver.switchTo().alert().getText().contains("Success")) {
			driver.switchTo().alert().accept();
			return true;
		}
    	return false;
    }
   
}