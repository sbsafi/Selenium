package launchBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class creatingFB {
	public static void main(String [] arg) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		WebElement creatAcc = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		creatAcc.click();
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Samir");
		Thread.sleep(2000);
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastName.sendKeys("Roshan");
		Thread.sleep(2000);
		WebElement emailPhone = driver.findElement(By.xpath("//input[@name='reg_email__'] "));
		emailPhone.sendKeys("8179443582");
		Thread.sleep(2000);
		WebElement newPass = driver.findElement(By.xpath("//input[@id='password_step_input'] "));
		newPass.sendKeys("Kabul1993!");
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.xpath("//select[@id='month']//child::option[@value='2']"));
		month.click(); 
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//select[@id='day']//child::option[@value='6']"));
		day.click();
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@id='year']//child::option[@value='1993']"));
		year.click();
		WebElement gender = driver.findElement(By.xpath("//label[text()='Male'] "));
		gender.click();
		Thread.sleep(2000);
		WebElement signupBtnn = driver.findElement(By.xpath("//button[text()='Sign Up']"));
		signupBtnn.click();
		
		
//		Thread.sleep(2000);
//		driver.close();
		
		
		
		
		
		
		
		
		
		
	}

}
