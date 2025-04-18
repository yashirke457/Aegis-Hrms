package enterprise;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import essential.BaseDriverSetup;

public class ExpenseManagement {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = BaseDriverSetup.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void completeExpenseManagementFlow() throws Exception {
        superAdminLoginAndNavigate();
        System.out.println("Admin login done successfully");
        navigateToExpenseCreation();
        fillExpenseReportDetails();
        submitExpenseReport();

        managerApprovalProcess();

        superAdminFinalApproval();
        System.out.println("Script ended=============");
    }

    private void superAdminLoginAndNavigate() throws InterruptedException {
        driver.get("https://qa.aegishrms.com/");
        login("qatest@gmail.com", "Pass@123");

        driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
        driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
    }

    private void navigateToExpenseCreation() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Management'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Dashboard'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='Create New']")).click();
    }

    private void fillExpenseReportDetails() throws InterruptedException {
        driver.findElement(By.name("reportDetails.reportName")).sendKeys("Casual Report");
        driver.findElement(By.name("reportDetails.reportDate")).sendKeys("1242025");

        driver.findElement(By.id("react-select-3-input")).click();
        driver.findElement(By.xpath("//div[text()='Other Expenses']")).click();

        driver.findElement(By.id("react-select-4-input")).click();
        driver.findElement(By.xpath("//div[text()='undefined undefined']")).click();
    }

    private void submitExpenseReport() throws InterruptedException, AWTException {
        driver.findElement(By.name("expenseName")).sendKeys("New Casual Expense");

        driver.findElement(By.id("react-select-5-input")).click();
        driver.findElement(By.xpath("//div[text()='Food']")).click();

        driver.findElement(By.name("amount")).sendKeys("1000");
        WebElement region = driver.findElement(By.name("region"));
        region.click();
        region.sendKeys("Dubai");
        region.sendKeys(Keys.TAB+""+Keys.TAB+"Lorem Ipsum");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[text()='Add Expense to Report']")).click();
        driver.findElement(By.xpath("//button[text()='Submit Report']")).click();
        Thread.sleep(1000);
    }

    private void managerApprovalProcess() throws InterruptedException {
        driver.quit(); // close super admin session
        setup(); // reinitialize driver
        driver.get("https://qa.aegishrms.com/");
        login("manager1@gmail.com", "Pass@123");

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='NotificationsIcon'])")).click();
        
        try {
            WebElement expenseTab = driver.findElement(By.xpath("//span[text()='Expense Management']"));
            if (expenseTab.isDisplayed()) {
                expenseTab.click();
                System.out.println("✅ 'Expense Management' tab clicked directly.");
            }
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("🔍 'Expense Management' tab not immediately visible, clicking arrow...");

            try {
                WebElement arrowButton = driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='KeyboardArrowRightIcon']"));
                if (arrowButton.isDisplayed()) {
                    arrowButton.click();
                    Thread.sleep(500); // Wait for scroll animation
                }
            } catch (NoSuchElementException ex) {
                System.out.println("❌ Arrow button not found. Cannot scroll to reveal the tab.");
            }

            // Retry finding and clicking the tab after scrolling
            try {
                WebElement expenseTab = driver.findElement(By.xpath("//span[text()='Expense Management']"));
                if (expenseTab.isDisplayed()) {
                    expenseTab.click();
                    System.out.println("✅ 'Expense Management' tab found after scrolling and clicked.");
                }
            } catch (NoSuchElementException | ElementNotInteractableException ex) {
                System.out.println("❌ 'Expense Management' tab still not visible after scrolling.");
                throw new NoSuchElementException("'Expense Management' tab not found after scrolling.");
            }
        }
        

        driver.findElement(By.xpath("(//div[@class='flex items-center gap-3'])[1]")).click();

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Management'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Dashboard'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='View Approvals']")).click();
        driver.findElement(By.xpath("(//button[text()='View Details'])[last()]")).click();

        driver.findElement(By.xpath("(//button[text()='Expense Items'])[1]")).click();
        driver.findElement(By.xpath("(//button[text()='Approve'])[1]")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Enter reason...']")).sendKeys("Manager approval");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    private void superAdminFinalApproval() throws InterruptedException {
        driver.quit(); // close manager session
        setup(); // reinitialize driver
        driver.get("https://qa.aegishrms.com/");
        login("qatest@gmail.com", "Pass@123");

        driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
        driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Management'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Dashboard'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='View Approvals']")).click();
        driver.findElement(By.xpath("(//button[text()='View Details'])[last()]")).click();
        driver.findElement(By.xpath("(//button[text()='Expense Items'])[1]")).click();
    }

    private void login(String email, String password) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
