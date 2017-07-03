<h2>Swagger UI</h2>
http://localhost:8080/swagger-ui.html

<h2>Running via Maven</h2>
mvn spring-boot:run

<h2>Swagger Spring Profile</h2>
Remove Spring Profile to disable Swagger
spring.profiles.active=swagger

<h2>Turn on Debugging</h2>
<ol>
<li>Through Program Argument by adding "--debug"</li>
<li>Through SpringBoot application.properties
<br>
logging.level.org.springframework.web=DEBUG
<br>
logging.level.org.hibernate=ERROR
</li>
</ol>