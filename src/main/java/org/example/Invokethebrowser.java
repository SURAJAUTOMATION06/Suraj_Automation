package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Invokethebrowser {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();



        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//*[@id='guide-button']")).click();
        driver.findElement(By.xpath("//*[@title='Subscriptions']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();

    }
}
