package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParacticeWebDriverManager {
	public static void main(String[] arg) {
		
		// here we first initialize 
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver ();
		dr.get("https:/www.amazon.com/");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
		
	}

}
