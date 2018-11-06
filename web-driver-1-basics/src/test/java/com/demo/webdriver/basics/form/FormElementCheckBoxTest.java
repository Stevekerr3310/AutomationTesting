package com.demo.webdriver.basics.form;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demo.webdriver.basics.AbstractChromeWebDriverTest;

public class FormElementCheckBoxTest extends AbstractChromeWebDriverTest {
	
	@Test
	public void readFromCheckBox() {
		driver.get("http://localhost:8080/pages/forms.html");
		WebElement checkboxElement1 = driver.findElement(By.id("checkboxElement1"));
		System.out.println(checkboxElement1.isSelected());//false
		assertFalse(checkboxElement1.isSelected());
		
		WebElement checkboxElement2 = driver.findElement(By.id("checkboxElement2"));
		System.out.println(checkboxElement2.isSelected());//true
		assertTrue(checkboxElement2.isSelected());
	}
	
	@Test
	public void setValueIntoCheckBoxElement1() {
		driver.get("http://localhost:8080/pages/forms.html");
		WebElement checkboxElement1 = driver.findElement(By.id("checkboxElement1"));
		sleep(4);
		checkboxElement1.click();
		sleep(4);
		WebElement checkboxElement3 = driver.findElement(By.id("checkboxElement3"));
		sleep(4);
		checkboxElement3.click();
		sleep(4);
	}
	
	@Test
	public void checkCheckBox() {
		driver.get("http://localhost:8080/pages/forms.html");
		
		checkACheckBox("checkboxElement1");
		sleep(2);
		checkACheckBox("checkboxElement2");
		sleep(2);
		checkACheckBox("checkboxElement3");
		sleep(4);
	}
	
	@Test
	public void unCheckCheckBox() {
		driver.get("http://localhost:8080/pages/forms.html");
		
		checkACheckBox("checkboxElement1");
		sleep(2);
		checkACheckBox("checkboxElement2");
		sleep(2);
		checkACheckBox("checkboxElement3");
		sleep(4);
	}

	private void checkACheckBox(String checkboxName) {
		WebElement checkboxElement1 = driver.findElement(By.id(checkboxName));
		boolean currentValue = checkboxElement1.isSelected();
		
		if(currentValue == false) {
			checkboxElement1.click();
		}
	}
	
	private void unCheckACheckBox(String checkboxName) {
		WebElement checkboxElement1 = driver.findElement(By.id(checkboxName));
		boolean currentValue = checkboxElement1.isSelected();
		
		if(currentValue == true) {
			checkboxElement1.click();
		}
	}
}
