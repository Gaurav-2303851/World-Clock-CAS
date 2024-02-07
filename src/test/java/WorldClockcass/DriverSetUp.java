package WorldClockcass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetUp {
	public static WebDriver driver;
	public static String exepath;
	public static String browserType;
	public static WebDriver getWebDriver(String browser) {
		  browserType=browser;
		  if(browserType.equalsIgnoreCase("edge")) {
			  driver=new EdgeDriver();
		  }
		  else if(browserType.equalsIgnoreCase("chrome")){
			  driver=new ChromeDriver();
		  }
		  return driver;
	}
	
}
