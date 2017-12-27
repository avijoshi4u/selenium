package Others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("file:///Users/ajoshi007c/Documents/Avinash/workspace/Selenium/FramesExample.html");
			switchFrames();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchFrames() {
		try {
			
			//To find the total number of frames in a web page
			int totalFrames= driver.findElements(By.tagName("iframe")).size();
			System.out.println("Total Number of Frames are "+totalFrames);
			
			//Scenario 1: if you know the total number of frames in the web page then using the id, you can easily switch.
			//Syntax- driver.switchTo().frame(index)
			//driver.switchTo().frame(2);
			
			//Scenario 2.1: if you know the name  of the frame in the web page then using name also, you can easily switch.
			//Syntax- driver.switchTo().frame('frame-name')
			//driver.switchTo().frame("AltonGreen");
			
			//Scenario 2.2: if you know the id of a frame in the web page then using the id, you can easily switch.
			//Syntax- driver.switchTo().frame(id)
			//driver.switchTo().frame("website3");
			
			//Scenario 3: By web element
			//Syntax- driver.switchTo().frame('web element')
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='alton']")));
			
			
			driver.findElement(By.xpath("//A[@href='/apartments/co/denver/floor-plans'][text()='View Floor Plans']")).click();
			((JavascriptExecutor)driver).executeScript("scroll(0,200)");
			driver.findElement(By.xpath("//SPAN[@class='is-studio'][text()='1 Bed']")).click();
			
			driver.switchTo().defaultContent();
			
			driver.findElement(By.xpath("//A[contains(text(), 'My Automation Link')]")).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			HandleFrames frame = new HandleFrames();
			frame.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
