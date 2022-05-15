package TestNG.Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
	
	WebDriver driver;
	
	
	@BeforeClass
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	
	@Test
	public void getTitle()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Target Practice");
	}
	
	@Test
	public void validatingBlackButton()
	{
		boolean stateofBlackButton = driver.findElement(By.xpath("//button[contains(text(),'Black')]")).isEnabled();
		Assert.assertEquals(stateofBlackButton, false);
	}
	
	@Test(enabled = false)
	public void skipMethod()
	{
		System.out.println("Method to be skipped but will not displayed as skipped");
	}
	
	@Test
	public void skippedMethodwithException() throws SkipException
	{
		throw new SkipException("Method will be skipped but will be shown as skipped");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
