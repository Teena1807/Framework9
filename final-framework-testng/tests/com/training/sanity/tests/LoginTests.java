package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.EditProfilePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM1 loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private static GenericMethods gmethod;
	static ExtentTest test;
    static ExtentReports report;
	private EditProfilePOM editprofile;

	/*@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		
	}*/

	@BeforeTest
	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM1(driver); 
		editprofile = new EditProfilePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		gmethod = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html");
	    test = report.startTest("ExtentDemo");
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=1)
	public void validLoginTest() {
		loginPOM.sendUserName("manzoor1113");
		boolean Result1=gmethod.validateTextBox(driver,"id","login","manzoor1113");
      	Assert.assertTrue(Result1);
        System.out.println("Username exists");
        test.log(LogStatus.PASS, "Username Entered");
   screenShot.captureScreenShot("Login1");
      	
      	
		loginPOM.sendPassword("manzoor");
		boolean Result2=gmethod.validateTextBox(driver,"id","password","manzoor");
      	Assert.assertTrue(Result2);
        System.out.println("Password");
       test.log(LogStatus.PASS, "Password Entered");
    	screenShot.captureScreenShot("Login2");
      	
		loginPOM.clickLoginBtn(); 
		boolean Result3=GenericMethods.elementSelected(driver,"//*[@id='homepage-course']");
    	Assert.assertTrue(Result3);
		
		    System.out.println("login");
		   test.log(LogStatus.PASS, "Login Successful Entered");
	    	screenShot.captureScreenShot("Login");
		screenShot.captureScreenShot("Login5");
	}
	@Test(priority=2)
	public void editProfileTest() {
		editprofile.editProfile();
		String expected= driver.getTitle();
		String Actual = "My Organization - My education - Profile";
	Assert.assertTrue(expected.equals(Actual));
	 System.out.println("TitleMatch");
	test.log(LogStatus.PASS, "Edit Profile page ");
 	screenShot.captureScreenShot("EditProfile1");
       
        editprofile.sendPassword("manzoor");
		boolean Result2=gmethod.validateTextBox(driver,"id","password1","manzoor");
      	Assert.assertTrue(Result2);
        System.out.println("Password");
        test.log(LogStatus.PASS, "Password Entered ");
     	screenShot.captureScreenShot("EditProfile2");
      	

        editprofile.sendNewPassword("manzoor");
		boolean Result3=gmethod.validateTextBox(driver,"id","profile_password2","manzoor");
      	Assert.assertTrue(Result3);
        System.out.println("new Password");
        test.log(LogStatus.PASS, "New Password");
     	screenShot.captureScreenShot("EditProfile3");
        
        editprofile.saveSetting();
		boolean Result4=GenericMethods.elementSelected(driver,"//div[@class='alert alert-info']");
    	Assert.assertTrue(Result4);
		
		    System.out.println("Saved");
		    test.log(LogStatus.PASS, "Saved");
		 	screenShot.captureScreenShot("EditProfile4");
	}
}
