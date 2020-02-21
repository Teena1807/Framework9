package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentPOM {
	private WebDriver driver; 
	
	public AssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Assignments']")
	private WebElement Assignmentlink; 
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[3]/a[1]/img")
	private WebElement clickCreateAssgn;
	
	@FindBy(id="form1_new_dir")
	private WebElement assignname; 
		
	@FindBy(xpath="/html/body")
	private WebElement textBox; 
	
	@FindBy(id="advanced_params")
	private WebElement addnSettings; 
	
	@FindBy(id="form1_qualification")
	private WebElement maxscore;
	
	@FindBy(id="form1_submit")
	private WebElement validatebttn; 
	
	@FindBy(xpath="/html/body/main/section/div/div[5]/div[1]/div/div/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[1]/input")
	private WebElement clickchkbox; 
	
	public void clickAssessLink() {
		this.Assignmentlink.click(); 
	}
	
	public void clickCreateAssignk() {
		this.clickCreateAssgn.click(); 
	}
	
	public void sendAssignName(String assignname) {
		this.assignname.clear();
		this.assignname.sendKeys(assignname);
	}
	
	public void enterAssignText(String textBox) {	
		driver.switchTo().frame(0);
		WebElement el  =  driver.switchTo().activeElement();
		new Actions(driver).moveToElement(el).perform();
		this.textBox.sendKeys(textBox);
	}     
	
	public void clickAdvanceSettings() {
		driver.switchTo().defaultContent();
		this.addnSettings.click();
	}
	
	public void enterMaxScore(String maxscore) {
		this.maxscore.clear(); 
		this.maxscore.sendKeys(maxscore); 
	}
	
	public void clickValidateBttn() {
		this.validatebttn.click();
	}
	
	public void clickCheckBox() {
		this.clickchkbox.click();
	}
}
