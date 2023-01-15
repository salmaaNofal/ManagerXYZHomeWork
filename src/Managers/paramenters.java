package Managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paramenters {
	WebDriver driver = new ChromeDriver();
	String HomeURL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
	String FirstName = "salma";
	String LastName = "nofal";
	int PostCode=12345; 
	String Currency ="Dollar";

	@BeforeTest

	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver.get(HomeURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

}
