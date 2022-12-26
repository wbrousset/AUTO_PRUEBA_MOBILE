@regresion
Feature: Realizando el flujo de webiView 
  
  @busqueda
   Scenario Outline: Validar la busqueda de una palabra
    Given ingreso a la aplicacion nativa demo e ingreso al modulo webViews
    When ingreso la busqueda "<busqueda>"
    Then validar la busqueda

    Examples:
      | busqueda       | 
      | browser |  
      
  @navegar
   Scenario Outline: Validar que pueda ingresar todos los datos del formulario
   Given ingreso a la aplicacion nativa demo e ingreso al modulo webViews
    When ingreso navego en el tab Docs
    Then validar la vista de docs
    When ingreso navego en el tab API
    Then validar la vista de API
    When ingreso navego en el tab Help
    Then validar la vista de Help
    When ingreso navego en el tab Versions
    Then validar la vista de Versions
    When ingreso navego en el tab Blog
    Then validar la vista de Blog
    When ingreso navego en el tab Contribute
    Then validar la vista de Contribute


    Examples:
      | input       | 
      | admin@gmail.com |  