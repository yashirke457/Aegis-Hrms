package genricUse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import essential.BaseDriverSetup;

public class EmployeeOnboarding {

	private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = BaseDriverSetup.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://app.aegishrms.com");
        System.out.println("=========================================================");
        System.out.println("â–¶ï¸� EMPLOYEE ONBOARDING");
    }

    @Test
    public void employeeOnboardingWorkflow() {
        try {
            login();
            navigateToOnboardingPage();
            fillFirstPageDetails();
            fillSecondPageDetails();
            completeThirdPage();
            submit();
            logout();

            System.out.println("=========================================================");
            System.out.println("âœ… EMPLOYEE ONBOARDING- PASSED");

        } catch (Exception e) {
        	System.out.println("â�Œ EMPLOYEE ONBOARDING- FAILED");
            System.out.println("ðŸ”� Error Message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void login() throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys("demo@aegis.com");
        driver.findElement(By.name("password")).sendKeys("Pass@123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        System.out.println("Admin Login done successfully");
    }

    private void navigateToOnboardingPage() throws InterruptedException {
        driver.findElement(By.linkText("Go To Organisation")).click();
        driver.findElement(By.xpath("(//button[text()='Setup'])[6]")).click();
        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h1[text()='Employee']")).click();
        driver.findElement(By.linkText("Onboarding")).click();
    }

    private void fillFirstPageDetails() throws InterruptedException {
        driver.findElement(By.name("first_name")).sendKeys("Employee");
        driver.findElement(By.name("last_name")).sendKeys("Three");
        driver.findElement(By.name("date_of_birth")).sendKeys("06/25/2000");
        driver.findElement(By.name("email")).sendKeys("emp3@amt.com");
        driver.findElement(By.name("phone_number")).sendKeys("9568471758");
        driver.findElement(By.name("address")).sendKeys("Pune");
        driver.findElement(By.xpath("//input[@value='female']")).click();
        driver.findElement(By.name("adhar_card_number")).sendKeys("111111111111");
        driver.findElement(By.name("pan_card_number")).sendKeys("NYSWG1426D");
        driver.findElement(By.name("bank_account_no")).sendKeys("827273");
        driver.findElement(By.name("citizenship")).sendKeys("UnitedKingdom");
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(3000);
        System.out.println("First page completed");
    }

    private void fillSecondPageDetails() throws InterruptedException {
        driver.findElement(By.name("empId")).sendKeys("AMT-0020");
        driver.findElement(By.name("companyemail")).sendKeys("asset@test.com");
        driver.findElement(By.name("joining_date")).sendKeys("01/01/2025");
        selectDropdown("(//input[@role='combobox'])[2]", "it");
        driver.findElement(By.name("password")).sendKeys("Pass@123");
        driver.findElement(By.name("confirmPassword")).sendKeys("Pass@123");
//        selectDropdown("(//input[@role='combobox'])[4]", "accountant");
        selectDropdown("(//input[@role='combobox'])[5]", "001");
        selectDropdown("(//input[@role='combobox'])[6]", "employee");
        selectDropdown("(//input[@role='combobox'])[9]", "full");
        selectDropdown("(//input[@role='combobox'])[10]", "full");
        selectDropdown("(//input[@role='combobox'])[8]", "pune");
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(3000);
        System.out.println("Second page completed");
    }

    private void completeThirdPage() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        Thread.sleep(3000);
        System.out.println("Third page completed");
    }

    private void submit() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        Thread.sleep(5000);
        System.out.println("Employee Onboarding done successfully");
    }

    private void logout() throws InterruptedException {
        driver.findElement(By.id("basic-button")).click();
        driver.findElement(By.xpath("//div[text()=' Log out']")).click();
        System.out.println("Admin Logout done successfully");
    }

    private void selectDropdown(String xpath, String value) throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath(xpath));
        dropdown.click();
        Thread.sleep(2000);
        dropdown.sendKeys(value + Keys.ARROW_DOWN);
        Thread.sleep(2000);
        dropdown.sendKeys(Keys.ENTER);
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000);
            System.out.println("=========================================================");
            driver.quit();
        }
    }
	
}
