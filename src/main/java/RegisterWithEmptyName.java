import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterWithEmptyName {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String givenName = ("");
        String middleName = ("");
        String familyName = ("");
        
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
            
            WebElement registerButton = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
            registerButton.click();
            
            WebElement inputGivenName = driver.findElement(By.name("givenName"));
            inputGivenName.sendKeys(givenName);
            Thread.sleep(500);
            
            WebElement inputMiddleName = driver.findElement(By.name("middleName"));
            inputMiddleName.sendKeys(middleName);
            Thread.sleep(500);
            
            WebElement inputFamilyName = driver.findElement(By.name("familyName"));
            inputFamilyName.sendKeys(familyName);
            Thread.sleep(500);
            
            WebElement nextButton = driver.findElement(By.id("next-button"));
            nextButton.click();
            
			
			   if (driver.getPageSource().contains(givenName)) { 
			  System.out.println("Field must be filled"); } else { 
			  System.out.println("This should be has an error message"); }
		
        } catch (Exception e) {
            e.printStackTrace();
		} 
			  //finally { driver.quit(); }
			 
    }
}
