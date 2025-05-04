import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateToTheNextPageOfThePatientList {
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

            WebElement location = driver.findElement(By.id("Registration Desk"));
            location.click();

            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            WebElement ClickFindPatientRecord = driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
            ClickFindPatientRecord.click();
            
            WebElement ClickNextPage = driver.findElement(By.id("patient-search-results-table_next"));
            ClickNextPage.click();
            
            Thread.sleep(3000);

            if (driver.getPageSource().contains("Showing 16 to 30 of 39 entries")) {
                System.out.println("Find Patient Records Next Page Opened.");
            } else {
                System.out.println("Find Patient Record Page Failed to Open.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
