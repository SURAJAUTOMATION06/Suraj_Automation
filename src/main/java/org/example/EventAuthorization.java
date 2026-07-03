package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EventAuthorization {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Loop over each user from User 10018 to User 10037
        for (int userNum = 5021; userNum <= 5025; userNum++) {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String username = "u" + userNum;

            driver.get("http://192.168.27.127/COSEC/Login");
            driver.findElement(By.id("loginid")).sendKeys(username);
            driver.findElement(By.id("pwd")).sendKeys("admin");
            driver.findElement(By.id("btnlogin")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement markPunch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-4 col-sm-3 popMarkPunchIn']")));
            markPunch.click();

            for (int i = 0; i < 5; i++) {  // Loop 5 times

                WebElement regularIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//label[text()='Regular IN']")));
                regularIn.click();

                WebElement okClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnPunchConfirmOK']")));
                okClick.click();

                Thread.sleep(1000); // Optional delay between clicks
            }
            driver.findElement(By.xpath("//a[@title='Logout']")).click();
            Thread.sleep(1000);
        }
        driver.quit();
    }

}
