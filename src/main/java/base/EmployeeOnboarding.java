package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeOnboarding {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://dev.aegishrms.com/sign-in");

		try {
			// login
			driver.findElement(By.name("email")).sendKeys("dev5.atsit@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@123");

//			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			System.out.println("Admin Login done successfully");

			driver.findElement(By.linkText("Go To Organisation")).click();
//			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
//			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//h1[text()='Employee']")).click();
			driver.findElement(By.linkText("Onboarding")).click();

			// First page
			
			// Data
			String name="Adesh";
			String lastName="User";
			String dob="06/25/2000";
			String email="adesh@edt.com";
			String contact="9565681758";
			String address="Pune";
			String adhar="458796325412";
			String pan="NYSWG1426D";
			String accountNo="827273";
			
			driver.findElement(By.name("first_name")).sendKeys(name);
			driver.findElement(By.name("last_name")).sendKeys(lastName);
			driver.findElement(By.name("date_of_birth")).sendKeys(dob);
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("phone_number")).sendKeys(contact);
			driver.findElement(By.name("address")).sendKeys(address);
			driver.findElement(By.xpath("//input[@value = 'male']")).click();
			driver.findElement(By.name("adhar_card_number")).sendKeys(adhar);
			driver.findElement(By.name("pan_card_number")).sendKeys(pan);
			driver.findElement(By.name("bank_account_no")).sendKeys(accountNo);
			driver.findElement(By.name("citizenship")).sendKeys("Indian");
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			Thread.sleep(3000);
			System.out.println("First page completed");

			// Second page

			//Data
			String empid="E-005";
			String companyEmail="edt@gmail.com";
			String joinDate="10/12/2023";
			String pass="Pass@123";
//			String role="hr";
			
			driver.findElement(By.name("empId")).sendKeys(empid);
			driver.findElement(By.name("companyemail")).sendKeys(companyEmail);
			driver.findElement(By.name("joining_date")).sendKeys(joinDate);

			// Department
			driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("it" + Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys(Keys.ENTER);
			driver.findElement(By.name("password")).sendKeys(pass);
			driver.findElement(By.name("confirmPassword")).sendKeys(pass);
			
//			// Manager
//			driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys("" + Keys.ARROW_DOWN);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys(Keys.ENTER);
			
//			// Select role
//			driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys(role + Keys.ARROW_DOWN);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).sendKeys(Keys.ENTER);
			

			// Designation
			driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).sendKeys("employee" + Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[5]")).sendKeys(Keys.ENTER);

//			// Shift
//			driver.findElement(By.xpath("(//input[@role='combobox'])[6]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@role='combobox'])[6]")).sendKeys("general" + Keys.ARROW_DOWN);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//input[@role='combobox'])[6]")).sendKeys(Keys.ENTER);

			// Department cost no
			driver.findElement(By.xpath("(//input[@role='combobox'])[7]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[7]")).sendKeys("001" + Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[7]")).sendKeys(Keys.ENTER);

			// Location
			driver.findElement(By.xpath("(//input[@role='combobox'])[8]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[8]")).sendKeys("pune" + Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[8]")).sendKeys(Keys.ENTER);

			// Employment type
			driver.findElement(By.xpath("(//input[@role='combobox'])[9]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[9]")).sendKeys("full" + Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[9]")).sendKeys(Keys.ENTER);

			// Salary template
			driver.findElement(By.xpath("(//input[@role='combobox'])[10]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[10]")).sendKeys("full" + Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@role='combobox'])[10]")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			Thread.sleep(3000);
			System.out.println("Second page completed");

			// Third page
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			Thread.sleep(3000);
			System.out.println("Third page completed");

			// Fourth page
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			Thread.sleep(5000);
			System.out.println("Employee Onboarding done successfully");

//			// Delete Employee
//			driver.findElement(By.xpath("//input[@placeholder='Search Employee']")).sendKeys(name+Keys.ENTER);
//			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='DeleteOutlineIcon']")).click();
//			driver.findElement(By.xpath("//button[text()='Delete']")).click();
//			Thread.sleep(3000);
//			System.out.println("Employee deleted successfully");

			// logout
			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Admin Logout done successfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Thread.sleep(3000);
			driver.quit();
		}

	}

}
