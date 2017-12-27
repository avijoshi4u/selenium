package com.amazon.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNavigateCommands {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webDriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			navigateCommands();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void navigateCommands() {
		try {
			driver.navigate().to("https://www.amazon.com/");
			driver.findElement(By.linkText("Gift Cards")).click();
			driver.findElement(By.xpath("//span[starts-with(text(), 'eGift Card')]")).click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().forward();
			Thread.sleep(3000);
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			TestNavigateCommands navigateCommands = new TestNavigateCommands();
			navigateCommands.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}