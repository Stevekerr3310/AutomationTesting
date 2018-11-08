package com.demo.pageobjects.updatedoto;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateTodoBasicTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void loginPageObject() {
		
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		
		driver.get("http://localhost:8080/login");

		//driver.findElement(By.id("name")).getAttribute("type")
		System.out.println(page.name.getAttribute("type"));
		
		//driver.findElement(By.id("password")).getAttribute("type")
		System.out.println(page.password.getAttribute("type"));
	}
	
	@Test
	public void updateTodo() {
		
		LoginPage page = PageFactory.initElements(driver, LoginPage.class);
		
		driver.get("http://localhost:8080/login");
		
		/* Test 1.
		//id name in28minutes
		//driver.findElement(By.id("name")).sendKeys("in28minutes");
	
		//id password dummy
		//driver.findElement(By.id("password")).sendKeys("dummy");
		
		//id submit click
		//driver.findElement(By.id("submit")).submit();*/
		
		/* Test 2.
		page.name.sendKeys("in28minutes");
		page.password.sendKeys("dummy");
		page.submitButton.submit();*/
		
		/* Test 3.
		page.enterName("in28minutes");
		page.enterPassword("dummy");
		page.submit();*/
		
		// Test 4.
		page.login("in28minutes", "dummy");
		
		//Click here - Link Text
		driver.findElement(By.linkText("Click here")).click();
		
		ListTodoPage listTodoPage = new ListTodoPage(driver);
		listTodoPage.clickUpdateFor("10002");
		
		//id update-10002 click
		//driver.findElement(By.id("update-10002")).click();
		
		//id desc
		//WebElement desc = driver.findElement(By.id("desc"));
		//desc.clear();
		//desc.sendKeys("Become a Tech Guru - 2");
		
		//id targetDate
		//WebElement targetDate = driver.findElement(By.id("targetDate"));
		//targetDate.clear();
		//targetDate.sendKeys("12/09/2019");
		
		//save submit
		//driver.findElement(By.id("save")).submit();
		
		TodoPage todoPage = PageFactory.initElements(driver, TodoPage.class);
		todoPage.enterDescription("Become a Tech Guru - 2");
		todoPage.enterTargetData("12/09/2019");
		
		todoPage.submit();
		
		//check desc-10002
		//String updateDesc = driver.findElement(By.id("desc-10002")).getText();
		//String updateDesc = listTodoPage.getDescription("10002");
		
		//check targetDate-10002
		//String updateTargetDate = driver.findElement(By.id("targetdate-10002")).getText();
		//String updateTargetDate = listTodoPage.getTargetDate("10002");
		
		//Become a Tech Guru - 2
		//12/09/2019
		
		assertEquals(listTodoPage.getDescription("10002"), "Become a Tech Guru - 2");
		assertEquals(listTodoPage.getTargetDate("10002"), "12/09/2019");
		//System.out.println(updateDesc);
		//System.out.println(updateTargetDate);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
