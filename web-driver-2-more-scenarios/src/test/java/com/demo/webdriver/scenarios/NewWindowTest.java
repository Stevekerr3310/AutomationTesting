package com.demo.webdriver.scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.demo.webdriver.basics.AbstractChromeWebDriverTest;

public class NewWindowTest extends AbstractChromeWebDriverTest {
	
	@Test
	public void testForWindows() {
		
		driver.get("http://localhost:8080/pages/notifications.html");
		
		//0 - [CDwindow-3D2610AA5E14383C58C0AC447ECD6574]
		System.out.println("0 - " + driver.getWindowHandles());
		
		
		
		driver.findElement(By.id("newPageButton")).click();
		//Window Handle
		//1 - CDwindow-3D2610AA5E14383C58C0AC447ECD6574
		System.out.println("1 - " + driver.getWindowHandle());
		
		//2 - [CDwindow-3D2610AA5E14383C58C0AC447ECD6574, CDwindow-FAF5342A73C989E5AA3720B91ED54C8A]
		System.out.println("2 - " + driver.getWindowHandles());
		
	}
	
	@Test
	public void findWindowHandleOfSecondWindow() {
		
		driver.get("http://localhost:8080/pages/notifications.html");
		
		String firstWindowHandle = driver.getWindowHandle();
		
		System.out.println(firstWindowHandle);
		
		driver.findElement(By.id("newPageButton")).click();
		
		String secondWindowHandle = findSecondWindowHandle(firstWindowHandle);
		
		System.out.println(secondWindowHandle);
	}

	private String findSecondWindowHandle(String firstWindowHandle) {
		
		for (String handle : driver.getWindowHandles()) {
			if(!firstWindowHandle.equals(handle)) {
				return handle;
			}
		}
		return null;
	}
	
	@Test
	public void switchToSecondWindow() {
		
		driver.get("http://localhost:8080/pages/notifications.html");
		
		String firstWindowHandle = driver.getWindowHandle();
		
		System.out.println(firstWindowHandle);
		
		driver.findElement(By.id("newPageButton")).click();
		
		String secondWindowHandle = findSecondWindowHandle(firstWindowHandle);
		
		System.out.println(secondWindowHandle);
		
		System.out.println(driver.findElement(By.tagName("h1")).getText());//Notifications
		
		driver.switchTo().window(secondWindowHandle);
		
		System.out.println(driver.findElement(By.tagName("h1")).getText());//Forms
		
		driver.switchTo().window(firstWindowHandle);
		
		System.out.println(driver.findElement(By.tagName("h1")).getText());//Notifications
		
		System.out.println(driver.getCurrentUrl());
		
		//org.openqa.selenium.NoSuchWindowException: no such window: target window already closed
		driver.close();
		
		driver.switchTo().window(secondWindowHandle);
		
		System.out.println(driver.getCurrentUrl());
	}
}
