package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddNewDepartment {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://dev.aegishrms.com/sign-in");
		
		try {
			// login
			driver.findElement(By.name("email")).sendKeys("noblehrc@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@1234");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			System.out.println("Login successfull");

			driver.findElement(By.linkText("Go To Organisation")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//button[text()='Setup'])[2]")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//h1[text()='Department']")).click();
			driver.findElement(By.linkText("Add Department")).click();

			// first page
			driver.findElement(By.name("dept_name")).sendKeys("IT");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("Pune" + Keys.ENTER);
//			driver.findElement(By.name("dept_description"));
//			driver.findElement(By.xpath("//div[text()='Department Head']"));
//			driver.findElement(By.xpath("//div[text()='Delegate Department Head']"));
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			// second page
//			driver.findElement(By.name("dept_cost_center_name"));
//			driver.findElement(By.name("dept_cost_center_description"));
			driver.findElement(By.name("dept_id")).sendKeys("Phy-001");
			driver.findElement(By.name("dept_cost_center_id")).sendKeys("001");
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			System.out.println("Department added successfully");
			
//			//delete department
//			Thread.sleep(3000);
//			driver.findElement(By.xpath("(//button[@aria-label='delete'])[2]")).click();
//			Thread.sleep(1500);
//			driver.findElement(By.xpath("//button[text()='Delete']")).click();
//			System.out.println("Department deleted successfully");

			// logout
			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Logout successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		Thread.sleep(3000);
		driver.quit();
	}

}
