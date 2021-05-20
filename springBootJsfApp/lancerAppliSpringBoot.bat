cd /d "%~dp0"

REM ./target/springBootJsf.jar doit être construit via mvn install
REM le jar construit via le spring-boot-maven-plugin du pom.xml
REM comporte dans META-INF/Manifest.mf le nom de la classe principale contenant le main()

java -jar ./target/springBootJsfApp.jar
pause
