package com.ARSHAD.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ARSHAD.phptravels.base.TestBase;

public class login_page extends TestBase
{
	@FindBy(xpath="//strong[text()='Login Panel']")
	WebElement loginheadline;
	
	@FindBy(name="email")
	public WebElement usernametxtbx;
	
	@FindBy(name="password")
	public WebElement passwordtxtbtx;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginbtn;
	
	@FindBy(xpath="//strong[text()='Forget Password']")
	WebElement forgotpass;
	
	@FindBy(xpath="//strong[text()=' Logout']")
	public WebElement logoutbtn;
	
public login_page()
{
	PageFactory.initElements(driver, this);
}

public String verifytitle()
{
	return driver.getTitle();
}

public String verifyURL()
{
	return driver.getCurrentUrl();
}

public void verifylogin(String username,String password)
{
	usernametxtbx.sendKeys(username);
	passwordtxtbtx.sendKeys(password);
	loginbtn.click();
	logoutbtn.click();
}
public void verify_login_exceldata(String username,String password)
{
	usernametxtbx.sendKeys(username);
	passwordtxtbtx.sendKeys(password);
	loginbtn.click();
	logoutbtn.click();
}
	

}
