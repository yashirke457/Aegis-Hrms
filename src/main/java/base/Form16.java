package base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form16 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		
		try {
			driver.findElement(By.name("email")).sendKeys("autotest@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			System.out.println("Admin Login done successfully");

			driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
			driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();

			
			driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
			driver.findElement(By.xpath("//h1[text()='Form-16']")).click();
			
			String filePath="C:\\Users\\Yashsh\\Downloads\\form_16_part_a_sample.pdf";
			
			//uploads form 16
			driver.findElement(By.xpath("//input[@placeholder='Search Employee Name....']")).sendKeys("payal"+Keys.ENTER);
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
			driver.findElement(By.xpath("//li[text()='upload form 16']")).click();
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
			driver.findElement(By.xpath("//button[text()='Upload Form 16']")).click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert message :"+ alert.getText());
			alert.accept();
			System.out.println("Form 16 file uploaded successfully");
			Thread.sleep(5000);
			
			//deletes form 16 for uploaded employee
			driver.findElement(By.xpath("//input[@placeholder='Search Employee Name....']")).sendKeys("payal"+Keys.ENTER);
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
			driver.findElement(By.xpath("//li[text()='Delete form 16']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Delete Form 16']")).click();
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			System.out.println("Form 16 file deleted successfully");
			
			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Admin Logout done successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}
	
}
