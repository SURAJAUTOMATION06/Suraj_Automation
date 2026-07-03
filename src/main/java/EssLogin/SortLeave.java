package EssLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.interactions.Actions;

public class SortLeave {

    public static void main(String[] args) throws InterruptedException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Step 3: Launch browser and perform automation
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        // Login
        for (int userNum = 5010; userNum <=5010; userNum++) {
            String username = "u" + userNum;
            driver.get("https://172.16.1.8/COSEC/Login");
            driver.findElement(By.id("loginid")).sendKeys("sa");
            driver.findElement(By.id("pwd")).sendKeys("admin");
            driver.findElement(By.id("btnlogin")).click();

            // Navigate to Short Leave
            driver.findElement(By.xpath("//a[@id='Link_3']")).click();
            driver.findElement(By.xpath("//a[text()='Short Leave/Official In-Out']")).click();

            // Loop over dates
            LocalDate startDate = LocalDate.of(2025, 5, 4);
            LocalDate endDate = LocalDate.of(2025, 5, 8);

            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {

                String formattedDate = date.format(formatter);

                WebElement enterDate = driver.findElement(By.xpath("//input[@title='Enter Date in DD/MM/YYYY Format']"));
                enterDate.click();
                enterDate.sendKeys(Keys.CONTROL + "a", Keys.DELETE); // Clear existing text
                enterDate.sendKeys(formattedDate);
                Thread.sleep(1000);

                // First Dropdown Special Function (ShortLeave OUT)
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement dropdown1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@ng-model='data.CboSpFn2.SelectedValue']")));
                wait.until(ExpectedConditions.visibilityOf(dropdown1));
                dropdown1.click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//option[text()='ShortLeave OUT']")).click();

                //Second Dropdown Special Function (ShortLeave IN)
                WebElement dropdown2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select[@ng-model='data.CboSpFn1.SelectedValue'])[2]")));
                wait.until(ExpectedConditions.visibilityOf(dropdown2));
                dropdown2.click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("(//option[text()='ShortLeave IN'])[2]")).click();

                // Save
                actions.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).perform();
                driver.findElement(By.xpath("//button[@id='btnSave']")).click();
                System.out.println("✅ Short Leave submitted for : " + formattedDate);
                Thread.sleep(1000);
            }
            driver.findElement(By.xpath("(//a[@class='btn btn-lg ng-isolate-scope'])[6]")).click();
        }
        driver.quit();
    }
}
