import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FailedLoginWithoutChooseLocation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
          
            driver.get("https://o2.openmrs.org/openmrs/login.htm");
            driver.manage().window().maximize();

            WebElement usernameInput = driver.findElement(By.id("username"));
            usernameInput.sendKeys("admin");

            WebElement passwordInput = driver.findElement(By.id("password"));
            passwordInput.sendKeys("Admin123");

            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            Thread.sleep(3000);

            if (driver.getPageSource().contains("You must choose a location!")) {
                System.out.println("Login failed.");
            } else {
                System.out.println("Result not Expected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
