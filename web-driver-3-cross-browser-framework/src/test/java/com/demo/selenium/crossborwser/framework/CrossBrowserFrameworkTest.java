package com.demo.selenium.crossborwser.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserFrameworkTest {
	
	WebDriver driver = null;
	
	@Parameters("browser")
	@BeforeClass
	public void before(@Optional("chrome") String browser) {
		if("chrome".equals(browser)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if("firefox".equals(browser)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Does not support browser " + browser);
		}
	}
	
	@Test
	public void launchTablesPages() {
		// Lanuch a web page
		driver.get("http://localhost:8080/pages/tables.html");
	}
	
	@Test
	public void launchIndexPages() {
		// Lanuch a web page
		driver.get("http://localhost:8080/pages/index.html");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
