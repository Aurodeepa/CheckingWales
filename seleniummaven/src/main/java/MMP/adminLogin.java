package MMP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class adminLogin {

	WebDriver driver;


	@Test(description="US_006 Creation of Report",groups={"US_006","regression","sanity","adminmodule"})
	public void createReport() throws Exception {

		instantiateDriver();
		launchApplicationURL("http://96.84.175.78/MMP-Release1-Integrated-Build.2.4.000/admin/login.php");
		login("Thomas_444","Edison_444");
		navigatePatient();
		//patientSearchName("anya");
		patientSearchSSN("210911222");
		searchRecord();
		reportDetails("XRAY-Lungs report","This is lungs XRAY report","C:\\Users\\vikib\\Desktop\\Team Wales - SELENIUM PROJECT\\Project Work\\lung-article-703x441.jpg");


	}
	public void instantiateDriver() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public void launchApplicationURL(String url) {

		driver.get(url);

	}

	public void login(String userName,String pwd) {

		driver.findElement(By.xpath("(//input[@id='username'])[1]")).sendKeys(userName);
		driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys(pwd);

		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();

	}

	public void navigatePatient() throws Exception {

		String patient = "//span[contains(text(),'Patients')]";

		driver.findElement(By.xpath(patient)).click();

	}


	public void patientSearchName(String name) throws Exception{

		String searchName = "//input[@name='search']";
		String search = "//input[@type='button']";
		driver.findElement(By.xpath(searchName)).sendKeys(name);
		driver.findElement(By.xpath(search)).click();


	}

	public void patientSearchSSN(String ssn) throws Exception{

		String searchSSN = "//input[@name='search']";
		//String ssnChar = String.valueOf(ssn);
		String search = "//input[@type='button']";
		driver.findElement(By.xpath(searchSSN)).sendKeys(ssn);
		driver.findElement(By.xpath(search)).click();


	}

	public void searchRecord() {



		String resultRecord = "(//div[@id='show']//tr)[2]/td/a";
		System.out.println("resultRecord");
		driver.findElement(By.xpath(resultRecord)).click();

		String createReport = "//input[@value='Reports']";
		driver.findElement(By.xpath(createReport)).click();

	}


	public void reportDetails(String reptName, String reptDesc, String fileName) {

		String selectAppointments = "//select[@name='app_date']";
		WebElement we2 = driver.findElement(By.xpath(selectAppointments));
		Select selectAppt = new Select(we2);
		selectAppt.selectByIndex(3);


		String reportName = "//input[@id='exampleInputcardnumber1']";	
		driver.findElement(By.xpath(reportName)).sendKeys(reptName);

		WebElement we1 = driver.findElement(By.xpath("//input[@id='file']"));
		we1.sendKeys(fileName);

		String reportDesc = "//label[text()='Report Description:']/following-sibling::textarea[@name='report_desc']";
		driver.findElement(By.xpath(reportDesc)).sendKeys(reptDesc);

		String submit = "//input[@type='submit']";
		driver.findElement(By.xpath(submit)).click();



	}
}
