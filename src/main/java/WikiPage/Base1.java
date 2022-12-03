package WikiPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
	
	public static WebDriver driver;
	
	
	public Base1(WebDriver driver) {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 Base1.driver=driver;
	}
	
	public  String URL = "https://www.wikipedia.org/";
	

		
	}

