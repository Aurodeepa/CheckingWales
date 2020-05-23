package org.h2k;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class inpatientBreak {

	WebDriver driver;
	

	@BeforeClass
	public void login() throws Exception {


		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");

		driver.findElement(By.xpath("//ul/li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();


	}

	@Test(priority = 5)
	public void navigateService() throws Exception{
		
		boolean result = false;

		int i;
		int j;

		String apptSched = "//a[contains(@id, 'appointmentscheduling')]";
		driver.findElement(By.xpath(apptSched)).click();

		String serviceTypes = "//i[@class='icon-calendar']";
		driver.findElement(By.xpath(serviceTypes)).click();

		List<WebElement> trList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//tr/td[1]"));
		List<WebElement> pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		//System.out.println(trList.size());
		//System.out.println(pageList.size());

        Outer:
		for(i=1;i<=pageList.size();i++) {
			for(j=0;j<trList.size();j++) {

				//System.out.println(trList.get(j).getText());
					
				if(trList.get(j).getText().contains("Urology"))
				{

					System.out.println("Urology available in index" + (j+1) );
					result = true;
					System.out.println(result);
					break Outer;
				}


			}
					
		
		pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		pageList.get(i).click();
		trList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//tr/td[1]"));
		}
		
		System.out.println(result);
	}


}
