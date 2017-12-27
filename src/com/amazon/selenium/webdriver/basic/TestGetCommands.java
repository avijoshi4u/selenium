package com.amazon.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webDriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			getCommands();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getCommands() {
		try {
			driver.get("https://www.amazon.com/");
			
			String titleOfThePage = driver.getTitle();
			System.out.println("Title of the Page: "+titleOfThePage);
			
			driver.findElement(By.linkText("Gift Cards")).click();
			String currentURL = driver.getCurrentUrl();
			System.out.println("The Current URL is: "+currentURL);
			
			System.out.println("Page Source is: "+driver.getPageSource());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			TestGetCommands getCommands = new TestGetCommands();
			getCommands.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
