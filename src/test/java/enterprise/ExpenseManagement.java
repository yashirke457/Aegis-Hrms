package enterprise;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[1]"))).click();
        
//      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h1[text()='Expense Management'])[1]"))).click();
        By headerLocator = By.xpath("//h1[text()='Expense Management']");
        wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        wait.until(ExpectedConditions.elementToBeClickable(headerLocator)).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h1[text()='Expense Dashboard'])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Approvals']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='View Details'])[last()]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Expense Items'])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Approve'])[1]"))).click();

        WebElement reasonBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Enter reason...']")));
        reasonBox.sendKeys("Manager approval");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']"))).click();
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
    
//    public WebElement clickExpenseManagementTabWithRetry() throws InterruptedException {
//        int maxTries = 5;
//
//        for (int i = 0; i < maxTries; i++) {
//            try {
//                WebElement tab = driver.findElement(By.xpath("//span[text()='Expense Management']"));
//                if (tab.isDisplayed()) {
//                    tab.click();
//                    System.out.println("✅ 'Expense Management' tab clicked.");
//                    return tab;
//                }
//            } catch (NoSuchElementException | ElementNotInteractableException e) {
//                // Tab not visible yet, try clicking arrow
//                try {
//                    WebElement arrow = driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='KeyboardArrowRightIcon']"));
//                    if (arrow.isDisplayed()) {
//                        arrow.click();
//                        Thread.sleep(500); // wait for tabs to scroll
//                        System.out.println("↪️ Clicked right arrow to reveal more tabs.");
//                    }
//                } catch (NoSuchElementException ex) {
//                    System.out.println("❌ Arrow button not found or not visible.");
//                    break;
//                }
//            }
//        }
//
//        throw new NoSuchElementException("❌ 'Expense Management' tab not found even after scrolling.");
//    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
