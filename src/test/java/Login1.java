import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login1 {

	
		
		@Test
		public void verifyLoginWithValidCredentials() {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.id("input-email")).sendKeys("ashutosh16122023@gmail.com");
			driver.findElement(By.id("input-password")).sendKeys("7798652341");
			driver.findElement(By.xpath("//input[@value='Login']")).click();)
			
		}

	}


