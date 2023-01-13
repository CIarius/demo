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
	  
		System.out.println("before all, initializing driver...");
		
		driver = new EdgeDriver();
		  
	    driver.get("http://localhost:8080/customers");
	    
	    driver.manage().window().setSize(new Dimension(512, 229));
	    
  }
  
  @Test
  public void noUsernameNoPassword() {

		System.out.println("testing: no username, no password...");
		
	    driver.findElement(By.cssSelector("body > div > form > div:nth-child(4) > div > button")).click();
	    
	    assertEquals(new String("http://localhost:8080/login?error"), driver.getCurrentUrl());
	    
  }
  
  @Test
  public void wrongPassword() {
	  
	System.out.println("testing: right username, wrong password...");
	
    driver.findElement(By.name("username")).sendKeys("user");
    
    driver.findElement(By.name("password")).sendKeys("someword");
    
    driver.findElement(By.cssSelector("body > div > form > div:nth-child(4) > div > button")).click();
    
    assertEquals(new String("http://localhost:8080/login?error"), driver.getCurrentUrl());
    
    assertNotNull(driver.findElement(By.cssSelector("div[class*='alert-danger']")));
    
  }
  
  @Test
  public void rightPassword() {

    System.out.println("testing: right username, right password...");
    
    driver.findElement(By.name("username")).sendKeys("user");
    
    driver.findElement(By.name("password")).sendKeys("password");
    
    driver.findElement(By.cssSelector("body > div > form > div:nth-child(4) > div > button")).click();
    
    assertNotNull(driver.findElement(By.linkText("Credit Limit")).getText());
    
  }
  
  @AfterAll
  public static void afterAll() {
	  // this runs once, after all tests
	  System.out.println("after all, quitting driver...");
	  driver.quit();	  
  }
  
}
