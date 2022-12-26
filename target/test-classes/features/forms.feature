@regresion
Feature: Ingresar todos los datos del formulario
  
  @forms
   Scenario Outline: Validar que pueda ingresar todos los datos del formulario
    Given ingreso a la aplicacion nativa demo e ingreso al modulo forms
    When ingreso input "<input>"
    And ingresar switch
    And seleccionar dropdown
    And click en Activar
    Then validar la activacion del formulario

    Examples:
      | input       | 
      | admin@gmail.com |  
  