package org.h2k;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginOpenmrs {
	
	WebDriver driver;
	
	public void login() throws Exception{
		
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");

		driver.findElement(By.xpath("//ul/li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();
		//boolean result = true;
		//return result;
		
	}
	
	
	

}
