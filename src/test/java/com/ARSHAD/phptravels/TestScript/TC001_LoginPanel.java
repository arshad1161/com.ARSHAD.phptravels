package com.ARSHAD.phptravels.TestScript;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ARSHAD.phptravels.base.TestBase;
import com.ARSHAD.phptravels.pages.login_page;
import com.ARSHAD.phptravels.util.read_excel;

public class TC001_LoginPanel extends TestBase
{
	login_page page;
	
	@BeforeTest
	public void setup()
	{
		browser_setup();
		page=new login_page();
	}
	
	@Test(priority = 1)
	public void validatetitle()
	{
		String title=page.verifytitle();
		Assert.assertEquals(title, "Supplier Login");
	}
	
	@Test(priority = 2,enabled = false)
	public void validatate_login()
	{
		page.verifylogin("supplier@phptravels.com", "demosupplier");
	}
	
	@Test(priority = 3,enabled =false,dataProvider = "s1")
	public void validate_login_exceldata(String username,String password)
	{
		page.usernametxtbx.sendKeys(username);
		page.passwordtxtbtx.sendKeys(password);
		page.loginbtn.click();
		page.logoutbtn.click();
	}
	public void validate_lo_exceldata() 
	{
		page.verify_login_exceldata(null, null);
	}
	
	
	

	@DataProvider(name = "s1")
	public Object[][] getexceldatata()
	{
		read_excel re=new read_excel("C:\\Users\\Admin\\eclipse-workspace\\com.ARSHAD.phptravels\\src\\main\\java\\com\\ARSHAD\\phptravels\\exceldata\\arshad.xlsx");
		int row=re.totalrows("Sheet1");
		int colimn=re.totalcolumns("Sheet1");
		Object[][] obj=new Object[row][colimn];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<colimn;j++)
			{
				obj[i][j]=re.GTDATA("Sheet1", i, j);
			}
			
		}
		return obj;
	}
}
