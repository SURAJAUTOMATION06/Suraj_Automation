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

public class AdvanceOvertime {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        WebDriver driver = new ChromeDriver();

        // Loop over each user from User 10018 to User 10037
        for (int userNum = 5020; userNum <= 5020; userNum++) {

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String username = "u" + userNum;

                // Login
                driver.get("http://192.168.27.127/COSEC/Login");
                driver.findElement(By.id("loginid")).sendKeys(username);
                driver.findElement(By.id("pwd")).sendKeys("admin");
                driver.findElement(By.id("btnlogin")).click();

                // Navigate to Attendance Correction Page
                driver.findElement(By.xpath("//a[@id='Time Attendance']")).click();
                driver.findElement(By.xpath("//a[text()='Advance Overtime Application']")).click();

                driver.findElement(By.xpath("//div[@class='dml-btn']//button[@title='New (Alt+N)']")).click();

                // Loop over dates
                LocalDate startDate = LocalDate.of(2025, 6, 5);
                LocalDate endDate = LocalDate.of(2025, 6, 10);

                for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {

                    String formattedDate = date.format(formatter);
                    WebElement enterDate = driver.findElement(By.xpath("//input[@title='Enter Date in DD/MM/YYYY Format']"));
                    Thread.sleep(1000);
                    enterDate.click();
                    enterDate.sendKeys(Keys.CONTROL + "a", Keys.DELETE); // Clear existing text
                    enterDate.sendKeys(formattedDate);

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                    WebElement AddOt_Hour = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='txtOTHrs']")));
                    AddOt_Hour.sendKeys("01:00");

                    driver.findElement(By.xpath("//input[@id='btnSave']")).click();
                    Thread.sleep(2000);

                    driver.findElement(By.xpath("//div[@class='dml-btn']//button[@title='New (Alt+N)']")).click();

                    System.out.println("✅ Advanced Overtime submitted for " + username + " on " + formattedDate);
                     //Wait after each submission
                    Thread.sleep(1000);
                }

                driver.findElement(By.xpath("//a[@default='Logout']")).click();
        }

        driver.quit();
    }
}


