import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		
		int rows =driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println("Total number of rows:" + rows);
		

	}

}
