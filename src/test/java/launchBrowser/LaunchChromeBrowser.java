package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		/* New method:
			Maven project
			Maven is project build tool and it contains a pom.xml file which contains all of our project setup and also we can add dependencies to this pom.xml file and it will download the jar files/libraries and add them to our project build path automatically instead of we doing it manually.
			Steps to create a Maven project
			Click on File
			Click on New
			Click on project
			Select Maven Project
			Click Next
			Click next again
			Inside the filter search bar, type maven-archetype-quickstart
			And you will see the simple maven project type that you can choose to create your first Maven project. (if you see version 1.1 only you can select that one, but if you see version 1.4 make sure to select 1.4)
			Click Next
			Type your groupid and artifactid (they both also can be the same name)
			For our project, we choose (com.PanthersSeleniumProject)
			Click on finish

			POM.XML file
			POM – Project Object Model
			.XML is just an extension of a xml file
			With maven project, we can get the WebDriverManager dependency and added to our project pom.xml file, and it would download all of the available drivers for all of the browser we use and plus all of the versions available/we use and keep them in our local maven repository.
			Now, since we are using WebDriverManager, we can launch any browser we want, we also don’t have to worry about the version of our browser compatible with the driver for that specific browser.
			Where we can fine the dependency for webdrivermanager?
			Answer: mvncentralrepository
       */

		
		// initializing browser with WebDriverManager 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.amazon.com/");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
