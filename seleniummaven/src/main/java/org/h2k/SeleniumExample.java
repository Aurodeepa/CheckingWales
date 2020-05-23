package org.h2k;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExample {
	
WebDriver driver;
	
	int i ;
	@Test
	public void validateSearchResults() throws Exception
	{
		/*
		 * 1. Enter the url https://www.yahoo.com/
		 * 2. Enter the text Selenium in the Textbox
		 * 3. Select "Selenium Interview Questions" from the List
		 * 4. Check the search results page is displayed
		 * 5. Expected Result : Validate the Search results contains "Selenuim Interview Questions".
		 * 6. Expected Result : Validate the Search REsults in first 5 pages contains "Selenium Inteview Questions"
		 * 
		 */
		
		SoftAssert sa = new SoftAssert();
		i =20;
		 
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		//WebDriverManager.chromedriver().setup();
		//driver = new  ChromeDriver();
		driver.get("https://in.yahoo.com/");
	 
		
		
	    Utility util = new Utility(driver);
	    
	    List<WebElement> list =  util.retrieveSearchList("selenium");
	    int actualSize = list.size();
	    int expectedSize = 10;
	    sa.assertEquals(actualSize,expectedSize);
	    
	    boolean result = util.
	    		selectRequiredSearchPattern("selenium interview questions","selenium");
	    //System.out.println(result);
	    sa.assertTrue(result,"Pass");
	    /*
	     * Search PAttern : Questions
	     * Number of PAges: 5
	     * title: selenium interview questions
	     * 
	     */
	    
	   boolean result1 = util.validateLinkText("Selenium Interview Questions",5,"selenium interview questions");
	  // System.out.println(result1);
	    sa.assertTrue(result1,"Pass");
	    sa.assertAll();
	    
	    
	    
	}
	 


}
