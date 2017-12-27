package com.amazon.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestElementLocatorTechniques {
	
	WebDriver driver;
	
	public void invokeBrowser(String url) {
		try {
			System.setProperty("webDriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void locatorTechniques() {
		try {
			invokeBrowser("https://www.amazon.com/");
			driver.findElement(By.linkText("Help")).click();
			driver.navigate().back();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
			driver.findElement(By.className("nav-input")).click();
			driver.navigate().back();
			driver.findElement(By.partialLinkText("Black Friday")).click();
			driver.navigate().back();
			driver.findElement(By.name("field-keywords")).sendKeys("headphone");
			driver.findElement(By.className("nav-input")).click();
			driver.navigate().back();
			driver.findElement(By.tagName("input")).sendKeys("lays");
			driver.findElement(By.className("nav-input")).click();
			//closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public static void main(String[] args) {
		try {
			TestElementLocatorTechniques locatorTech = new TestElementLocatorTechniques();
			locatorTech.locatorTechniques();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}