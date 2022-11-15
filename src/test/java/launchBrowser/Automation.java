package launchBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation {

		public static void main(String[] args) throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://tek-retail-ui.azurewebsites.net/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        Thread.sleep(3000);
	        WebElement signInBttn = driver.findElement(By.xpath("//button[@id='signinBtn']"));
	        signInBttn.click();
	        Thread.sleep(3000);
	        WebElement createNewAcct = driver.findElement(By.xpath("//button[@class='login__account-btn']"));
	        createNewAcct.click();
	        Thread.sleep(3000);
	        WebElement name = driver.findElement(By.xpath("//input[@id='nameInput']"));
	        name.sendKeys("Salim Mohmand");
	        Thread.sleep(3000);
	        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
	        //make sure to user different email address when you are running this code
	        email.sendKeys("Salim22@gmail.com");
	        Thread.sleep(3000);
	        WebElement password = driver.findElement(By.xpath("//input[@id='passwordInput']"));
	        password.sendKeys("Salim22@gmail.com");
	        Thread.sleep(3000);
	        WebElement confirmPass = driver.findElement(By.xpath("//input[@id='confirmPasswordInput']"));
	        confirmPass.sendKeys("Salim22@gmail.com");
	        Thread.sleep(3000);
	        WebElement signUpBttn = driver.findElement(By.xpath("//button[@class='signup__btn']"));
	        signUpBttn.click();
	        //from this line below we will practice with contains, starts-with, text, contains and text, and and or
	        WebElement phoneNum = driver.findElement(By.xpath("//input[contains(@id,'phoneNumber')]"));
	        phoneNum.sendKeys("402-555-5151");
	        Thread.sleep(3000);
	        WebElement cardNum = driver.findElement(By.xpath("//input[starts-with(@id,'cardNumber')]"));
	        cardNum.sendKeys("1357138769467260 ");
	        Thread.sleep(3000);
	        WebElement nameOnCard = driver.findElement(By.xpath("//input[@name='nameOnCard' and @id='nameOnCardInput']"));
	        nameOnCard.sendKeys("David Colunga");
	        Thread.sleep(3000);
	        WebElement expDayDropDown = driver.findElement(By.xpath("//select[starts-with(@id,'expirationMon')]"));
	        expDayDropDown.click();
	        Thread.sleep(3000);
	        WebElement expDay = driver.findElement(By.xpath("//option[text()='9']"));
	        expDay.click();
	        Thread.sleep(3000);
	        WebElement expMonDropDown = driver.findElement(By.xpath("//select[contains(@id,'YearInput')]"));
	        expMonDropDown.click();
	        Thread.sleep(3000);
	        WebElement expMon = driver.findElement(By.xpath("//option[text()='2023']"));
	        expMon.click();
	        Thread.sleep(3000);
	        WebElement cvsCode = driver.findElement(By.xpath("//input[@name='securityCode' or @id='tekschool']"));
	        cvsCode.sendKeys("456");
	        Thread.sleep(3000);
	        WebElement addYourCardBttn = driver.findElement(By.xpath("//button[contains(text(),'Add Your')]"));
	        addYourCardBttn.click();
	}

}
