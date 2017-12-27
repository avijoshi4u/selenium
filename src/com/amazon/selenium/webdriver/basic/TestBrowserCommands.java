package com.amazon.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrowserCommands {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webDriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			closeCommand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void closeCommand() {
		try {
			driver.get("https://www.amazon.com/");
			driver.close();
			quitCommand();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void quitCommand() {
		try {
			WebDriver driver2 = new ChromeDriver();
			driver2.get("http://birlainstitute.co.in/");
			driver2.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			TestBrowserCommands browserCommands = new TestBrowserCommands();
			browserCommands.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}