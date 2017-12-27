package com.amazon.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introduction {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("https://www.amazon.com/");
			searchPhone();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchPhone() {
		try {
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
			driver.findElement(By.className("nav-input")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		try {
			Introduction intro = new Introduction();
			intro.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
