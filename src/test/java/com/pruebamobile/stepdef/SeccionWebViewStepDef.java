package com.pruebamobile.stepdef;

import com.pruebamobile.view.SeccionWebView;

import io.cucumber.java.en.*;

public class SeccionWebViewStepDef {
	SeccionWebView seccion=new SeccionWebView();

	@Given("ingreso a la aplicacion nativa demo e ingreso al modulo webViews")
	public void ingreso_a_la_aplicacion_nativa_demo_e_ingreso_al_modulo_web_views() {
		seccion.ingresarmMenuWebView();
	}

	@When("ingreso la busqueda {string}")
	public void ingreso_la_busqueda(String palabra) {
		seccion.busqueda(palabra);

	}

	@Then("validar la busqueda")
	public void validar_la_busqueda() {
		seccion.validarBusqueda();
	}



	@When("ingreso navego en el tab Docs")
	public void ingreso_navego_en_el_tab_docs() {
		seccion.tabNavegacion();
		seccion.tabDocs();
	}
	@Then("validar la vista de docs")
	public void validar_la_vista_de_docs() {
		
	}
	@When("ingreso navego en el tab API")
	public void ingreso_navego_en_el_tab_api() {
		seccion.tabNavegacion();
		seccion.tabDocs();
	}
	@Then("validar la vista de API")
	public void validar_la_vista_de_api() {
		seccion.validarDocs();
	}
	
	@When("ingreso navego en el tab Help")
	public void ingreso_navego_en_el_tab_help() {
		seccion.tabNavegacion();
		seccion.tabHelp();
	}
	
	@Then("validar la vista de Help")
	public void validar_la_vista_de_help() {
		seccion.validarHelp();
	}
	
	@When("ingreso navego en el tab Versions")
	public void ingreso_navego_en_el_tab_versions() {
		seccion.tabNavegacion();
		seccion.tabVersion();
	}
	
	@Then("validar la vista de Versions")
	public void validar_la_vista_de_versions() {
		seccion.validarVersion();
	}
	
	@When("ingreso navego en el tab Blog")
	public void ingreso_navego_en_el_tab_blog() {
		seccion.tabNavegacion();
		seccion.tabBlog();

	}
	
	@Then("validar la vista de Blog")
	public void validar_la_vista_de_blog() {
		seccion.validarBlog();
	}
	
	@When("ingreso navego en el tab Contribute")
	public void ingreso_navego_en_el_tab_contribute() {
		seccion.tabNavegacion();
		seccion.tabContribute();
	}
	
	@Then("validar la vista de Contribute")
	public void validar_la_vista_de_contribute() {
		seccion.validarContribute();
	}



}
