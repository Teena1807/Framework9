package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignUpPOM {

private WebDriver driver; 
	
	public SignUpPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Sign up!")
	private WebElement SignUp; 
	
	@FindBy(id="registration_firstname")
	private WebElement firstname;
	
	@FindBy(id="registration_lastname")
	private WebElement lastname; 
	
	@FindBy(id="registration_email")
	private WebElement email; 
	
	@FindBy(id="username")
	private WebElement uname; 
	
	@FindBy(id="pass1")
	private WebElement password; 
	
	@FindBy(id="pass2")
	private WebElement cofmpassword; 
	
	@FindBy(id="registration_phone")
	private WebElement phone; 
	
	//@FindBy(className="filter-option-inner-inner");
	//@FindBy(xpath="//div[text()='English']")
	//private List<WebElement> options;
	//private WebElement Select; 
	   @FindBy(xpath ="//*[@class='filter-option-inner-inner' and text()='English']")
	    private WebElement dropdown;

	 
	
	@FindBy(xpath="//input[@value=5]")
	private WebElement profile; 
	
	@FindBy(xpath="//input[@value=1]")
	private WebElement profileteacher; 
	
	
	@FindBy(id="registration_submit")
	
	private WebElement regbutton; 

	public void clickSignUp() {
		this.SignUp.click(); 
	}
	
	public void sendFirstName(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	public void sendLastName(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	
	public void sendUserName(String uname) {
		this.uname.clear();
		this.uname.sendKeys(uname);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendConfPassword(String cofmpassword) {
		this.cofmpassword.clear(); 
		this.cofmpassword.sendKeys(cofmpassword); 
	}
	
	public void sendPhone(String phone) {
		this.phone.clear(); 
		this.phone.sendKeys(phone); 
	}
	
	//public void select_list()
	//{
		/*int sizew= options.size();
		for (int i=0;i<sizew;i++)
		{
			if((this.options.get(i).getText()=="English"))
			{				options.get(i).click();}
				//Assert.assertTrue(options.get(i).getAttribute("value")=="English");
			}
			*/
	 //  Select stat=new Select(dropdown);
	  // stat.selectByVisibleText("English");
		
		public void sendLaungage(String Laungage) {
	      //  Select laung = new Select(this.laungage);
	     //   laung.selectByVisibleText(Laungage);
			Actions builder = new Actions(driver);
			WebElement dropdown= this.dropdown;
			Actions dpdn= builder.moveToElement(dropdown).click().sendKeys(Keys.ENTER);
			dpdn.build().perform();     
	        
	
	}
	public void clickProfile() {
		this.profile.click(); 
	}
	
	public void clickTecherProfile() {
		this.profileteacher.click(); 
	}
	
	public void clickRegisterBtn() {
		
		this.regbutton.click(); 
		
	}
}
