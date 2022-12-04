package ImdbPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ImdbHomePage extends Base2{
	
	

	public ImdbHomePage(WebDriver driver) {
		super(driver);
	
	}
	
	WebElement table;
	WebElement button;
 	WebElement link;
	
	
public String movieName;

    
	public void setUp() {
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void launchBrowserWithIMDB() {
		
		driver.get(URL);
		System.out.println("1) launched the browser with IMDB");

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
		
		WebElement searchBox = driver.findElement(By.id("suggestion-search"));
		searchBox.sendKeys(movieName);
		
		System.out.println("2) entered the movie name");
		Thread.sleep(2000);
	}
	

	public void searchTheMovie() throws InterruptedException {
		List<WebElement> searchResults = driver.
				findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list anim-enter-done']//li/a/div[2]/div[1]"));
		
		
	    
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

		
	//	list   = "//div[@data-testid='title-details-section']/ul/li"
	//  button = "//div[@data-testid='title-details-section']/ul/li["+i+"]/button"
	//  link   = "//div[@data-testid='title-details-section']/ul/li["+i+"]/a[1]"
		
		 try {
			    table = driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li"));
			   }catch(Exception e){
				   System.out.println(e);
			   }
			   
			   
			   
			   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
			   Thread.sleep(500); 
			   
			   List<WebElement> list = driver.findElements(By.xpath("//div[@data-testid='title-details-section']/ul/li"));
			   
			   
			   for(int i=1;i<=list.size();i++) {
				   
			        int but=0;
			        int lin=0;
			       try {
			    	   button =driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li["+i+"]/button"));
			    	  
			       }
			   catch(Exception e) {
				       but++;
			    }
			       
			   
				       try {
				    	  link =driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li["+i+"]/a[1]"));
				       }
				   catch(Exception e) {
					       lin++;
				    }   
				       
				       if(but!=0){
				    	   if(link.getText().contains("Release date")) {
				    		   releaseDateDetails =driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li["+i+"]/a[1]/parent::li/div//a")).getText();
				    	   }
				    	   
				       
				       }
				       
					   but=0;
					   lin=0;

			   }
				System.out.println("4) got the Release date");
				System.out.println("===============================================================================");
				System.out.println("(OUTPUT) = The Release Date of '" + movieName + "' is => " + releaseDateDetails);
				System.out.println("===============================================================================");	}
	
	
	public void getCountryName() throws InterruptedException {
         
		
		String country = " Emty ";

		
	//	list   = "//div[@data-testid='title-details-section']/ul/li"
	//  button = "//div[@data-testid='title-details-section']/ul/li["+i+"]/button"
	//  link   = "//div[@data-testid='title-details-section']/ul/li["+i+"]/a[1]"
		
		 try {
			    table = driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li"));
			   }catch(Exception e){
				   System.out.println(e);
			   }
			   
			   
			   
			   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
			   Thread.sleep(500); 
			   
			   List<WebElement> list = driver.findElements(By.xpath("//div[@data-testid='title-details-section']/ul/li"));
			   
			   
			   for(int i=1;i<=list.size();i++) {
				   
			        int but=0;
			        int lin=0;
			       try {
			    	   button =driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li["+i+"]/button"));
			    	  
			       }
			   catch(Exception e) {
				       but++;
			    }
			       
			   
				       try {
				    	  link =driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li["+i+"]/a[1]"));
				       }
				   catch(Exception e) {
					       lin++;
				    }   
				       
				       if(but==0){
				    	   if(link.getText().contains("Release date")) {
				    		   if(button.getText().contains("Country of origin")) {
					    		   country = driver.findElement(By.xpath("//div[@data-testid='title-details-section']/ul/li["+i+"]/button/parent::li/div//a")).getText();
					    	     }
				       
				       }
				       
					   but=0;
					   lin=0;

			   }
			   }
				System.out.println("4) got the Release date");
				System.out.println("===============================================================================");
				System.out.println("(OUTPUT) The Country of origin of '" + movieName + "' is => " + country );
				System.out.println("===============================================================================");
	
	}
	
	

	public void closeBrowser() {
		driver.quit();
		System.out.println("5) driver got closed");
	}
	
//    public static void main(String[] args) throws InterruptedException {
//    	ImdbHomePage im = new ImdbHomePage(driver);
//    	im.launchBrowserWithIMDB();
//    	im.enterMovieName("Pushpa");
//    	im.searchTheMovie();
//    	im.getCountryName();
//    	im.closeBrowser();
//    	
//    
//	}



}



