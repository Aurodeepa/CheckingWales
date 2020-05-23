package org.h2k;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert {
	
	
	public static void main(String[] args) throws Exception{
		
		
		WebDriver driver;
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}

}
