package com.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumHubTest {
	//selenium-standalone start -- -role hub
	
	//Nodes should register to http://localhost:4444/grid/register/
	
	// Clients should connect to http://localhost:4444/wd/hub
	
	//selenium-standalone start -- -role node -hub http://localhost:4444/grid/register/
	
	//selenium-standalone start -- -role node -port 5556 -hub http://localhost:4444/grid/register/
	
	@Test(threadPoolSize=2, invocationCount=4)
	public void hub_chrome() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//chrome, firefox, htmlunit, internet explorer, iphone, opera
		capabilities.setBrowserName("chrome");
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		WebDriver remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
		//RemoteWebDriver
		//  Location of Standaloneserver
		//  Which Browser? Which OS? => Capabilities
		
		remoteDriver.get("http://localhost:8080/pages/index.html");
		System.out.println(remoteDriver.getCurrentUrl());
		System.out.println(remoteDriver.getTitle());
		Thread.sleep(15000);
		remoteDriver.quit();
	}
	
	@Test(threadPoolSize=2, invocationCount=4)
	public void hub_firefox() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//chrome, firefox, htmlunit, internet explorer, iphone, opera
		capabilities.setBrowserName("firefox");
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		WebDriver remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
		//RemoteWebDriver
		//  Location of Standaloneserver
		//  Which Browser? Which OS? => Capabilities
		
		remoteDriver.get("http://localhost:8080/pages/index.html");
		System.out.println(remoteDriver.getCurrentUrl());
		System.out.println(remoteDriver.getTitle());
		Thread.sleep(15000);
		remoteDriver.quit();
	}
	
}
