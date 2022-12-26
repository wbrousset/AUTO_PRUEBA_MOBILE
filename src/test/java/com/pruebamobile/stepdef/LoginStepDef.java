package com.pruebamobile.stepdef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.pruebamobile.view.LoginView;

public class LoginStepDef {
	LoginView loginView = new LoginView();

	@Given("ingreso a la aplicacion nativa demo con el usuario {string} y la contrasenia {string}")
	public void ingreso_a_la_aplicacion_nativa_demo_con_el_usuario_y_la_contrasenia(String usuario, String contrasenia) {
		loginView.ingresarmMenuLogin();
		loginView.ingresar(usuario,contrasenia);
	}

	@When("click en el boton login")
	public void click_en_el_boton_login() {
		loginView.btnLogin();
	}

	@Then("validar el mensaje de confirmación de usuario valido")
	public void validar_el_mensaje_de_confirmación_de_usuario_valido() {
		assertTrue(loginView.validarUsuario());
	}


	@Given("ingreso a la aplicacion nativa demo,modulo login")
	public void ingreso_a_la_aplicacion_nativa_demo_modulo_login() {
		loginView.ingresarmMenuLogin();		
	}

	@Given("ingreso al tab SigUp")
	public void ingreso_al_tab_sig_up() {
		loginView.ingresarSignUp();
	}

	@When("ingreso el correo {string},contraseña {string} y la confirmacion {string}")
	public void ingreso_el_correo_contraseña_y_la_confirmacion(String correo, String contrasenia, String contraseniaconfi) {
		loginView.ingresoDatos( correo,  contrasenia,  contraseniaconfi);
	}

	@Then("validar el mensaje de confirmación de usuario creado")
	public void validar_el_mensaje_de_confirmación_de_usuario_creado() {
		loginView.validarUsuarioCreado();
	}





}