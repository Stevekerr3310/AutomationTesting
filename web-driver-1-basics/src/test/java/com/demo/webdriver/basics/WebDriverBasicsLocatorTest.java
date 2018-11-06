package com.demo.webdriver.basics;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasicsLocatorTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		//Download the web driver executable
		WebDriverManager.chromedriver().setup();
		//Create a instance of your web driver - chrome
		driver = new ChromeDriver(); 
	}
	
	@Test
	public void testTitle() {
		
		//get the http://localhost:8080/login
		//driver.get("http://localhost:8080/login");
		driver.get("http://www.google.com");
		//get the title
		assertEquals(driver.getTitle(), "Google");
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
