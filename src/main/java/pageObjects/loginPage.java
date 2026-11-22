package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.waitBase;

public class loginPage extends waitBase{
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input[id='userEmail']")
	WebElement usrName;
	
	@FindBy(css="input[id='userPassword']")
	WebElement pwrd;
	
	@FindBy(css="input[id='login']")
	WebElement loginBtn;
	
	@FindBy(css="a.forgot-password-link")
	WebElement frgtPswrdBtn;
	
	@FindBy(css="input[formcontrolname='userEmail']")
	WebElement frgtPswrdEMail;
	
	@FindBy(css="input[id='userPassword']")
	WebElement frgtPswrdNwPswrd;
	
	@FindBy(css="input[id='confirmPassword")
	WebElement frgtPswrdconfirmPswrd;
	
	@FindBy(css="button.btn-block")
	WebElement frgtPswrdSavePswrdBtn;
	
	public shoppingPage login(String userName,String password) {
		usrName.sendKeys(userName);
		pwrd.sendKeys(password);
		loginBtn.click();
		shoppingPage shoppingPage = new shoppingPage(driver);
		return shoppingPage;
	}
	
	public void forgotpwrd(String eMail, String newPassword, String confirmPswrd) {
		frgtPswrdBtn.click();
		frgtPswrdEMail.sendKeys(eMail);
		frgtPswrdNwPswrd.sendKeys(newPassword);
		frgtPswrdconfirmPswrd.sendKeys(confirmPswrd);
		frgtPswrdSavePswrdBtn.click();
	}
	
	public void waitforElements() {
	wait.until(ExpectedConditions.visibilityOf(usrName));
	wait.until(ExpectedConditions.visibilityOf(pwrd));
	wait.until(ExpectedConditions.visibilityOf(loginBtn));
	}
	
	public void waitForTitle() {
	wait.until(ExpectedConditions.titleContains("Let's Shop"));
	}
}
