package TestNG.Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

    private WebDriver driver;



    @BeforeClass
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net");
    }

    @Test
    public void act1()
    {
        Assert.assertEquals(driver.getTitle(),"Training Support");

        driver.findElement(By.id("about-link")).click();
        Assert.assertEquals(driver.getTitle(),"About Training Support");
    }



    @AfterClass
    public void tearDown()
    {
        driver.close();
    }

}
