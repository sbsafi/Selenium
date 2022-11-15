package locatorInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathAxesMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tek-retail-ui.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement signInBttn = driver.findElement(By.xpath("//button[@id='signinBtn']"));
		signInBttn.click();
		WebElement createNewAcct = driver.findElement(By.xpath("//button[@class='login__account-btn']"));
		createNewAcct.click();
		WebElement name = driver.findElement(By.xpath("//input[@id='nameInput']"));
		name.sendKeys("David Colunga");
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		//make sure to user different email address when you are running this code
		email.sendKeys("davidcolunga978@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='passwordInput']"));
		password.sendKeys("DAVIDcolunga@2022");
		WebElement confirmPass = driver.findElement(By.xpath("//input[@id='confirmPasswordInput']"));
		confirmPass.sendKeys("DAVIDcolunga@2022");
		WebElement signUpBttn = driver.findElement(By.xpath("//button[@class='signup__btn']"));
		signUpBttn.click();
		//from this line below we will practice with contains, starts-with, text, contains and text, and and or
		WebElement phoneNum = driver.findElement(By.xpath("//input[contains(@id,'phoneNumber')]"));
		phoneNum.sendKeys("402-555-5151");
		WebElement cardNum = driver.findElement(By.xpath("//input[starts-with(@id,'cardNumber')]"));
		cardNum.sendKeys("1111111111111111");
		WebElement nameOnCard = driver.findElement(By.xpath("//input[@name='nameOnCard' and @id='nameOnCardInput']"));
		nameOnCard.sendKeys("David Colunga");
		WebElement expDayDropDown = driver.findElement(By.xpath("//select[starts-with(@id,'expirationMon')]"));
		expDayDropDown.click();
		WebElement expDay = driver.findElement(By.xpath("//option[text()='11']"));
		expDay.click();
		WebElement expMonDropDown = driver.findElement(By.xpath("//select[contains(@id,'YearInput')]"));
		expMonDropDown.click();
		WebElement expMon = driver.findElement(By.xpath("//option[text()='2023']"));
		expMon.click();
		WebElement cvsCode = driver.findElement(By.xpath("//input[@name='securityCode' or @id='tekschool']"));
		cvsCode.sendKeys("456");
		WebElement addYourCardBttn = driver.findElement(By.xpath("//button[contains(text(),'Add Your')]"));
		addYourCardBttn.click();
		
		//Code for 10/11/2022 => adding address to customer acccount
		//XPath Axes methods
		WebElement addAddress = driver.findElement(By.xpath("//div[@class='account__address-new-wrapper']"));
		addAddress.click();
		Thread.sleep(2000);
		//descendant::
		////form[@class='account__form']//div[2]//input
		////div[@class='modal']//div//div//form[@class='account__form']//descendant::input[@id='fullNameInput']
		////form[@class='account__form']//descendant::input[@id='fullNameInput']
		WebElement fullName = driver.findElement(By.xpath("//form[@class='account__form']//descendant::input[@id='fullNameInput']"));
		fullName.sendKeys("David Colunga");
		Thread.sleep(2000);
		//child::
		////div[@class='account__address-new-padding']//input[@id='phoneNumberInput']
		////div[@class='account__address-new-padding']//label[text()='Phone Number']//parent::div//child::input
		WebElement phoneNum2 = driver.findElement(By.xpath("//div[@class='account__address-new-padding']//label[text()='Phone Number']//parent::div//child::input"));
		phoneNum2.sendKeys("402-555-5151");
		Thread.sleep(2000);
		//preceding::
		////label[text()='Address']//parent::div//preceding-sibling::div//descendant::input[@id='streetInput']
		WebElement address = driver.findElement(By.xpath("//label[text()='Address']//parent::div//preceding-sibling::div//descendant::input[@id='streetInput']"));
		address.sendKeys("222 King Street");
		Thread.sleep(2000);
		//following-sibling::
		////div[@class='account__address-new-grid'][1]//label//following-sibling::input
		WebElement cityName = driver.findElement(By.xpath("//div[@class='account__address-new-grid'][1]//label//following-sibling::input"));
		cityName.sendKeys("Arlington");
		Thread.sleep(2000);
		//self::
		WebElement stateName = driver.findElement(By.xpath("//select[@name='state']//self::select"));
		Select select = new Select(stateName);
		select.selectByVisibleText("Virginia");
		Thread.sleep(2000);
		//following-sibling:: and child::
		WebElement zipCode = driver.findElement(By.xpath("//div//child::label[text()='Zip Code']//following-sibling::input"));
		zipCode.sendKeys("22304");
		Thread.sleep(2000);
		WebElement addAdressBttn = driver.findElement(By.xpath("//button[text()='Add Your Address']"));
		addAdressBttn.click();
		
	}

}
