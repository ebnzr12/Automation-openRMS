import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class SearchPatientByFullName {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver if not using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String FullName = "kanak kumari kanak";
                
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
                
                WebElement searchBox = driver.findElement(By.id("patient-search"));
                searchBox.sendKeys(FullName);

            
                List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));

                boolean found = false;

                for (WebElement row : rows) {
                    if (row.getText().contains(FullName)) {
                        found = true;
                        System.out.println(FullName + " found in search results.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println(FullName + " not found in search results.");
                }
                
           
    }
}
