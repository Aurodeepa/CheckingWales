package org.h2k;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteServiceTypeOpenMRS {


	static FirefoxDriver driver;

	public static void main(String[] args) throws Exception {



		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");

		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");

		driver.findElement(By.xpath("//ul/li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();


		String apptSched = "//a[contains(@id, 'appointmentscheduling')]";
		driver.findElement(By.xpath(apptSched)).click();

		String serviceTypes = "//i[@class='icon-calendar']";
		driver.findElement(By.xpath(serviceTypes)).click();

		boolean result = DeleteServiceTpe("Surgery (New Patient)"); 
		System.out.println(result);

	}


	public static boolean DeleteServiceTpe(String serviceName) throws Exception{

		int j = 0;
		boolean result = false;

		String deleteButton = "//div[@id='delete-appointment-type-dialog']//button[@class='cancel']";
		List<WebElement> buttonList = driver.findElements(By.xpath(deleteButton));

		System.out.println("Number of buttons" + buttonList.size() );

		List<WebElement> pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
		List<WebElement> trList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//tr/td[1]"));

		//Looking for the ServiceType in the current page
		Outer:
			for(j=1;j<=pageList.size();j++) {

				for(int k=0;k<trList.size();k++) {

					//System.out.println(serviceName);
					//System.out.println(trList.get(k).getText());

					if(trList.get(k).getText().contains(serviceName)) {

						//System.out.println(trList.size());
						System.out.println(serviceName);

						String deleteService = "//td[text()='" + serviceName + "']/following-sibling::td//i[@title='Delete']";
						System.out.println(deleteService);
						driver.findElement(By.xpath(deleteService)).click();


						for(int i=0;i<buttonList.size();i++) {

							try {

								if(buttonList.get(i).isDisplayed() || buttonList.get(i).isEnabled()) {

									buttonList.get(i).click();
									result = true;
									System.out.println(result);
									break Outer;

								}

							}
							catch(Exception e)
							{
								System.out.println("Element is not visible or enable" + e.getMessage());
							}

						}


						break;

					}

				}

				pageList = driver.findElements(By.xpath(".//*[@id='appointmentTypesTable_paginate']/span/a"));
				pageList.get(j).click();
				trList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//tr/td[1]"));


			}

		System.out.println(buttonList.size());

		return result;
	}

}
