@regresion
Feature: Inicio de sesión en la app Nativa Demo
  Esta funcionalidad permite validar las credenciales del cliente y la creación de un nuevo usuario
  
  @login
   Scenario Outline: Validar que pueda ingresar con mis credenciales
    Given ingreso a la aplicacion nativa demo con el usuario "<usuario>" y la contrasenia "<contrasenia>"
    When click en el boton login
    Then validar el mensaje de confirmación de usuario valido

    Examples:
      | usuario       | contrasenia   | 
      | admin@gmail.com | admin12345  | 
  

  @signup
    Scenario Outline: Validar que pueda crear un usuario
    Given ingreso a la aplicacion nativa demo,modulo login 
    And ingreso al tab SigUp
    When ingreso el correo "<correo>",contraseña "<contrasenia>" y la confirmacion "<contrasenia>"
    Then validar el mensaje de confirmación de usuario creado

    Examples:
      | correo       | contrasenia   | 
      | admin@gmail.com | admin12345  | 
  