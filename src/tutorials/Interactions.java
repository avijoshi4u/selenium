package tutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Interactions {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://www.calculator.net/");
			
			//textBoxInteraction();
			//radioButtonInteraction();
			//checkBoxInteraction();
			dropdownInteraction();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public void textBoxInteraction() {
		try {
			driver.findElement(By.xpath("//*[contains(text(),'Math Calculators')]")).click();
			driver.findElement(By.xpath("//*[@id='content']/ul/li[2]/a")).click();
			
			driver.findElement(By.id("c4l1")).sendKeys("5");
			driver.findElement(By.id("c4t1")).sendKeys("3");
			driver.findElement(By.id("c4b1")).sendKeys("2");
			
			driver.findElement(By.xpath("//div[@id='content']/table[2]/tbody/tr[4]/td/input[@value='Calculate']")).click();
			
			String result = driver.findElement(By.id("fcoutput")).getText();
			System.out.println(result);
			
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void radioButtonInteraction() {
		try {
			driver.findElement(By.xpath("//div[@id='homelistdiv']/table/tbody/tr/td[2]/div[2]/a")).click();
			driver.findElement(By.xpath("//div[@id='content']/table/tbody/tr/td/div[1]/a[contains(text(),'BMI Calculator')]")).click();
			
			driver.findElement(By.id("cage")).clear();
			driver.findElement(By.id("cage")).sendKeys("26");
			driver.findElement(By.id("csex2")).click();
			driver.findElement(By.id("cheightfeet")).clear();
			driver.findElement(By.id("cheightfeet")).sendKeys("5");
			driver.findElement(By.id("cheightinch")).clear();
			driver.findElement(By.id("cheightinch")).sendKeys("3");
			driver.findElement(By.id("cpound")).clear();
			driver.findElement(By.id("cpound")).sendKeys("144");
			driver.findElement(By.xpath("//INPUT[@type='image']")).click();
			
			String BMI = driver.findElement(By.xpath("//div[@class='bigtext']/b")).getText();
			String analysis = driver.findElement(By.xpath("//div[@class='bigtext']/font/b")).getText();
			
			boolean genderSelected = driver.findElement(By.id("csex2")).isSelected();
			String gender = driver.findElement(By.xpath("//table[@id='calinputtable']/tbody/tr[2]/td[2]/label[2]")).getText();
			
			if (genderSelected){
				System.out.println("Results: "+"Gender: "+ gender+ " " + BMI +" Analysis: "+ analysis);
			}
			
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			}	
	}
	
	public void checkBoxInteraction() {
		try {
			driver.findElement(By.xpath("//A[@href='/financial-calculator.html'][text()='Financial Calculators']")).click();
			driver.findElement(By.xpath("//A[@href='/auto-loan-calculator.html'][text()='Auto Loan Calculator']")).click();
			driver.findElement(By.id("cloanamount")).clear();;
			driver.findElement(By.id("cloanamount")).sendKeys("18000");
			driver.findElement(By.id("cloanterm")).clear();
			driver.findElement(By.id("cloanterm")).sendKeys("36");
			driver.findElement(By.id("cinterestrate")).clear();
			driver.findElement(By.id("cinterestrate")).sendKeys("1");
			driver.findElement(By.id("cdownpayment")).clear();
			driver.findElement(By.id("cdownpayment")).sendKeys("1000"); 
			driver.findElement(By.id("ctradeinvalue")).clear();
			driver.findElement(By.id("ctradeinvalue")).sendKeys("0");
			
			Select dropdown = new Select(driver.findElement(By.name("cstate")));
			dropdown.selectByVisibleText("Colorado");
			
			driver.findElement(By.id("csaletax")).clear();
			driver.findElement(By.id("csaletax")).sendKeys("7");
			
			driver.findElement(By.id("ctitlereg")).clear();
			driver.findElement(By.id("ctitlereg")).sendKeys("400");
			
			driver.findElement(By.id("cttrinloan")).click();
			
			driver.findElement(By.xpath("//input[@type='image']")).click();
			
			String MonthlyEMI= driver.findElement(By.xpath("//H2[@class='h2result'][contains(text(),'Monthly Pay: ')]")).getText();
			System.out.println(MonthlyEMI);
			
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void dropdownInteraction() {
		driver.findElement(By.xpath("//A[@href='/fitness-and-health-calculator.html'][contains(text(),'Fitness ')]")).click();
		driver.findElement(By.xpath("//A[@href='/calorie-calculator.html'][contains(text(), 'Calorie Calculator')]")).click();
		
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("29");
		driver.findElement(By.id("csex1")).click();
		driver.findElement(By.id("cheightfeet")).clear();
		driver.findElement(By.id("cheightfeet")).sendKeys("5");
		driver.findElement(By.id("cheightinch")).clear();
		driver.findElement(By.id("cheightinch")).sendKeys("11");
		driver.findElement(By.id("cpound")).clear();
		driver.findElement(By.id("cpound")).sendKeys("178");
		
		Select dropdown = new Select(driver.findElement(By.name("cactivity")));
		
		//In case of dropdown, we can select an option using 'selectByVisibleText' or 'selectByIndex' or 'selectByValue' methods
		
		//dropdown.selectByVisibleText("Sedentary - little or no exercise");
		//dropdown.selectByIndex(1);
		dropdown.selectByValue("1.2");
		
		driver.findElement(By.xpath("(//INPUT[@type='image'])[1]")).click();
		
		String CalorieResults= driver.findElement(By.xpath("(//TD)[1]")).getText();
		System.out.println(CalorieResults);
		
		driver.close();
	}
	
	public static void main(String[] args) {
		try {
			Interactions actions = new Interactions();
			actions.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
