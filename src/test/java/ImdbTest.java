

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import ImdbPage.ImdbHomePage;
import WikiPage.WikiHome;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ImdbTest {
	
	public  WebDriver driver;
	
	ImdbHomePage im ;
	
	@BeforeMethod
	public void setup() {
		
		im = new ImdbHomePage(driver);
        im.setUp();
        im.launchBrowserWithIMDB();
        
        }
	
	
	@Test(priority=1)
	public void getReleaseDate() throws InterruptedException {
		
		im.enterMovieName("pushpa");
		im.searchTheMovie();
		im.getReleaseDate();
		
	}
	
	@Test(priority=2)
	public void getCountryName() throws InterruptedException {
		
		im.enterMovieName("pushpa");
		im.searchTheMovie();
		im.getCountryName();
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		im.closeBrowser();
		Thread.sleep(5000);
		
	}
}
