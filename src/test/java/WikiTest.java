

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import WikiPage.WikiHome;

public class WikiTest {
	
	WebDriver driver;
	WikiHome wiki = new WikiHome(driver);
	
	@BeforeMethod
	public void setup() {
        wiki.setUp();
	}
	
	@Test(priority=1)
	public void getReleaseDate() throws InterruptedException {
		
		wiki.launchWikipedia();	
		wiki.enterMovieName("Pushpa");
		wiki.searchTheMovie();
		wiki.getReleaseDate();
		
	}
	
	@Test(priority=2)
	public void getCountryName() throws InterruptedException {
		
		wiki.launchWikipedia();	
		wiki.enterMovieName("Pushpa");
		wiki.searchTheMovie();
		wiki.getCountryName();
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		wiki.closeBrowser();
		Thread.sleep(2000);
	}
}
