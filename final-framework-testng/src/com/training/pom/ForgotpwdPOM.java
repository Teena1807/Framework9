package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotpwdPOM {
	private WebDriver driver; 
	
	public ForgotpwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='login-block']/div/ul/li[2]/a")
	private WebElement forgotpwd; 
	
	@FindBy(id="lost_password_user")
	private WebElement enteremail;
	
	@FindBy(id="lost_password_submit")
	private WebElement sendmsgbtn; 
	
	public void clickLostpwd() {	
		this.forgotpwd.click();
	}
	
	public void sendEmail(String password) {
		this.enteremail.clear(); 
		this.enteremail.sendKeys(password); 
	}
	
	public void clickSendMsgBtn() {
		this.sendmsgbtn.click(); 
	}
}
