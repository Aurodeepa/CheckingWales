package MMP;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityMMP {
	
	int i =0;
	WebDriver driver;
	public UtilityMMP(WebDriver driver)
	{
		//System.out.println("selenium "+ i +"webdriver");
		
		this.driver = driver;
	}
	public void moduleNavigation(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	 
	public void launchApplicationURL(String url)
	{
		driver.get(url);
		 
	}
	
	public void login(String userName,String pwd) {

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);

		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}
	
	public void callDoc(String docName){
		
		 String bookApt = "//li/h4[contains(text(),'"+ docName +"')]/ancestor::td/button[@id='opener']";
		
		 driver.findElement(By.xpath(bookApt)).click();
	}

}
