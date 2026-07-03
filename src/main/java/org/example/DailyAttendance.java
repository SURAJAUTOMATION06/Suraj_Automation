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

public class DailyAttendance {       //Overtime/C-OFF is also done via this script

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Loop over each user from User 10018 to User 10037
        for (int userNum = 5011; userNum <= 5015; userNum++) {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            try {
                String username = "u" + userNum;

                // Login
                driver.get("http://192.168.27.127/COSEC/Login");
                driver.findElement(By.id("loginid")).sendKeys(username);
                driver.findElement(By.id("pwd")).sendKeys("admin");
                driver.findElement(By.id("btnlogin")).click();

                // Navigate to Attendance Correction Page
                driver.findElement(By.xpath("//a[@id='Time Attendance']")).click();
                driver.findElement(By.xpath("//a[text()='Attendance Correction']")).click();

                // Loop over dates
                LocalDate startDate = LocalDate.of(2025, 5, 10);
                LocalDate endDate = LocalDate.of(2025, 5, 15);

                for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                    String formattedDate = date.format(formatter);

                    WebElement enterDate = driver.findElement(By.xpath("//input[@title='Enter Date in DD/MM/YYYY Format']"));
                    enterDate.click();
                    enterDate.sendKeys(Keys.CONTROL + "a", Keys.DELETE); // Clear existing text
                    enterDate.sendKeys(formattedDate);

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                    WebElement punch1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='col-md-5 col-sm-5'])[1]//input")));
                    punch1.click();
                    punch1.sendKeys("09:00");

                    WebElement punch2 = driver.findElement(By.xpath("(//div[@class='col-md-5 col-sm-5 ']//input[@name='Punch2T'])[1]"));
                    punch2.click();
                    punch2.sendKeys("18:00");

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

