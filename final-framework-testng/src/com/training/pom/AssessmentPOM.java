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

public class AssessmentPOM {
	private WebDriver driver; 
	
	public AssessmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Assessments']")
	private WebElement Assessmentlink; 
	
	@FindBy(xpath="//*[@id='gradebook-actions']/div/div[1]/a[2]/img")
	private WebElement addOnlineBttn;
	
	@FindBy(xpath="//*[@id='create_link']/fieldset/div/div[1]/div/button/div/div/div")
	private WebElement selectactivity; 
	
	@FindBy(xpath="//*[@id='add_link']/fieldset/div[1]/div[1]/div/button/div/div/div")
	
	private WebElement selectquiz; 
	
	@FindBy(id="add_link_submit")
	private WebElement addlearningbttn; 

	@FindBy(id="weight_mask")
	private WebElement Weightage; 
	
	@FindBy(xpath="//*[@id='gradebook_list']/tbody/tr[2]/td[6]/a[1]/img")
	private WebElement editassess; 
	
	@FindBy(id="pass_percentage")
	private WebElement passpercentage; 
	
	@FindBy(name="visible")
	private WebElement visible; 
	
	
	@FindBy(id="edit_link_form_submit")
	private WebElement Editbttn; 
	
	@FindBy(xpath="//*[@id='gradebook-actions']/div/div[2]/a[1]/img")
	private WebElement editCataimage; 
	
	@FindBy(id="edit_cat_form_submit")
	private WebElement editCatabttn; 
	
	@FindBy(xpath="//*[@id='gradebook-actions']/div/div[2]/a[2]/img")
	private WebElement attchcert; 
	
	
	public void clickAssessLink() {
		this.Assessmentlink.click();
	}
	
	public void clickAddOnlineAct() {
		this.addOnlineBttn.click();
	}
	
	public void sendActivity(String selectactivity) {
	      	Actions builder = new Actions(driver);
			WebElement dropdown= this.selectactivity;
			Actions dpdn= builder.moveToElement(dropdown).click().sendKeys(selectactivity).sendKeys(Keys.ENTER);
			dpdn.build().perform();      
	}
	
	public void sendQuiz(String selectquiz) {
      	Actions builder = new Actions(driver);
		WebElement dropdown1= this.selectquiz;
		Actions dpdn= builder.moveToElement(dropdown1).click();
		dpdn.build().perform();      
}
	public void sendWeightage(String Weightage) {
		this.Weightage.clear();
		this.Weightage.sendKeys(Weightage);
	}
	
	public void clickVisible() {
		this.visible.click();
	}
	
	public void clickAddLearning() {
		this.addlearningbttn.click();
	}
	
	public void clickEditCtagory() {
		this.editCataimage.click();
	}
	
	public void clickEditCtagoryBtn() {
		this.editCatabttn.click();
	}
	
	public void clickCertificate() {
		this.attchcert.click();
	}
}
