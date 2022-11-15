package handlingAlertsInSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationAlertRecap {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//For authentication alert, we incorporate the username and password to the url itself
		//if the following is our url
//		driver.get("http://the-internet.herokuapp.com/basic_auth");
		//then we incorporate the email and passwrod after http://<username>:<passrod>@domain name
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement text = driver.findElement(By.xpath("//h3//following-sibling::p"));
		System.out.println(text.getText());
		
		driver.close();
	}

}
