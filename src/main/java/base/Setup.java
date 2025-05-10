package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("noblehrc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("Login successfull");
		
		driver.findElement(By.linkText("Go To Organisation")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//h1[text()='Shifts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Add Shift']")).click();
		driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[2]")).sendKeys("office"+Keys.ENTER);
		driver.findElement(By.name("shiftName")).sendKeys("General Shift");
		driver.findElement(By.name("allowance")).sendKeys(Keys.BACK_SPACE+"10");
		driver.findElement(By.name("startDateTime")).sendKeys("10:00:AM");
		driver.findElement(By.name("endDateTime")).sendKeys("04:00:PM");
		driver.findElement(By.xpath("//button[text()='Mon']")).click();
		driver.findElement(By.xpath("//button[text()='Tus']")).click();
		driver.findElement(By.xpath("//button[text()='Wed']")).click();
		driver.findElement(By.xpath("//button[text()='Thur']")).click();
		driver.findElement(By.xpath("//button[text()='Fri']")).click();
		driver.findElement(By.xpath("//button[text()='Sat']")).click();
		driver.findElement(By.xpath("(//button[text()='Add Shift'])[2]")).click();
		
		
		// logout
		Thread.sleep(5000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
		
	}

}
