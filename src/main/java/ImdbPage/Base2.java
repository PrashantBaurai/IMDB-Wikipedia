package ImdbPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Base2 {
	
public static WebDriver driver;
	
	
	public Base2(WebDriver driver) {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 this.driver=driver;
	}
	
	
	public  String URL = "https://www.imdb.com/";

}