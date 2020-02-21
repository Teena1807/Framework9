package com.training.sanity.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.SignUpPOM;
//import com.training.pom.LoginPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//import Assertmethods.validateUrl;

//import Assertmethods.validateUrl;

public class SignUpTeacher {

	private WebDriver driver;
	private String baseUrl;
	private SignUpPOM signupPOM;
	private static Properties properties;
	private static GenericMethods gmethod;
	static ExtentTest test;
    static ExtentReports report;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		System.out.println(System.getProperty("user.dir"));
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html");
	    test = report.startTest("ExtentDemo");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupPOM = new SignUpPOM(driver); 
		gmethod = new GenericMethods(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		report.endTest(test);
	    report.flush();
		driver.quit();
	}
	@Test
	public void validSignUpTest() {
	signupPOM.clickSignUp();
	Boolean Result=	gmethod.isElementFound("//h2[text()='Registration']","xpath");
	Assert.assertTrue(Result);
	//System.out.println("Registraion Page exists");
	test.log(LogStatus.PASS, "Sign Up page Loaded Sucessfully");
	screenShot.captureScreenShot("First");
		
    	signupPOM.sendFirstName("manzoor");
      	Boolean Result1=gmethod.validateTextBox(driver,"id","registration_firstname","manzoor");
    	Assert.assertTrue(Result1);
    //	System.out.println("Firstname exists");
    	test.log(LogStatus.PASS, "Firstname Entered");
    	screenShot.captureScreenShot("Second");
    	
		signupPOM.sendLastName("mehadi");
		Boolean Result2=gmethod.validateTextBox(driver,"id","registration_lastname","mehadi");
    	Assert.assertTrue(Result2);
    //	System.out.println("last name exists");
    	test.log(LogStatus.PASS,"last name Entered");
    	screenShot.captureScreenShot("Third");
    	
    	
		signupPOM.sendEmail("manzoor@gmail.com");
		Boolean Result3=gmethod.validateTextBox(driver,"id","registration_email","manzoor@gmail.com");
    	Assert.assertTrue(Result3);
    	test.log(LogStatus.PASS,"Email Entered");
    	screenShot.captureScreenShot("FOurth");
    	//System.out.println("Email exists");
    	
		signupPOM.sendUserName("manzoor1118");
		Boolean Result4=gmethod.validateTextBox(driver,"id","username","manzoor1118");
    	Assert.assertTrue(Result4);
    	test.log(LogStatus.PASS, "Username Entered");
    	screenShot.captureScreenShot("Fifth");
    	//System.out.println("Username exists");
    	
		signupPOM.sendPassword("manzoor");
		Boolean Result5=gmethod.validateTextBox(driver,"id","pass1","manzoor");
    	Assert.assertTrue(Result5);
    	test.log(LogStatus.PASS, "Password  Entered");
    	screenShot.captureScreenShot("Sixth");
    	//System.out.println("Password exists");
    	
		signupPOM.sendConfPassword("manzoor");
		Boolean Result6=gmethod.validateTextBox(driver,"id","pass2","manzoor");
    	Assert.assertTrue(Result6);
    	test.log(LogStatus.PASS, "Confirm Password Entered");
    	screenShot.captureScreenShot("Seventh");
    	//System.out.println("confirm Password exists");
    	
        signupPOM.sendPhone("9876543210");
   		Boolean Result7=gmethod.validateTextBox(driver,"id","registration_phone","9876543210");
    	Assert.assertTrue(Result7);
    	test.log(LogStatus.PASS, "Phonenumber  Entered");
    	screenShot.captureScreenShot("Eight");
     //	System.out.println("Phone exists");
    	
        signupPOM.sendLaungage("English");
        if(driver.findElement(By.xpath("//*[@class='filter-option-inner-inner' and text()='English']")).isDisplayed());
		{
			System.out.println("Language displayed");
		}
		test.log(LogStatus.PASS, "Language English Selected ");
		screenShot.captureScreenShot("Ninth");
		
        signupPOM.clickTecherProfile();
        boolean Result9=GenericMethods.elementSelected(driver,"//input[@value=1]");
    	Assert.assertTrue(Result9);
    	//System.out.println("Profile exists");
    	test.log(LogStatus.PASS, "Teacher Profile Selected");
    	screenShot.captureScreenShot("Tenth");
    	
    	
        signupPOM.clickRegisterBtn();
        boolean Result10=GenericMethods.elementSelected(driver,"//*[@id='cm-content']/div/div[2]/div/p[1]/text()[1]");
        Assert.assertFalse(Result10);
       // System.out.println("User exists");
        test.log(LogStatus.PASS, "User Already Registered ");
        screenShot.captureScreenShot("Eleven");
    	
	}
	
		
		}
