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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	WebDriver driver;
	
	@FindBy(name = "usernameInput")
	public WebElement email;
	
	@FindBy(name = "password")
	public WebElement pwd;
	
	@FindBy(className = "ButtonCore__block")
	public WebElement button;
	
	@FindBy(id = "globalError")
	public WebElement globalError;
	
	@FindBy(className = "Error__text")
	public WebElement error;
 
	
	
	public void openBrowser() throws IOException
	{
		FileInputStream f = new FileInputStream("/Users/amitmehta/Desktop/testing/prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		String browser = prop.getProperty("browser");
		// System.setProperty("webdriver.gecko.driver", "/Users/amitmehta/Desktop/SeleniumJars/geckodriver");
		  //driver =new FirefoxDriver();
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/amitmehta/Desktop/SeleniumJars/geckodriver");
			driver =new FirefoxDriver();
			
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/amitmehta/Desktop/SeleniumJars/chromedriver");
			 driver =new ChromeDriver();
			
		}else {
			System.setProperty("webdriver.safari.driver", "/Users/amitmehta/Desktop/SeleniumJars/safaridriver");
			driver =new SafariDriver();
		}
		
		PageFactory.initElements(driver, this);
	}

	public void openLoginUrl() {
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=1KDqh57b2sI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiMUtEcWg1N2Iyc0kiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzMzI3MTQwMywiaWF0IjoxNjMzMjcwMjAzLCJqdGkiOiI0NzMyNTlkZi03NTg0LTQzYmEtODQ1My1iZDcxZDAwNzYyN2YiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.oge4H7k76p_07WX8jafeRs7QTatB3KS_6iFWCFpoNri16WWf1gqyG_YDN4wsBzstYpR1rx7-jDMAVL6TvDjcXqOv6f0T-Wnx3R-7nqN0O25IUnJ1q9CiNMIWIJsrQ-RrFh0lX7tDJPH9Pe2q3s7H8UU6eVx2ReNbtsIrWwXeu0pGMmmdCr4NRz8J9R1tA3RsMue0ema88ejYZUFycr6VhnvZNudzou_OErItwhJALBFlyffBoztzdST-jv93wJjAj4lbLdggWgprLYNv9hQPzUAddBiBdEKbsI8NoK1NlA68_dejYdwTBsNs4I14XQsa1Z02owjAC_Z1zG8SkkCKMA&preferred_environment=");
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void login(String username,String password) throws InterruptedException {
		 
		email.sendKeys(username);
		pwd.sendKeys(password);
		button.click();
		Thread.sleep(3000);
	}
	
	public void loginWithEmptyEmail() throws InterruptedException {
		 pwd.sendKeys("ndndfndsfndnfd");
		 button.click();
		 Thread.sleep(3000);
	}
	
	
	public String readGLobalError() {
		String actualErr =globalError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readError() {
		String actualErr = error.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
