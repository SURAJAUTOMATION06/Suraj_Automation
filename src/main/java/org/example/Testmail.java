package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testmail {

    public static void main(String[] args) {

        // Launch Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {

            // Open Application
            driver.manage().window().maximize();

            driver.get("http://192.168.27.140/COSECadmin/Login");

            // =========================
            // LOGIN FUNCTIONALITY
            // =========================
            driver.findElement(By.id("loginid")).sendKeys("sa");

            driver.findElement(By.id("pwd")).sendKeys("admin");

            driver.findElement(By.id("btnlogin")).click();

            Thread.sleep(2000);

            // =========================
            // HOVER ON SETTING MODULE
            // =========================
            WebElement element =
                    driver.findElement(By.xpath("//*[@title='Setting']"));

            // Create Actions object
            Actions actions = new Actions(driver);

            // Perform hover action
            actions.moveToElement(element).perform();

            Thread.sleep(3000);

            // =========================
            // OPEN SYSTEM CONFIGURATION
            // =========================
            driver.findElement(
                            By.xpath("//a[normalize-space()='System Configuration']"))
                    .click();

            // =========================
            // OPEN MAIL CONFIGURATION PAGE
            // =========================
            driver.findElement(
                            By.xpath("//div[@class='wrapper']//li[5]//a[1]"))
                    .click();

            Thread.sleep(5000);

            // =========================
            // ENTER EMAIL
            // =========================
            driver.findElement(By.id("txtEmail"))
                    .sendKeys("suraj.pawar@matrixcomsec.com");

            // =========================
            // SEND TEST MAIL
            // =========================
            for (int i = 1; i <= 10000; i++) {

                driver.findElement(
                                By.xpath("//img[@title='Send Test Mail']"))
                        .click();

                System.out.println("Mail Sent Count : " + i);

                // Wait after each click
                Thread.sleep(2000);

                // Wait for 15 seconds after every 10 clicks
                if (i % 10 == 0) {

                    System.out.println(
                            "10 clicks completed. Waiting for 35 seconds...");

                    Thread.sleep(35000);
                }
            }

            System.out.println("All mails triggered successfully.");

        }
        catch (Exception e) {

            System.out.println("Exception Occurred:");


        }
        finally {

            // Close Browser
            driver.quit();
        }
    }
}
