package com.xfinity.tv.selenium.webdriver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basic {
	
	
	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			System.setProperty("webdriver.firefox.driver", "geckodriver");
			
			
			ChromeOptions options = new ChromeOptions(); 
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-component-update"));
			options.addArguments(Arrays.asList("--always-authorize-plugins","--allow-outdated-plugins")); 
			//WebDriver driver= new ChromeDriver(options);
			
			
			driver = new ChromeDriver(options);
			//driver = new FirefoxDriver();
			
			
			
			
			
			
			/*
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("marionette", true);
			
			FirefoxProfile ffProfile = new FirefoxProfile();
			ffProfile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so","true");
			ffProfile.setPreference("plugin.state.flash", 1);
			capability.setCapability(FirefoxDriver.PROFILE, ffProfile);
			*/
			
			
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("https://tv.xfinity.com/");
			
			
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
			
			
			driver.findElement(By.linkText("Sign In")).click();
			
			
			driver.findElement(By.id("user")).sendKeys("cdvrfox5");
			driver.findElement(By.id("passwd")).sendKeys("Xfinity1");
			driver.findElement(By.id("sign_in")).click();
			
			//driver.findElement(By.linkText("Yes")).click();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			Basic myObj = new Basic();
			myObj.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
