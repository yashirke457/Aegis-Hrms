package base;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewOrganization {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://app.aegishrms.com/sign-in");
		
		try {
			// login
			driver.findElement(By.name("email")).sendKeys("noble@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@123");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			System.out.println("Login successfull");

			driver.findElement(By.linkText("Go To Organisation")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[text()='Add Organisation']")).click();

			// add organization page 1
			driver.findElement(By.name("orgName")).sendKeys("Argan technology Services"); //name
//			driver.findElement(By.name("web_url")).sendKeys("www.basic.com"); //web url
			driver.findElement(By.name("foundation_date")).sendKeys("05/25/2000"); //foundation date
//			driver.findElement(By.name("organization_linkedin_url")).sendKeys("www.linkedin.basic.com"); //linkedin url
			driver.findElement(By.id("react-select-3-input")).click(); //type of industry
			driver.findElement(By.id("react-select-3-input")).sendKeys("technology" + Keys.ENTER);
			driver.findElement(By.name("email")).sendKeys("basicautomation@gmail.com"); //org email
			driver.findElement(By.name("contact_number")).sendKeys("9273879273"); //contact number
			driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("Wakad"); //location
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//label[text()='Do you want 7 day Trial']")).click(); //checkbox
//			driver.findElement(By.xpath("//button[contains(@class,'MuiButtonBase-root MuiButton')]")).click();
			Thread.sleep(2000);
			// page 2
			driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
			driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
//			driver.findElement(By.xpath("(//button[text()='Get Started'])[1]")).click();
			// page 3
			driver.findElement(By.name("count")).sendKeys("150");
			driver.findElement(By.name("cycleCount")).sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.name("cycleCount")).sendKeys("2" + Keys.TAB + "raz" + Keys.ENTER);
			driver.findElement(By.xpath("//button[text()='Confirm & Pay']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			System.out.println("Organization created successfully");
			
			//delete organization
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='MoreVertIcon'])[5]")).click();
			driver.findElement(By.xpath("//li[text()='Delete']")).click();
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
			Thread.sleep(5000);
			System.out.println("Organization deleted successfully");

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
