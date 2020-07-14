# Spring Book - Example 

## Initializing

1. Initializing spring project on **start.spring.io**  
1. Initializing Git Repository and Push to remote  
    1. Initialize local:    
  		https://www.youtube.com/watch?v=hks47h4C_nY    
  		https://www.youtube.com/watch?v=bvl4Kbe-qok
     2. Initialize remote: push and commit

  	
## Project structure
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-structuring-your-code
- https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects
- 	

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


**Remarks**
- Model - View
- **Model** - **View-Bibliothek**
- **Request Mapping** / **GetMapping**
- Beans