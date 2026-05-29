import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login2 {
	@Test
	public void verifyLoginWithValidCredentials() {

		WebDriver driver = new ChromeDriver();

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

	    driver.get("https://tutorialsninja.com/demo/");

	    driver.findElement(By.xpath("//span[text()='My Account']")).click();

	    driver.findElement(By.linkText("Login")).click();

	    driver.findElement(By.id("input-email"))
	          .sendKeys("ashutosh16122023@gmail.com");

	    driver.findElement(By.id("input-password"))
	          .sendKeys("7798652341");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//input[@value='Login']")))
	        .click();
	    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit your account information message is not displayed");
	    driver.quit();
	}
	
	@Test
	public void loginWithInvalidCredentials() {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();

	    driver.findElement(By.linkText("Login")).click();

	    driver.findElement(By.id("input-email")) .sendKeys("ashutosh16122023"+generateTimeStamp()+"@gmail.com");

	    driver.findElement(By.id("input-password")) .sendKeys("7798652341");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//input[@value='Login']"))) .click();
	    String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	    String expectedWarningMessage="Warning: No match for E-Mail Address and/or Password.";
	    Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
	    driver.quit();
	  	
	}
	
	      public String generateTimeStamp() {
	    	  Date date= new Date();
	    	  return date.toString().replace(" ", "_").replace(":", "_");
		
	}

}
