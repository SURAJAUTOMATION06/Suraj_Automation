package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PasswordSet {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login steps
        driver.get("https://192.168.27.140/COSEC/Login");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.id("loginid")).sendKeys("sa");
        driver.findElement(By.id("pwd")).sendKeys("admin");
        driver.findElement(By.id("btnlogin")).click();
        driver.findElement(By.id("Link_7")).click();
        driver.findElement(By.xpath("//a[text()='Multi-User Options']")).click();
        driver.findElement(By.xpath("(//a[text()='User Configuration'])[2]")).click();
        driver.findElement(By.xpath("//select[@id='grpddl']")).click();
        driver.findElement(By.xpath("//button[@type='button'and @class=\"btn\"]")).click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"modal-content\"]//input[@name=\"cmnTxtSearch\"]")));
        driver.findElement(By.xpath("//*[@class=\"modal-content\"]//input[@name=\"cmnTxtSearch\"]"));
        for (int userNum = 1; userNum <= 100; userNum++) {
            String username = "u" + userNum;
            searchBox.clear();
            searchBox.sendKeys(username);
            searchBox.sendKeys(Keys.ENTER);
            try {
                driver.findElement(By.xpath("//input[@name=\"isMultiClick\"]")).click();
            } catch (Exception e) {
                System.out.println("User not found: " + username);
            }

        }
        driver.findElement(By.xpath("//input[@class=\"btn btn-sm btn-default btn-label-modal mx-input-theme\"]")).click();
        driver.findElement(By.xpath("//label[text()='ESS']")).click();
        driver.findElement(By.id("ChkSelUserACTEnbl")).click();
        driver.findElement(By.id("ChkUserACTEnbl")).click();
        driver.findElement(By.xpath("//input[@default='Update']")).click();
        String statusMsg = "//*[@id=\"message\"]//div[@class='overlay_success']";
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@class=\"progressbar_overlay\"]"))));
        String messageText = driver.findElement(By.xpath(statusMsg)).getText();

        if (messageText.contains("Process Completed")) {
            System.out.println("Process Completed");
        } else {
            System.out.println("Process Failed");
        }
        WebElement LogOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Logout']//i[@class='fa fa-power-off menuiconsize']")));
        LogOut.click();
        for (int userNum = 1; userNum <= 100; userNum++) {
            String username = "u" + userNum;
            driver.findElement(By.id("loginid")).sendKeys(username);
            driver.findElement(By.id("btnlogin")).click();

            WebElement NewPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtNewPassword")));
            NewPassword.sendKeys("admin");
            WebElement ConfirmPassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtConfirmNewPassword")));
            ConfirmPassword.sendKeys("admin");
            driver.findElement(By.id("btnOk")).click();
            Thread.sleep(1000);
            WebDriverManager.chromedriver().setup();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Loop over each user from User 10018 to User 10037
              //11008, 12, 15 from 8th

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                try {

                    // Login
                    driver.get("http://192.168.27.140/COSEC/Login");
                    driver.findElement(By.id("loginid")).sendKeys(username);
                    driver.findElement(By.id("pwd")).sendKeys("admin");
                    driver.findElement(By.id("btnlogin")).click();
                    // Navigate to Attendance Correction Page
                    driver.findElement(By.xpath("//a[@id='Time Attendance']")).click();
                    driver.findElement(By.xpath("//a[text()='Attendance Correction']")).click();
                    // Loop over dates
                    LocalDate startDate = LocalDate.of(2025, 5, 3);
                    LocalDate endDate = LocalDate.of(2025, 5, 8);

                    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                        String formattedDate = date.format(formatter);

                        WebElement enterDate = driver.findElement(By.xpath("//input[@title='Enter Date in DD/MM/YYYY Format']"));
                        enterDate.click();
                        enterDate.sendKeys(Keys.CONTROL + "a", Keys.DELETE); // Clear existing text
                        enterDate.sendKeys(formattedDate);

                        WebElement punch1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@key='Punch1T']")));
                        punch1.click();
                        punch1.sendKeys("09:00");

                        WebElement punch2 = driver.findElement(By.xpath("//input[@key='Punch2T']"));
                        punch2.click();
                        punch2.sendKeys("10:00");

                        WebElement punch3 = driver.findElement(By.xpath("(//div[@class='col-md-5 col-sm-5']//input[@name='Punch1T'])[2]"));
                        punch3.click();
                        punch3.sendKeys("11:00");

                        WebElement punch4 = driver.findElement(By.xpath("(//div[@class='col-md-5 col-sm-5 ']//input[@name='Punch2T'])[2]"));
                        punch4.click();
                        punch4.sendKeys("18:00");

                        driver.findElement(By.xpath("//button[@id='btnSave']")).click();

                        System.out.println("✅ Attendance submitted for " + username + " on " + formattedDate);
                    }

                } catch (Exception e) {
                    System.out.println("❌ Error for User " + userNum + ": " + e.getMessage());
                }

        }

    }
}
