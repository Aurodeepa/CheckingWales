package MMP;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import MMP.UtilityMMP;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewReport {

	WebDriver driver;


	@Test(description="US_006 Creation of Report",groups={"US_006","regression","sanity","patientmodule"})
	public void patientView() throws Exception {


		instantiateDriver();
		UtilityMMP util = new UtilityMMP(driver);
		util.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		util.login("anya", "Anyam@15");
		util.moduleNavigation("Profile");
		viewReports();


	}

	public void instantiateDriver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public void viewReports() throws Exception{

		String expectedHeader = "View Reports";
		String header ;


		String reportsBtn = "//a/button[contains(text(),'Reports')]" ;
		driver.findElement(By.xpath(reportsBtn)).click();

		WebElement we3 = driver.findElement(By.xpath("(//h3)[2]"));
		header = we3.getText();
		System.out.println(header);
		if(expectedHeader.equalsIgnoreCase(header)) {

			String result = "matched";
			System.out.println(result);
		}
		else {
			System.out.println("Not matched");
		}
		
		//String viewRep = "(//tr/td)[2]//li";
        //driver.findElement(By.xpath(viewRep)).click();
		
		/*Checking the number of tds and trs*/
		
		List<WebElement> list = driver.findElements(By.xpath("//tbody//tr//td"));
		System.out.println(list.size());
		
		
 
	for(int i=1;i<=list.size();i++) {
	
			String viewRep = "(//tr/td)['"+ i +"']//li";
			System.out.println(viewRep);
			driver.findElement(By.xpath(viewRep)).click();
           driver.findElement(By.xpath("//div[contains(@class,'mfp-container')]")).click();
            
           
		}
		

	}


}
