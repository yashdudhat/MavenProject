 package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	WebDriver driver;
/*
	public WebElement emailBox = driver.findElement(By.id("usernameInput-input"));
	public WebElement passwordBox = driver.findElement(By.id("password-input"));
	public WebElement loginButton = driver.findElement(By.id("signIn"));
	public WebElement globalErr = driver.findElement(By.id("globalError"));
	public WebElement emailErr = driver.findElement(By.className("Error__text"));
*/
	
	@FindBy(id = "usernameInput-input")
	public WebElement emailBox;
	
	@FindBy(id = "password-input")
	public WebElement passwordBox;
	
	@FindBy(id = "signIn")
	public WebElement loginButton;
	
	@FindBy(id = "globalError")
	public WebElement globalErr;
	
	@FindBy(className = "Error__text")
	public WebElement emailErr;
	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\Users\\dudha\\Desktop\\QA\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dudha\\Desktop\\QA\\SeleniumJars\\geckodriver.exe");	
			 driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dudha\\Desktop\\QA\\SeleniumJars\\chromedriver.exe");	
			 driver = new ChromeDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void openScotiaBankLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=VB_ET2_0W0g&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiVkJfRVQyXzBXMGciLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYxNTA1MzI2OSwiaWF0IjoxNjE1MDUyMDY5LCJqdGkiOiIwMmI3ZGVjNi1kNDg5LTQzMjQtYjQzMC02OTkzN2NjMTljZDgiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.aUBko9HCQqvyCeFeMD_fvBXL0eTj_RgW7KDJMaK6NQk7aW2KetEeeCt4mm2MnOIEHrq7jcLuvAcXYKIWvCnBbzKjq-NaEFQQ5vPEfDZCpKR9azedooayN_OPVf2a0vqfOzS8bEs9ESVifrQLbLIBE0pF67xeBCVbO2C6M_Z63MBP4BAtSVPvjN4pytVo1ePjF4qbEDg0Ro5DKqAPwHk7x7-CnQ5yqngIJVV97G6C5Hen6kWYuYsX5WYJbZphAjs1AQyzu1A2IunRvIuo43aB9R1Uq9zb_8eVrGwx0eTCIURPQ1b0K-ui29r6QAQD7IdHLzsOBIXYcSL_FQEl_fSouA&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		driver.quit();
	}


	public void login(String email, String password) throws InterruptedException {
		emailBox.sendKeys(email);
		passwordBox.sendKeys(password);
		loginButton.click();
		Thread.sleep(2000);		
		
	}

	
	public String readGobalError() {
		
		String actualErr = globalErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}

	public String readEmailError() {
		
		String actualErr = emailErr.getText();
		System.out.println(actualErr);
		return actualErr;
	}

}
