SUT (Sistema bajo pruebas): Portal Web Banco Ganadero
Funcionalidad: Listado de datos de contacto GanaMóvil Empresa
Escenario: Listar datos de contacto GanaMóvil Empresa

Datos:
Sitio WEB:  https://www.bg.com.bo/

El escenario Gherkin (BDD) a automatizar se describe en primera persona.
Pasos:
Paso 1 (Given) Dado que Ingresé al portal web www.bg.com.bo
Paso 2 (When) Cuando Ingreso al menú (Negocios|Menu hamburguesa|GanaMóvil Empresas)
Paso 3 (And) Y busco los datos de contacto.
Paso 4 (Then) Entonces obtengo un listado con el
Teléfono: 800-10-3999
WhatsApp: (+591)-721-03001
Email: bancoganadero@bg.com.bo
Horarios: 07:00 a 22:00 Hrs. (Lunes a Domingo))


# Requirements
* Java 17
* Maven 3
* Allure 2


## Java Installation
Check your system to see if you have Java version 17.0.2 installed.
Command:
```bash
$ java --version
```
Ensure your JAVA_HOME environment to the location of the installed JDK.
## Maven Installation
1. Download Maven
2. Unzip the distribution archive to the directory you wish to install Maven.
3. Add Maven to the PATH
4. Verify Maven was correctly installed
```bash
$ mvn --version
```
## Allure Installation
1. Download Allure
2. Unzip the distribution archive to the directory you wish to install Allure.
3. Add Allure to the PATH
4. Verify Allure was correctly installed
```bash
$ allure --version
```

## How to build project
```bash
$ mvn build
```
## How to run tests
```bash
$ mvn clean test
```
## How to see test report
```bash
$ allure serve
```
# Built with
- Selenium : Browser automation framework
- Maven : Build automation & dependency management
- TestNG : Testing framework, control flow of tests
- Allure : Report tool
