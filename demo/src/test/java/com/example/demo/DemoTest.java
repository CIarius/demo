package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoTest {
	
  private static EdgeDriver driver;
  
  @BeforeAll
  public static void beforeAll() {
	  
	  // this runs once, before anything else
	  
		System.out.println("before class, initializing driver...");
		
		driver = new EdgeDriver();
		  
	    driver.get("http://localhost:8080/customers");
	    
	    driver.manage().window().setSize(new Dimension(522, 229));
	    
  }
  
  @Test
  public void wrongPassword() {
	  
	System.out.println("testing with wrong password...");
	
    driver.findElement(By.name("username")).sendKeys("user");
    
    driver.findElement(By.name("password")).sendKeys("user");
    
    driver.findElement(By.cssSelector("div > input")).click();
    
    assertEquals(new String("Invalid username and password."), driver.findElement(By.id("message")).getText());
    
  }
  
  @Test
  public void rightPassword() {

    System.out.println("testing with right password...");
    
    driver.findElement(By.name("username")).sendKeys("user");
    
    driver.findElement(By.name("password")).sendKeys("password");
    
    driver.findElement(By.cssSelector("div > input")).click();
    
    assertEquals(new String("Credit Limit"), driver.findElement(By.linkText("Credit Limit")).getText());
    
  }
  
  @AfterAll
  public static void afterAll() {
	  // this runs once, after all tests
	  System.out.println("after class, quitting driver...");
	  driver.quit();	  
  }
  
}
