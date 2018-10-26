package com.demo.selenium.crossborwser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserBasicsTest {

	@Test
	public void chromeBrowser() {
		// Chrome

		// Chrome Web Driver EXE
		WebDriverManager.chromedriver().setup();

		// WebDriver Interface - Create an instance of the web driver of the browser
		WebDriver driver = new ChromeDriver();

		// Lanuch a web page

		driver.get("http://localhost:8080/pages/tables.html");

		sleep(5);

		driver.quit();
	}

	@Test
	public void firefoxBrowser() {
		// Firfox

		// Firfox Web Driver EXE
		WebDriverManager.firefoxdriver().setup();
		
		// WebDriver Interface - Create an instance of the web driver of the browser
		WebDriver driver = new FirefoxDriver();

		// Lanuch a web page

		driver.get("http://localhost:8080/pages/tables.html");

		sleep(5);

		driver.quit();
	}
	
	@Test
	public void safariBrowser() {
		// Safari

		// Safari Web Driver EXE
		//WebDriverManager.safaridriver().setup();
		
		// WebDriver Interface - Create an instance of the web driver of the browser
		WebDriver driver = new SafariDriver();

		// Lanuch a web page

		driver.get("http://localhost:8080/pages/tables.html");

		sleep(5);

		driver.quit();
	}
	
	@Test
	public void ieBrowser() {

		WebDriverManager.iedriver().setup();

		// WebDriver Interface - Create an instance of the web driver of the browser
		WebDriver driver = new InternetExplorerDriver();

		// Lanuch a web page

		driver.get("http://localhost:8080/pages/tables.html");

		sleep(5);

		driver.quit();
	}
	
	@Test
	public void EdgeBrowser() {

		WebDriverManager.edgedriver().setup();

		// WebDriver Interface - Create an instance of the web driver of the browser
		WebDriver driver = new EdgeDriver();

		// Lanuch a web page

		driver.get("http://localhost:8080/pages/tables.html");

		sleep(5);

		driver.quit();
	}

	private void sleep(int i) {

		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
