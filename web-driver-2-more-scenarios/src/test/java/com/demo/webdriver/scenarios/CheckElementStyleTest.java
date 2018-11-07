package com.demo.webdriver.scenarios;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.webdriver.basics.AbstractChromeWebDriverTest;

public class CheckElementStyleTest extends AbstractChromeWebDriverTest {
	
	@Test
	public void getCssStyelsForErrorElement() {
		
		driver.get("http://localhost:8080/pages/forms.html");
		WebElement errorField = driver.findElement(By.id("inputError"));
		
		System.out.println(errorField.getCssValue("color"));//rgba(85, 85, 85, 1)
		System.out.println(errorField.getCssValue("display"));//block
		System.out.println(errorField.getCssValue("border-color"));//rgb(169, 68, 66)
		System.out.println(errorField.getCssValue("height"));//34px
		System.out.println(errorField.getCssValue("font-size"));//14px
		System.out.println(errorField.getCssValue("background-color"));//rgba(255, 255, 255, 1)
		System.out.println(errorField.getCssValue("border"));//1px solid rgb(169, 68, 66)
		
	}
	
	@Test
	public void getCssStyelsForSuccessElement() {
		driver.get("http://localhost:8080/pages/forms.html");
		WebElement errorField = driver.findElement(By.id("inputError"));
		System.out.println(errorField.getCssValue("color"));//rgba(85, 85, 85, 1)
		System.out.println(errorField.getCssValue("display"));//block
		System.out.println(errorField.getCssValue("border-color"));//rgb(169, 68, 66)
		System.out.println(errorField.getCssValue("height"));//34px
		System.out.println(errorField.getCssValue("font-size"));//14px
		System.out.println(errorField.getCssValue("background-color"));//rgba(255, 255, 255, 1)
		System.out.println(errorField.getCssValue("border"));//1px solid rgb(169, 68, 66)
	}
	
	@Test
	public void checkIfAnElementIsEnabled() {
		driver.get("http://localhost:8080/pages/forms.html");
		
		WebElement errorField = driver.findElement(By.id("disabledInput"));
		assertFalse(errorField.isEnabled());
		System.out.println(errorField.isEnabled());//false
	}
	
	@Test
	public void exploreWebElementInterface() {
		driver.get("http://localhost:8080/pages/forms.html");
		
		WebElement errorField = driver.findElement(By.id("disabledInput"));
		
		System.out.println(errorField.getAttribute("placeholder"));
		System.out.println(errorField.getLocation());
		System.out.println(errorField.getSize());
		
		WebElement textElement = driver.findElement(By.id("textElement"));
		System.out.println(textElement.getLocation());
		System.out.println(textElement.getSize());
		
		WebElement textAreaElement = driver.findElement(By.id("textAreaElement"));
		System.out.println(textAreaElement.getLocation());
		System.out.println(textAreaElement.getSize());
		
		WebElement inputWarning = driver.findElement(By.id("inputWarning"));
		System.out.println(inputWarning.getLocation());
		System.out.println(inputWarning.getSize());
		
		//getAttribute
		//findElements, findElement
		//getLocation, getSize
	}
}
