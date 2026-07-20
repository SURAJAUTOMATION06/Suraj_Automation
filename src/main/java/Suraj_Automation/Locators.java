package Suraj_Automation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class Locators {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//For the Web Driver Manager to manage the Driver.
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));/*This is an Implicit Wait method which is Used for the
                                                                            wait until the Element is appeared */
        //Object for the Chrome Driver
        driver.manage().window().maximize();//This is used to maximize the window.
        driver.get("http://192.168.27.140/COSEC/Login");// URL to open the Website
        //This is based on the ID locator for the Login page
        driver.findElement(By.id("loginid")).sendKeys("sa"); //This is used to find the locators and to send the Inputs in it.
        driver.findElement(By.id("pwd")).sendKeys("admin");
        driver.findElement(By.id("btnlogin")).click();//This line is used for the Button to click
        Thread.sleep(1000); //Thread sleep for the wait of 1 second for something to get in stable state
        //This is based on the CSS selector
        System.out.println(driver.findElement(By.cssSelector("#ValidationMsg")).getText());
        driver.findElement(By.linkText("Forgot Password?")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("#ValidationMsg")).getText());
        driver.findElement(By.id("loginid")).sendKeys("sa"); //This is used to find the locators and to send the Inputs in it.
        driver.findElement(By.id("pwd")).sendKeys("Admin@1");
        driver.findElement(By.id("btnlogin")).click();
        driver.findElement(By.xpath("//*[@id='Link_1']")).click();
        driver.findElement(By.xpath("//*[@id='System Configuration']")).click();
        driver.findElement(By.xpath("//*[@id='1003']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("li:nth-child(4) a:nth-child(1) label:nth-child(1)")).click();//With the Use css selector nth-child is user
        driver.findElement(By.xpath("//*[@title='Account Setting']")).click();//By the Use of Xpath
        driver.findElement(By.id("txtCurrPwd")).sendKeys("Admin@1");
        driver.findElement(By.id("txtNewPwd")).sendKeys("admin");
        driver.findElement(By.id("txtConfirmPwd")).sendKeys("admin");
        driver.findElement(By.xpath("(//input[@name='btnPwdChange'])")).click();
        driver.findElement(By.id("loginid")).sendKeys("sa"); //This is used to find the locators and to send the Inputs in it.
        driver.findElement(By.id("pwd")).sendKeys("admin");
        driver.findElement(By.id("btnlogin")).click();

        driver.quit();


    }

}
