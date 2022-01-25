import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void sendFiveDigitsToZipCodeFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check that 'Register' button is shown
        boolean isRegisterButtonIsDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterButtonIsDisplayed, "Register button isn't shown");
    }

    @Test
    public void sendFourDigitsToZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 4 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("1234");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check error message is shown
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Error message isn't show");
    }

    //***************************Exception**********************************
    @Test
    public void sendSixDigitsToZipCodeTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 6 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("123456");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Check error message is shown
        try {
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        } catch (Exception e) {
            Assert.assertTrue(false, "Bug!!!  ZIP code should have 5 digits");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void sendSignUpFormTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Andrew");
        driver.findElement(By.name("last_name")).sendKeys("Kremenevskiy");
        driver.findElement(By.name("email")).sendKeys("andrewkremenevskiy@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Check message 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success message isn't shown");
    }

    @Test
    public void registrationAllEmptyFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Invalid fields");
    }

    @Test
    public void checkFirstNameFieldTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Kremenevskiy");
        driver.findElement(By.name("email")).sendKeys("andrewkremenevskiy@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Invalid field 'First Name'");
    }

    @Test
    public void checkLastNameFieldTest() {
        //field 'Last Name' is not mandatory
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Andrew");
        driver.findElement(By.name("last_name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("andrewkremenevskiy@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user is created an account
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success message isn't shown");
    }

    @Test
    public void registrationWithInvalidEmailTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Andrew");
        driver.findElement(By.name("last_name")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("ds2@a");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Invalid field 'Email'");
    }

    @Test
    public void passAreNotMatchTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Andrew");
        driver.findElement(By.name("last_name")).sendKeys("Kremenevskiy");
        driver.findElement(By.name("email")).sendKeys("andrewkremenevskiy@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("12346");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        try {
            boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        } catch (Exception e) {
            Assert.assertTrue(false, "Bug!!! 'Password' and 'Confirm password' fields must match. Registration must not occur");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void inputSpecialCharactersIntoFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("$#%$*");
        driver.findElement(By.name("last_name")).sendKeys("^^((#");
        driver.findElement(By.name("email")).sendKeys("&^%#");
        driver.findElement(By.name("password1")).sendKeys("$%##$");
        driver.findElement(By.name("password2")).sendKeys("$%#$%");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Invalid fields");
    }

    @Test
    public void inputPasswordWithoutSymbolsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Andrew");
        driver.findElement(By.name("last_name")).sendKeys("Kremenevskiy");
        driver.findElement(By.name("email")).sendKeys("andrewkremenevskiy@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("12345");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Invalid field 'Password");
    }

    @Test
    public void inputConfirmPasswordWithoutSymbolsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("Andrew");
        driver.findElement(By.name("last_name")).sendKeys("Kremenevskiy");
        driver.findElement(By.name("email")).sendKeys("andrewkremenevskiy@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Verify that user isn't created an account
        boolean isErrorMessageShown = driver.findElement(By.className("error_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageShown, "Invalid field 'Confirm Password'");
    }

    @Test
    public void inputUpperCaseIntoFieldsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Open Zip code page
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //Input 5 digits zip
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        //Click the 'Continue'
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        //Input data into fields
        driver.findElement(By.name("first_name")).sendKeys("ANDREW");
        driver.findElement(By.name("last_name")).sendKeys("KREMENEVSKIY");
        driver.findElement(By.name("email")).sendKeys("ANDREWKREMENEVSKIY@GMAIL.COM");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        //Click 'Register' button
        driver.findElement(By.cssSelector("[value=Register")).click();
        //Check message 'Account is created'
        boolean isSuccessMessageShown = driver.findElement(By.className("confirmation_message")).isDisplayed();
        driver.quit();
        Assert.assertTrue(isSuccessMessageShown, "Success message isn't shown");
    }
}
