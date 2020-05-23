package org.h2k;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class findPatient {
	
	WebDriver driver;
	
	@BeforeTest
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
	
	@Test(priority = 5)
	public void findPatient() throws Exception{
		 String findPatient = "//a[contains(@id,'activeVisitsHomepage')][1]";
		 driver.findElement(By.xpath(findPatient)).click();
		 
		 String patientName = "//input[@id='patient-search']";
		 driver.findElement(By.xpath(patientName)).sendKeys("John White");
		 
		 String patientResult = "(//*[@id='patient-search-results-table']//tr/td[1])[1]";
		 driver.findElement(By.xpath(patientResult)).click();
		
		
		
	}
}
