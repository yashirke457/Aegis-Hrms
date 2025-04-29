package basic;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import essential.BaseDriverSetup;

public class IncomeTaxTds {
	
	 private WebDriver driver;
	 
	 
	    @BeforeClass
	    public void setup() {
	        driver = BaseDriverSetup.getDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	        driver.get("https://app.aegishrms.com/sign-in");
	        System.out.println("=========================================================");
	        System.out.println("▶️ INCOME TAX TDS WORKFLOW");
	    }

	    @Test
		public void incomeTaxFlow() throws InterruptedException {

//			try {
//				login("automationscripts@gmail.com", "Pass@123");
//				manageSalary("154000", "24610", "8450", "0", "0", "0", "200");
				viewEmployeeTds();
				viewTdsInSalarySlip();
				System.out.println("=========================================================");
				System.out.println("✅ INCOME TAX TDS WORKFLOW- PASSED");

//			} catch (Exception e) {
//				System.out.println("❌ INCOME TAX TDS WORKFLOW- FAILED");
//				System.out.println("🔍 Error Message: " + e.getMessage());
//				e.printStackTrace();  // For detailed stack trace
//	            Assert.fail("Test failed due to exception: " + e.getMessage());
//			}
		}
	    
	    public void manageSalary(String basic, String hra, String da, String specialAllowance, String pf, String esic, String tax) throws InterruptedException {
	        System.out.println("Super admin login");
	        Thread.sleep(2000);
	        driver.findElement(By.linkText("Go To Organisation")).click();
	        driver.findElement(By.xpath("(//button[text()='Setup'])[2]")).click();
	        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
	        driver.findElement(By.linkText("Salary Management")).click();
	        
	        driver.findElement(By.xpath("//input[@placeholder='Search Employee']")).sendKeys("tds" + Keys.ENTER);
	        driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
	        driver.findElement(By.xpath("//li[text()='Manage Salary']")).click();
	        // Clear and update salary fields
	        driver.findElement(By.name("Basic")).sendKeys(Keys.CONTROL + "a");
	        driver.findElement(By.name("Basic")).sendKeys(Keys.BACK_SPACE);
	        driver.findElement(By.name("Basic")).sendKeys(basic + Keys.TAB + hra + Keys.TAB + da + Keys.TAB + specialAllowance 
	                + Keys.TAB + pf + Keys.TAB + esic + Keys.TAB + tax);
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();
	        Thread.sleep(2000);
	        logout();
	        
	    }
	    
	    public void viewEmployeeTds() throws InterruptedException {
	    	login("employee@tds.com", "Pass@123");
	    	System.out.println(driver.getPageSource());
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.alertIsPresent());
	    	
	    	Alert alert=driver.switchTo().alert();
	    	alert.accept();
	    	
	    	driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
	        driver.findElement(By.linkText("Income Tax")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//button[text()='TDS calculation']")).click();
	        driver.findElement(By.xpath("(//input[@role='combobox'])[2]")).sendKeys("2024-2025"+Keys.ENTER);
	        driver.findElement(By.xpath("//button[text()='Investment Proofs']")).click();
	        createDeclarartion();
	        logout();
	    }
	    
	    public void createDeclarartion() throws InterruptedException {
	    	driver.findElement(By.xpath("//button[text()='Create Declaration']")).click();
	    	driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).click();
	    	driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys("salary"+ Keys.ENTER);
	    	driver.findElement(By.xpath("(//input[@role='combobox'])[4]")).click();
	    	driver.findElement(By.xpath("(//input[@role='combobox'])[3]")).sendKeys("transport"+ Keys.ENTER);
	    	driver.findElement(By.name("declaration")).sendKeys("481450");
	    	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	    	Thread.sleep(2000);
	    	System.out.println("");
	    	driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='DeleteOutlinedIcon']")).click();
	    	driver.findElement(By.xpath("//button[text()='Delete']")).click();
	    }
	    
	    public void viewTdsInSalarySlip() throws InterruptedException {
	    	login("automationscripts@gmail.com","Pass@123");
	    	
	    	System.out.println("Super admin login");
	        Thread.sleep(2000);
	        driver.findElement(By.linkText("Go To Organisation")).click();
	        driver.findElement(By.xpath("(//button[text()='Setup'])[2]")).click();
	        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
	        driver.findElement(By.linkText("Salary Management")).click();
	        
	        driver.findElement(By.xpath("//input[@placeholder='Search Employee']")).sendKeys("tds" + Keys.ENTER);
	        driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
	        driver.findElement(By.xpath("//li[text()='Calculate Salary']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@type='month']")).sendKeys(Keys.ARROW_DOWN);
	        Thread.sleep(3000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        driver.findElement(By.xpath("//button[text()='Download PDF']")).click();
	        Thread.sleep(10000);
	    }
	    
	    private void login(String email, String password) throws InterruptedException {
	        Thread.sleep(2000);
	        driver.findElement(By.id("email")).sendKeys(email);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.xpath("//button[text()='Login']")).click();
	    }

	    private void logout() throws InterruptedException {
	        Thread.sleep(2000);
	        driver.findElement(By.id("basic-button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[text()=' Log out']")).click();
	        
	    }
	    
	    @AfterClass
	    public void teardown() throws InterruptedException {
	        if (driver != null) {
	            Thread.sleep(3000); // Ensure any lingering tasks are completed
	            System.out.println("=========================================================");
	            driver.quit();
	        }
	    }

}
