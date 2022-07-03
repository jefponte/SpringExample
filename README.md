# SpringExample
This is a simple spring project.


Step 1 - Create a new Project using a spring boot template

        Initialize your project on this link: https://start.spring.io/
        Project: Maven Project
        Language: Java
        Packaging: Jar
        Java: 11
        Group: com.jefponte
        Artfact: springexample
        Name: springexample
        Description: This is a simple spring project.
        Package name: com.jefponte.springexample

Stepe 2 - Create the a controller and mapping the routes. And create a html file on templates folder

```java
package com.jefponte.springexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}

```
Stepe 3 - Add dependecy tymeleaf 
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
```