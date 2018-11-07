package com.demo.webdriver.scenarios;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.demo.webdriver.basics.AbstractChromeWebDriverTest;

public class PlayingWithModalWindowAndWaitsTest extends AbstractChromeWebDriverTest {
	@Test
	public void playingWithModalWindows() {
		driver.get("http://localhost:8080/pages/notifications.html");
		//Button id - modalButton
		//Modal Wdw id - myModal, myModalLabel, myModalBody, myModalCloseButton
		sleep(3);
		driver.findElement(By.id("modalButton")).click();
		sleep(3);
		driver.findElement(By.id("myModalCloseButton")).click();
		
	}
	
	/*@Test(expectedExceptions=ElementNotVisibleException.class)
	public void playingWithModalWindows_expectingAException() {
		driver.get("http://localhost:8080/pages/notifications.html");
		//Button id - modalButton
		//Modal Wdw id - myModal, myModalLabel, myModalBody, myModalCloseButton
		sleep(3);
		driver.findElement(By.id("modalButton")).click();
		sleep(3);
		driver.findElement(By.id("myModalCloseButton")).click();
	}*/
	
	@Test
	public void playingWithModalWindows_FixingWithSleep() {
		driver.get("http://localhost:8080/pages/notifications.html");
		//Button id - modalButton
		//Modal Wdw id - myModal, myModalLabel, myModalBody, myModalCloseButton
		
		driver.findElement(By.id("modalButton")).click();
		
		sleep(1);
		
		System.out.println(driver.findElement(By.id("myModalLabel")).getText());
		
		driver.findElement(By.id("myModalCloseButton")).click();
		
		//sleep(10);
	}
	
	@Test
	@Ignore("implicit wait fails on Chrome")
	public void playingWithModalWindows_implicitWait() {
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8080/pages/notifications.html");
		//Button id - modalButton
		//Modal Wdw id - myModal, myModalLabel, myModalBody, myModalCloseButton
		
		driver.findElement(By.id("modalButton")).click();
		
		//sleep(1);
		
		System.out.println(driver.findElement(By.id("myModalLabel")).getText());
		
		driver.findElement(By.id("myModalCloseButton")).click();
		
		//sleep(10);
	}
	
	@Test
	public void playingWithModalWindows_ExplicitWait() {
		driver.get("http://localhost:8080/pages/notifications.html");
		//Button id - modalButton
		//Modal Wdw id - myModal, myModalLabel, myModalBody, myModalCloseButton
		
		driver.findElement(By.id("modalButton")).click();
		
		//sleep(10);
		//Max - 10
		//Wait for myModalLabel to load
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.withMessage("Waited for 10 seconds but still element not available");
		
		
		WebElement modalLabel =
				webDriverWait.until(
						ExpectedConditions.visibilityOf(
								driver.findElement(By.id("myModalLabel")))
						);//By.id("myModalLabel")
				driver.findElement(By.id("myModalLabel"));
		
		
		System.out.println(modalLabel.getText());
		
		driver.findElement(By.id("myModalCloseButton")).click();
		
		//sleep(10);
	}
	
}