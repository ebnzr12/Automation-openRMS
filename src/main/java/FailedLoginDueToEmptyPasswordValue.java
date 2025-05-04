import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FailedLoginDueToEmptyPasswordValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
          
            driver.get("https://o2.openmrs.org/openmrs/login.htm");
            driver.manage().window().maximize();

            WebElement usernameInput = driver.findElement(By.id("username"));
            usernameInput.sendKeys("admin");

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("");

            WebElement location = driver.findElement(By.id("Registration Desk"));
            location.click();

            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            Thread.sleep(3000);

            if (driver.getPageSource().contains("Logged in as")) {
                System.out.println("Login success!");
            } else {
                System.out.println("Login failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
