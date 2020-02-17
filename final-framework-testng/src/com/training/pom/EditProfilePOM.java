package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePOM {
	private WebDriver driver; 
	
	public EditProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit profile']")
	private WebElement editprofile; 
	
	@FindBy(id="password1")
	private WebElement pass;
	
	@FindBy(id="profile_password2")
	private WebElement newpassword; 
	
	@FindBy(id="profile_apply_change")
	private WebElement savebttn; 
	
	
	public void editProfile() {
	this.editprofile.click();
	}
	
	public void sendPassword(String password) {
		this.pass.clear(); 
		this.pass.sendKeys(password); 
	}
	
	public void sendNewPassword(String newpassword) {
		this.newpassword.clear(); 
		this.newpassword.sendKeys(newpassword); 
	}
	
	public void saveSetting() {
		
		this.savebttn.click();
	}
}
