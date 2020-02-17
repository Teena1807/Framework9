package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.EditProfilePOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditProfile {

	private WebDriver driver;
	private String baseUrl;
	private EditProfilePOM editprofile;
	private static Properties properties;
	private ScreenShot screenShot;
	private static GenericMethods gmethod;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		editprofile = new EditProfilePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		gmethod = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test(priority=1)
	public void editProfileTest() {
		editprofile.editProfile();
		
		String expected= driver.getTitle();
		System.out.println(expected);
		//String Actual = "Google";
		
	// Assert.assertTrue(expected.equals(Actual));
	 System.out.println("TitleMatch");
      //	Assert.assertTrue(Result1);
        System.out.println("Profile exists");
       // test.log(LogStatus.PASS, "Username Entered");
    //	screenShot.captureScreenShot("Login1");
      	
       
        editprofile.sendPassword("manzoor");
		boolean Result2=gmethod.validateTextBox(driver,"id","password1","manzoor");
      	Assert.assertTrue(Result2);
        System.out.println("Password");
      //  test.log(LogStatus.PASS, "Password Entered");
    	//screenShot.captureScreenShot("Login2");
      	

        editprofile.sendNewPassword("manzoor");
		boolean Result3=gmethod.validateTextBox(driver,"id","profile_password2","manzoor");
      	Assert.assertTrue(Result3);
        System.out.println("new Password");
        
        editprofile.saveSetting();
		boolean Result4=GenericMethods.elementSelected(driver,"//div[@class='alert alert-info']");
    	Assert.assertTrue(Result4);
		
		    System.out.println("Saved");
		  //  test.log(LogStatus.PASS, "Firstname Entered");
	    	//screenShot.captureScreenShot("Login");
		//screenShot.captureScreenShot("First");
	}
}
