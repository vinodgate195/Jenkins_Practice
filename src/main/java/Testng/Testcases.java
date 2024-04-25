package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testcases {
WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
    public void launchbrowser(String browser)
    
    {
		
		if (browser.equalsIgnoreCase("chrome"))
		{	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Chromedrier\\chromedriver-win64\\chromedriver.exe");
		driver =new ChromeDriver();	
		}
		
		
		
		else if (browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\Desktop\\Chromedrier\\Edgedriver\\msedgedriver.exe");

			driver =new EdgeDriver();	
			
		}	
		
		driver.get("https://www.facebook.com/login/");
    }
	@Parameters("title")
	@Test
    public void GetTitle(String fbtitle)
    
    {
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, fbtitle);
    }
	
	
	@Test
    public void Getcurrenturl()
    
    {
		String url=driver.getCurrentUrl();
		
		Assert.assertEquals(url, "https://www.facebook.com/login/");
    
    }
	@AfterMethod
    public void close()
    
    {
			
    driver.close();
    }
}
