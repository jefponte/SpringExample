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

Step 2 - Create the a controller and mapping the routes. And create a html file on templates folder

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
Step 3 - Add dependecy tymeleaf and devtools
```xml
        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-devtools</artifactId>
                <scope>runtime</scope>
        </dependency>
```

Step 4 - Add starter data jpa and connector mysql dependencies to connect with a data
```xml
        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
                </dependency>
        <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <scope>runtime</scope>
        </dependency>

```

Step 5 - Config your database on application.properties file

spring.datasource.url=jdbc:mysql://localhost:3306/springexample?useTimezone=true&serverTimezone=America/Fortaleza
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Step 6 - Add a simple model 

```java
package com.jefponte.springexample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Cliente() {
    }

    @Column(nullable = false, name = "birth_date")
    private Date birthDate;

    public Cliente(Long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (birthDate == null) {
            if (other.birthDate != null)
                return false;
        } else if (!birthDate.equals(other.birthDate))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [birthDate=" + birthDate + ", id=" + id + ", name=" + name + "]";
    }

}
```