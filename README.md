# Spring Book - Example 

## Initializing

1. Initializing spring project on **start.spring.io**  
1. Initializing Git Repository and Push to remote  
    1. Initialize local:    
  		https://www.youtube.com/watch?v=hks47h4C_nY    
  		https://www.youtube.com/watch?v=bvl4Kbe-qok
     2. Initialize remote: push and commit

1. Spring Tools 4    
	- https://spring.io/tools/    
  	- https://stackoverflow.com/questions/31662983/how-can-i-install-the-spring-tool-suite-in-ubuntu
  	
## Project structure
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-structuring-your-code
- https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects

## TODO
- Add missing unit testst

## Remarks

- **enum**    
   (javabook p. 429 / 712 / 617)
    
- **equals()**  

- **hashCode()**

- **toString()**    
    (javabook p.483)

- **List<>**    
     (javabook p.980)
- **Array.asList(...)**       
    (javabook p.990)

- **for (x : y)**    
    (javabook p.279)
    
- **Streams, .filter**    
    (javabook p.1009)    
    https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

## Chapter 1
### Controller

"GetMapping cannot be resolved to a type":		

- https://stackoverflow.com/questions/56712560/cannot-resolve-getmapping-in-spring-tool-suite

Bug in test for HomeController ...`import org.junit.Test` could not be resolved:    

- https://stackoverflow.com/questions/61498856/tests-annotated-with-org-junit-test-are-not-recognized

## Chapter 2
Lombock installation Problems:
1. Download lombok.jar
1. sudo java -jar lombok.jar
1. manually set eclipse path: /snap/eclipse/48/
Still not working!

### General
- Model - View

- **Model** - **View-Bibliothek**

- **Request Mapping** / **GetMapping**

- Beans

### Thymleaf

https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html    
https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html

- **th:object**   ...line 15 design.html    
    probably object, where form is stored

- **th:each**    
https://www.baeldung.com/thymeleaf-iteration   
 
- **th:field="*{...}"**    
connects form input to taco dto name-property

### Logging
(Java book p.930)
- JUL: java.util.logging

### Validations

- @NotNull
- @Size(min=..., message="...")
- @NotBlank
- @Pattern
- @Digits
- @CreditCardNumber (**Hibernate**)

**Problem**: Needed to add to **pom.xml**:

**Solution**: `https://www.baeldung.com/javax-validation`

```
<dependency>
<groupId>javax.validation</groupId>
<artifactId>validation-api</artifactId>
</dependency>
```

**Problem**: Error Message now shown, instead: `Whitelabel Error Page`

**Solution**: `http://forum.thymeleaf.org/Fields-object-functions-Spring-td3302513.html`

**Problem**: Validation evaluation not working with taco design page!!! MAASSIV Error if not enough ingredients choosen?!? WTF Fucked-up-beyond-believe bullshit useles error message!

**Solution**: NONE

**Testing**: https://developers.bluesnap.com/docs/test-credit-cards

### View-Controller
(p. 55)

????

## Chapter 3
### Add dependency
	    <dependency>
	    	<groupId>org.springframework.boot</groupId>
	    	<artifactId>spring-boot-starter-jdbc</artifactId>
	    </dependency>
	    
### Remarks
- Domain Driven Design
- Repositories
- 	    
### Links
- https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/#jdbc.repositories
- https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/#repositories
- http://zetcode.com/db/jdbctemplate/
- https://www.baeldung.com/spring-jdbc-jdbctemplate
- https://www.baeldung.com/spring-jdbctemplate-testing




