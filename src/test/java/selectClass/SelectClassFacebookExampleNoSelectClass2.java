package selectClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassFacebookExampleNoSelectClass2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> listOfCountries = driver.findElements(By.xpath("//select[@name='country']//child::option"));
//		for(int i = 0; i < listOfCountries.size(); i++) {
//			if(listOfCountries.get(i).getText().equalsIgnoreCase("Malta")) {
//				listOfCountries.get(i).click();
//				break;
//			}
//		}
		getCountryFromList(listOfCountries, "Afghanistan");
		Thread.sleep(2000);
		getCountryFromList(listOfCountries, "Bahrain");
		Thread.sleep(2000);
		getCountryFromList(listOfCountries, "Brazil");
		Thread.sleep(2000);
		getCountryFromList(listOfCountries, "Colombia");
		
		
	}
	public static void getCountryFromList(List<WebElement> element, String countryName) {
		for(int i = 0; i < element.size(); i++) {
			if(element.get(i).getText().equalsIgnoreCase(countryName)) {
				element.get(i).click();
				break;
			}
		}

	}

}
