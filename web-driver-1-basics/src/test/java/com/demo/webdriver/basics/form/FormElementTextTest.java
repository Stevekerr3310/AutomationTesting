package com.demo.webdriver.basics.form;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.webdriver.basics.AbstractChromeWebDriverTest;

public class FormElementTextTest extends AbstractChromeWebDriverTest {
	@Test
	public void readFromTextElement() {
		driver.get("http://localhost:8080/pages/forms.html");
		assertEquals(driver.findElement(By.id("textElement")).getAttribute("value"), "in28minutes");
		
	}
	
	@Test
	public void setASpecificValueIntoTextElement() {
		driver.get("http://localhost:8080/pages/forms.html");
		WebElement textElement = driver.findElement(By.id("textElement"));
		sleep(4);
		textElement.clear();
		textElement.sendKeys("NewValue");
		sleep(4);
	}
	
	@Test
	public void writeAndReadValueIntoTextArea() {
		driver.get("http://localhost:8080/pages/forms.html");
		
		WebElement textArea = driver.findElement(By.id("textAreaElement"));
		
		assertEquals(textArea.getAttribute("value"), "");
		sleep(4);
		textArea.clear();
		textArea.sendKeys("FirstLine");
		textArea.sendKeys("\n");
		textArea.sendKeys("SecondLIne");
		sleep(4);
		assertEquals(textArea.getAttribute("value"), "FirstLine\nSecondLIne");
	}
}
