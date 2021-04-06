package com.ARSHAD.phptravels.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ARSHAD.phptravels.util.utility_methods;

public class TestBase
{
	FileInputStream fis;
	public Properties pro;
	public static WebDriver driver;
	
public TestBase()
{
	try 
	{
	fis=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\com.ARSHAD.phptravels\\src\\main\\java\\com\\ARSHAD\\phptravels\\cofig\\Configuration.properties");
	pro=new Properties();
	pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
}
public void browser_setup()
{
	String browsername=pro.getProperty("browser");
	if(browsername.equalsIgnoreCase("CHROME"))
	{
		System.setProperty("webdriver.chrome.driver", pro.getProperty("chromepath"));
		driver=new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("FIREFOX"))
	{
		System.setProperty("webdriver.gecko.driver", pro.getProperty("geckopath"));
		driver=new FirefoxDriver();
	}
	else if(browsername.equalsIgnoreCase("EDGE"))
	{
		System.setProperty("webdriver.edge.driver", pro.getProperty("edgepath"));
		driver=new EdgeDriver();
	}
	driver.get(pro.getProperty("url"));
	utility_methods.max_window();
	utility_methods.implicitywait(20);

	
	
	
}
	

}
