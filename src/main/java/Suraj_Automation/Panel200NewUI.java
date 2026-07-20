package Suraj_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Panel200NewUI {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//For the Web Driver Manager to manage the Driver.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();//This is used to maximize the window.
        driver.get("http://192.168.111.193/home.html");
        driver.findElement(By.id("standAloneUsername")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("chRempass")).click();
        driver.findElement(By.id("btnlogin")).click();
        driver.findElement(By.id("configuration")).click();
        Thread.sleep(4000);
        driver.switchTo().frame("app-frame");
        Thread.sleep(3000);
        WebElement ab = driver.findElement(By.cssSelector("#accordion #panelConfigHeaderli"));
        Actions ac = new Actions(driver);
        ac.moveToElement(ab).build().perform();
        driver.close();



    }
}
