package com.pruebamobile.stepdef;

import static org.junit.Assert.assertTrue;

import com.pruebamobile.view.FormsView;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormsStepDef {
	
	FormsView fomrView = new FormsView();

	@Given("ingreso a la aplicacion nativa demo e ingreso al modulo forms")
	public void ingreso_a_la_aplicacion_nativa_demo_e_ingreso_al_modulo_forms() {
		fomrView.ingresarmMenuForms();		
	}
	
	@When("ingreso input {string}")
	public void ingreso_input(String input) {
		fomrView.ingresoInput(input);
	}
	
	@When("ingresar switch")
	public void ingresar_switch() {
		fomrView.seleccionarSwitch();
	}
	
	@When("seleccionar dropdown")
	public void seleccionar_dropdown() {
		fomrView.seleccionarDropDown();
	}
	
	@When("click en Activar")
	public void click_en_activar() {
		fomrView.activar();
	}
	
	@Then("validar la activacion del formulario")
	public void validar_la_activacion_del_formulario() {
		assertTrue(fomrView.validarActivacion());
	}
}
