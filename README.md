# Prueba Mobile
Se realizó 5 pruebas de para el aplicativo  Android-NativeDemoApp-0.4.0.apk
Para este proyecto se esta utilizando BDD, Java/Cucumber/Appium 

# Configuración de su maquina
* Establecer `JAVA_HOME` como una variable de entorno
* Establecer `ANDROID_HOME` como una variable de entorno - apuntando al directorio donde se debe configurar el SDK de Android
* Instalar Eclipse IDE
* Instalar Appium Server y Appium Inspector
* Instalar Android Studio
* Crear una maquina virtual

# Escenarios 
* Se crearon los siguientes escenarios:
* 1.- login
* 2.- signup
* 3.- forms
* 4.- busqueda
* 5.- navegar

# Ejecutando las pruebas
* Inicie el servidor de appium manualmente (y actualice la url/puerto si no usa el valor predeterminado)
* Tener un emulador (configurar los capabilities en el archivo  "config.properties")
* Ir al package runner y abrir el archivo RunnerLogin.java
* Desde el mismo archivo RunnerLogin.java hacer click derecho/Run As/Junit Test
* Ejecutar el escenario que desee desde "src\test\java\com\pruebamobile\runner\RunnerLogin.java"
* Ejemplo 
* Deconementar "@CucumberOptions(features = { "src/test/resources/features" },tags = "@login" ,glue = { "com.pruebamobile.stepdef" })"

# Reporte
* Cuando se ejecute la prueba se creará un documento word para su reporte en la direccion pruebaMobile\reportes\word
