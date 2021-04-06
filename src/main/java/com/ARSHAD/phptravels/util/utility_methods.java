package com.ARSHAD.phptravels.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ARSHAD.phptravels.base.TestBase;

public class utility_methods extends TestBase
{
	public static void implicitywait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void explicitywait(int time,By waitpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(waitpath));
	}
	
	public static void max_window()
	{
		driver.manage().window().maximize();
	}
	
	public static void selectbyvalue(WebElement ele,String val)
	{
		Select sel=new Select(ele);
		sel.selectByValue(val);
	}
	

}
