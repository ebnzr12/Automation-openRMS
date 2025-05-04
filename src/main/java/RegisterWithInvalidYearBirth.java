import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterWithInvalidYearBirth {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String givenName = ("Ratni");
        String middleName = ("Hore");
        String familyName = ("Hulahup");
        String Day = ("20");
        String Year = ("20aa");    
       
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
            
            Select patientGender =new Select(driver.findElement(By.id("gender-field")));
            patientGender.selectByVisibleText("Female");            
            nextButton.click();
            
            WebElement dayBirth = driver.findElement(By.id("birthdateDay-field"));
            dayBirth.sendKeys(String.valueOf(Day));
            Thread.sleep(500);
            
            Select monthBirth =new Select(driver.findElement(By.id("birthdateMonth-field")));
            monthBirth.selectByValue("10");
            Thread.sleep(500);
            
            WebElement yearBirth = driver.findElement(By.id("birthdateYear-field"));
            yearBirth.sendKeys(String.valueOf(Year));
            nextButton.click();
            Thread.sleep(3500);
            
			
			   if (driver.getPageSource().contains("Must be a number")) { 
			  System.out.println("The field must filled with number"); } else { 
			  System.out.println("System has to make an error message"); }
		
        } catch (Exception e) {
            e.printStackTrace();
		} 
			  finally { driver.quit(); }
			 
    }
}
