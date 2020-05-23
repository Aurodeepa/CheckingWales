package MMP;

import MMP.UtilityMMP;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class ScheduleAppt {

	WebDriver driver;

	@Test(description="US_005 Schedule Appointment",groups={"US_005","regression","sanity","patientmodule"})
	public void ApptDetails() {

		instantiateDriver();
		UtilityMMP util = new UtilityMMP(driver);
		util.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		util.login("anya", "Anyam@15");
		util.moduleNavigation("Schedule Appointment");
		clickOnCreateAppointmentButton();
		util.callDoc("Dr.Beth");
		bookAppointment();
		

	}
	public void clickOnCreateAppointmentButton()
	{
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
	}
	public void instantiateDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
	}
	
 public void bookAppointment() {
	 
		 
	 Date d = new Date();
	// Alert alrt = driver.switchTo().alert();
	 driver.switchTo().frame("myframe");
	 
	 WebElement calElement = driver.findElement(By.id("datepicker"));
	 calElement.click();
	 
	 String  buttonOk = "//button[@id='ChangeHeatName']";
	 driver.findElement(By.xpath(buttonOk)).click();
		 
	
 }



}
