package base;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupPage {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://app.aegishrms.com/sign-in");
		
		try {
			driver.findElement(By.name("email")).sendKeys("noble@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@123");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			System.out.println("Login done successfully");

			driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
			driver.findElement(By.xpath("(//button[text()='Setup'])[2]")).click();

//			//creates leave
//			driver.findElement(By.linkText("Leaves")).click();
//			driver.findElement(By.xpath("//button[text()='Add Leave']")).click();
//			driver.findElement(By.name("leaveName")).sendKeys("Other");
//			driver.findElement(By.name("count")).sendKeys("5");
//			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			
//			//adds location error
//			driver.findElement(By.xpath("//h1[text()='Location']")).click();
//			driver.findElement(By.xpath("//button[text()='Add location']")).click();
//			driver.findElement(By.xpath("(//div[@class='css-1jqq78o-placeholder'])[1]")).sendKeys("Asia"+Keys.ENTER);
//			driver.findElement(By.id("react-select-12-placeholder")).sendKeys("India"+Keys.ARROW_DOWN+Keys.ENTER);
//			driver.findElement(By.id("react-select-14-input")).sendKeys("Pune"+Keys.ENTER);
//			driver.findElement(By.name("shortName")).sendKeys("Hadapsar");
//			driver.findElement(By.name("pinCode")).sendKeys("411014");
//			driver.findElement(By.name("addressLine1")).sendKeys("Pune");
//			driver.findElement(By.xpath("//button[text()='Add Location']")).click();
			
			//employment
			driver.findElement(By.xpath("//h1[text()='Employment']")).click();
			driver.findElement(By.xpath("//button[text()='Add Employment']")).click();
			Thread.sleep(1500);
			driver.findElement(By.name("title")).sendKeys("Full time");
			driver.findElement(By.xpath("//button[text()='Submit']"));
			
			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Logout done successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
