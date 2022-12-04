package WikiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.Super;

public class WikiHome extends Base1{
	        
       
            
	public WikiHome(WebDriver driver) {
		super(driver);
	}

	public String movieName;
    
	public void setUp() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void launchWikipedia() {
		
		driver.get(URL);
		System.out.println("1) launched the browser with wikipedia");

	}

	public void enterMovieName(String movieName) throws InterruptedException {
		for(int i=0;i<movieName.length();i++) {
			if(movieName.charAt(i)=='!'
			|| movieName.charAt(i)=='#'
			|| movieName.charAt(i)=='#'
			|| movieName.charAt(i)=='$'
			|| movieName.charAt(i)=='%'
			|| movieName.charAt(i)=='&'
			|| movieName.charAt(i)=='*'
			|| movieName.charAt(i)=='-'
			|| movieName.charAt(i)=='/'
			|| movieName.charAt(i)==':'
			|| movieName.charAt(i)=='<'
			|| movieName.charAt(i)=='='
			|| movieName.charAt(i)=='>'
			|| movieName.charAt(i)=='?'
			|| movieName.charAt(i)=='^'
			|| movieName.charAt(i)=='~') {
				
				System.out.println(i);
				   
				   movieName = movieName.replaceAll(movieName.charAt(i)+"","");
				   System.out.println(movieName);
				   i--;
				   
			   
		}
		}
	
		movieName= movieName.toLowerCase();
		this.movieName = movieName;
		
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		searchBox.sendKeys(movieName);
		
		System.out.println("2) entered the movie name");
		Thread.sleep(2000);
	}

	public void searchTheMovie() throws InterruptedException {
		List<WebElement> searchResults = driver.
				findElements(By.xpath("//div[@class='suggestions-dropdown']//h3"));
		
		
	    
		for(int i=0;i<searchResults.size();i++) {
			
			String searchResultName = searchResults.get(i).getText().toLowerCase();
			
			if(searchResultName.contains(movieName)) {
				searchResults.get(i).click();
				break;
			}else {
				if(searchResultName.contains(movieName.split(" ")[0])) {
					searchResults.get(i).click();
					break;
			}
	
		}
		}
		
		System.out.println("3) searched the movie");
	}

	public void getReleaseDate() throws InterruptedException {
         
		
		String releaseDateDetails = " Emty ";

		List<WebElement> table = driver.findElements(By.xpath("//table[@class='infobox vevent']/tbody/tr/th"));

		for (int j = 3; j <= table.size(); j++) {

			WebElement tableText = driver
					.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[" + j + "]/th"));

			if (tableText.getText().contains("Release date")) {

				List<WebElement> ReleaseDateList = driver.findElements(
						By.xpath("//table[@class='infobox vevent']/tbody/tr[" + j + "]/th/parent::tr//li"));
				WebElement ReleaseDate = driver.findElement(
						By.xpath("//table[@class='infobox vevent']/tbody/tr[" + j + "]/th/parent::tr//td"));

				if (ReleaseDateList.size() == 0) {
					releaseDateDetails = ReleaseDate.getText();
				} else {
					for (int l = 0; l < ReleaseDateList.size(); l++) {
						releaseDateDetails = ReleaseDateList.get(l).getText();
					}

				}
			}

		}
		System.out.println("4) got the Release date");
		System.out.println("===============================================================================");
		System.out.println("The Release Date of '" + movieName + "' is => " + releaseDateDetails);
		System.out.println("===============================================================================");
		

	}

	public void getCountryName() throws InterruptedException {

		String country = " Emty ";

		List<WebElement> table = driver.findElements(By.xpath("//table[@class='infobox vevent']/tbody/tr/th"));

		for (int j = 3; j <= table.size(); j++) {

			WebElement tableText = driver
					.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[" + j + "]/th"));

			if (tableText.getText().contains("Countr")) {

				List<WebElement> ReleaseDateList = driver.findElements(
						By.xpath("//table[@class='infobox vevent']/tbody/tr[" + j + "]/th/parent::tr//li"));
				WebElement ReleaseDate = driver.findElement(
						By.xpath("//table[@class='infobox vevent']/tbody/tr[" + j + "]/th/parent::tr//td"));

				if (ReleaseDateList.size() == 0) {
					country = ReleaseDate.getText();
				} else {
					for (int l = 0; l < ReleaseDateList.size(); l++) {
						country = ReleaseDateList.get(l).getText();
					}

				}
			}

		}
		
		System.out.println("4) got the Country Name");
		System.out.println("===============================================================================");
		System.out.println("The Country of Movie name '" + movieName + "' is => " + country);
		System.out.println("===============================================================================");
		

	}

	public void closeBrowser() {
		driver.quit();
		System.out.println("5) driver got closed");
	}
    		   
    		   public static void main(String[] args) throws InterruptedException {
    			   
    			   WikiHome wiki = new WikiHome(driver);
    			   wiki.setUp();
    			   wiki.launchWikipedia();
    			   wiki.enterMovieName("Pushpa");
    			   wiki.searchTheMovie();
    			   wiki.getCountryName();
    			   wiki.closeBrowser();
    			   
			}
   }