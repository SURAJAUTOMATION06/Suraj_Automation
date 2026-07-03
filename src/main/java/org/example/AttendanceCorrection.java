package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AttendanceCorrection {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Loop over each user from User 10018 to User 10037
        for (int userNum = 5008; userNum <= 5010; userNum++) {   //11008, 12, 15 from 8th
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            try {
                String username = "u" + userNum;

                // Login
                driver.get("https://192.168.27.140" +
                        "/COSEC/Login");
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

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
                    Thread.sleep(2000); // Wait after each submission
                }

            } catch (Exception e) {
                System.out.println("❌ Error for User " + userNum + ": " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
    }
}
