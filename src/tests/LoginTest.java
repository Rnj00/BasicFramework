package tests;

import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	LoginPage lp =new LoginPage();
	DataFile df=new DataFile();
	
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 lp.openBrowser();
	 lp.openLoginUrl();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  
  @Test(priority=1)
  public void loginWithWrongEmailandPasswordTest() throws InterruptedException {
	  lp.login(df.wrongEmail,df.wrongPass);
		String expectedErr = df.globalErr;
		String actualErr = lp.readGLobalError();
		Assert.assertEquals(actualErr,expectedErr);
	  
		
  }
  @Test(priority=2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	    lp.login("", df.wrongPass);
		String expectedErr = df.emptyEmailErr;
		String actualErr = lp.readError();
		Assert.assertEquals(actualErr,expectedErr);
		
  }
  @Test(priority=3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	  	lp.login(df.wrongEmail, "");
		String expectedErr = df.emptyPassErr;
		String actualErr = lp.readError();
		Assert.assertEquals(actualErr,expectedErr);
		
  }
  @Test(priority=4)
  public void loginWithEmailSpecialCharTest() throws InterruptedException {
	  lp.login(df.emailWithSpecialChar, df.wrongPass);
		Thread.sleep(3000);
		String expectedErr = df.emailSpecialCharErr;
		String actualErr = lp.readError();
		Assert.assertEquals(actualErr,expectedErr);
		
  }

}
