package WorldClockcass;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class worldclock {
	public static WebDriver driver;
	public static String url="https://be.cognizant.com/";
	public static String browser="chrome";
	public static Pagemodelclock wc;
	pagemodelapps one;

	@BeforeClass
	void openpage(){
		driver=DriverSetUp.getWebDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		WebElement seeAll=driver.findElement(By.xpath("//*[@id=\"c24ff0ed-b166-42e5-b7d5-57c9a9e573cb\"]/div/div/div/p/a/span/strong"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",seeAll);
	}


	@Test(priority = 1)
	public static void Test_WorldClock_Title() {
		wc=new Pagemodelclock(driver);
		System.out.println(wc.checkclockbox().toLowerCase());
		Assert.assertEquals(wc.checkclockbox().toLowerCase(), "world clock");
	}

	//India time
	@Test(priority = 2)
	void BangaloreWatch_Title() {
		wc=new Pagemodelclock(driver);
		System.out.println(wc.checkindiaclock());
		Assert.assertEquals(wc.checkindiaclock().toLowerCase(), "bangalore, india (ist)");
	}

	@Test(priority = 3)
	public static void Bangalore_Time() {
		Date currentTime = new Date();
		SimpleDateFormat timeformat=new SimpleDateFormat("h:mma");
		String formatedtime=timeformat.format(currentTime); 
		System.out.println(formatedtime.toLowerCase());
		String webtime=wc.checkindiatime();
		System.out.println(webtime.toLowerCase());
		Assert.assertEquals(webtime.toLowerCase(), formatedtime.toLowerCase());
	}

	@Test(priority = 4)
	public static void Bangalore_Date() {
		LocalDate currentSysDate=LocalDate.now();
		DateTimeFormatter date_formatter=DateTimeFormatter.ofPattern("EEEE, M/d/yyyy");
		String formattedDate=currentSysDate.format(date_formatter);
		System.out.println(formattedDate.toLowerCase());
		String webdate=wc.chechindiadate();
		System.out.println(webdate.toLowerCase());
		Assert.assertEquals(webdate.toLowerCase(), formattedDate.toLowerCase());
	
	}

	//london test
	@Test(priority = 5)

	void LondonWatch_Tittle() {

		Assert.assertEquals(wc.checklonclock().toLowerCase(), "london, uk (bst)");

	}

	@Test(priority = 6)

	void London_Time() {
		wc=new Pagemodelclock(driver);
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
		SimpleDateFormat time = new SimpleDateFormat("h:mm");
		Date time_ = new Date();
		String time_lon = time.format(time_);
		System.out.println(wc.checklontime());
		System.out.println(time_lon);
		Assert.assertEquals(time_lon,wc.checklontime());
	}

	@Test(priority = 7)

	void London_Date() {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
		SimpleDateFormat date = new SimpleDateFormat("EEEE, M/d/yyyy");
		Date date_ = new Date();
		String date_lon = date.format(date_);
		System.out.println(wc.checklondate());
		System.out.println(date_lon);
		Assert.assertEquals(date_lon,wc.checklondate());
	}

	@Test(priority = 8)

	void London_Timegap() {
		TimeZone bangloreTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
		        TimeZone LondonTimeZone = TimeZone.getTimeZone("Europe/London");
		        int hoursDifference = (bangloreTimeZone.getRawOffset()-LondonTimeZone.getRawOffset()) / (60 * 60 * 1000);
		        int minutesDifference = (bangloreTimeZone.getRawOffset()-LondonTimeZone.getRawOffset()) / (60 * 1000) % 60;
		        String lonbanggap = hoursDifference + "h " + minutesDifference + "m "+"behind";
				System.out.println(lonbanggap);
				System.out.println(wc.checklongaptime());
				Assert.assertEquals(lonbanggap, wc.checklongaptime());
	}


	//NY Test


	@Test (priority = 9)

	void NY_Watchtittle() {

		Assert.assertEquals(wc.nyclock().toLowerCase(), "new york, ny (est)");

	}

	@Test(priority = 10)

	void NY_Time() {
		wc=new Pagemodelclock(driver);
		 
		TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
		SimpleDateFormat time = new SimpleDateFormat("h:mm");
		Date time_ = new Date();
		String time_NY = time.format(time_);
		System.out.println(wc.checknytime());
		System.out.println(time_NY);
		Assert.assertEquals(time_NY,wc.checknytime());
	}

	@Test (priority = 11)

	void NY_Date() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
		SimpleDateFormat date = new SimpleDateFormat("EEEE, M/d/yyyy");
		Date date_ = new Date();
		String date_NY = date.format(date_);
		System.out.println(wc.checknydate());
		System.out.println(date_NY);
		Assert.assertEquals(date_NY,wc.checknydate());
	}

	@Test (priority = 12)

	void NY_Timegap() {
				TimeZone bangloreTimeZone = TimeZone.getTimeZone("Asia/Kolkata");
		        TimeZone newYorkTimeZone = TimeZone.getTimeZone("America/New_York");
		        int hoursDifference = (bangloreTimeZone.getRawOffset()-newYorkTimeZone.getRawOffset()) / (60 * 60 * 1000);
		        int minutesDifference = (bangloreTimeZone.getRawOffset()-newYorkTimeZone.getRawOffset()) / (60 * 1000) % 60;
		        String NYbanggap = hoursDifference + "h " + minutesDifference + "m "+"behind";
				System.out.println(NYbanggap);
				System.out.println(wc.checknyindiagaptime());
				Assert.assertEquals(NYbanggap, wc.checknyindiagaptime());
	}

//Apps
	
	
	@Test(priority=13)	
	public void Viewapps() {
		//view all apps
		one=new pagemodelapps(driver);
		one.onecognizant();
		Set<String> windowid = driver.getWindowHandles();
		List<String> windowsidList = new ArrayList<String> (windowid);
		for (int i =0;i<windowsidList.size();i++) {
			String title=driver.switchTo().window(windowsidList.get(i)).getTitle();
			if (title.equals("OneCognizant")) {
				break;
			}
		}
			//one.Quickaccess();
			one.hotapps();
	}
	@Test(priority=14)
	public void Appsalphabet() {   
		    //disabled alphabet
		one=new pagemodelapps(driver);
			List<String> str= new ArrayList<String>();
			for(WebElement e:one.ele3) {
				if(e.getAttribute("role")!=null) {
					continue;
				}
				else
					str.add(e.getText());
			}
			for(String s: str)
			System.out.println(s+" is disabled");
 
		}
	@Test(priority=15)
	void Randomalphabet() {
		one=new pagemodelapps(driver);
		Random rand=new Random();
		List<WebElement> li = one.ele3;
		while(true) {
		int n=rand.nextInt(li.size());
		if(li.get(n).equals("X"))
			continue;
		li.get(n).click();
		break;
		}
	}
	//close browser

	@AfterClass

	void close() {

		driver.quit();

	}



}
