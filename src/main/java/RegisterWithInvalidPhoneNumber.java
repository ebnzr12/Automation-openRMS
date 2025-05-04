import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterWithInvalidPhoneNumber {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String givenName = ("Retno");
        String middleName = ("Horai");
        String familyName = ("Hulahuli");
        int Day = (20);
        int Year = (2000);
        String address1 = ("Jl. Hang Lekir 2");
        String address2 = ("Rt 02/03 No.22");
        String City = ("Honduras City");
        String stateProvince = ("East Honduras");
        String Country = ("Honduras");
        int postalCode = (190199);
        String phoneNumber = ("009923Test");
        
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
            Thread.sleep(500);
            nextButton.click();
            
            WebElement inputAddress1 = driver.findElement(By.id("address1"));
            inputAddress1.sendKeys(address1);
            Thread.sleep(500);
            
            WebElement inputAddress2 = driver.findElement(By.id("address2"));
            inputAddress2.sendKeys(address2);
            Thread.sleep(500);
            
            WebElement inputCity = driver.findElement(By.id("cityVillage"));
            inputCity.sendKeys(City);
            Thread.sleep(500);
            
            WebElement inputProvince = driver.findElement(By.id("stateProvince"));
            inputProvince.sendKeys(stateProvince);
            Thread.sleep(500);
            
            WebElement inputCountry = driver.findElement(By.id("country"));
            inputCountry.sendKeys(Country);
            Thread.sleep(500);
            
            WebElement inputPostalCode = driver.findElement(By.id("postalCode"));
            inputPostalCode.sendKeys(String.valueOf(postalCode));
            Thread.sleep(500);
            nextButton.click();
            
            WebElement inputPhoneNumb = driver.findElement(By.name("phoneNumber"));
            inputPhoneNumb.sendKeys(String.valueOf(phoneNumber));
            Thread.sleep(500);
            nextButton.click();
            Thread.sleep(4000);
            
            
			
			   if (driver.getPageSource().contains("Must be a valid phone number")) { 
			  System.out.println("Must be filled with valid number phone"); } else { 
			  System.out.println("System has to make an error message"); }
		
        } catch (Exception e) {
            e.printStackTrace();
		} 
			  finally { driver.quit(); }
			 
    }
}
