package WorldClockcass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagemodelclock {
	public WebDriver driver;
	Pagemodelclock (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Title 
	
	@FindBy(xpath="(//*[@id=\"CaptionElementView\"])[3]")
	WebElement Title_clock;
	public String checkclockbox(){
		String present=Title_clock.getText();
		return present;
	}

	//Bangalore, India (IST)
	
	@FindBy(xpath="(//*[@data-automation-id=\"clock-card-location\"])[1]") 
	WebElement india_loc;
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[1]")
	WebElement india_time;
	@FindBy(xpath="//*[@id=\"vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af\"]/div/div[2]/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div[2]")
	WebElement day_date;
	public String checkindiaclock() {
		String bangtitle=india_loc.getText();	
		return bangtitle;
	}
	public String checkindiatime() {
		return india_time.getText();
	}
	public String chechindiadate() {
		return day_date.getText();
	}
	
	//london 
	
	@FindBy(xpath="(//*[@data-automation-id='clock-card-location'])[2]")
	WebElement lon_loc;
	@FindBy(xpath="//*[@id='vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af']/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[1]/span[1]")
	WebElement lon_time;
	@FindBy(xpath="//*[@id='vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af']/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]")
	WebElement lon_date;
	@FindBy(xpath="//*[@id='vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af']/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]")
	WebElement lon_ind_gap;
	public String checklonclock() {
		String lontitle=lon_loc.getText();
		return lontitle;
	}
	public String checklontime() {
		String lontime = lon_time.getText();
		return lontime;
	}
	public String checklondate() {
		String londate = lon_date.getText();
		return londate;
	}
	public String checklongaptime() {
		String longap=lon_ind_gap.getText();
		return longap;
	}
	
	//NY
	
	@FindBy(xpath="(//*[@data-automation-id='clock-card-location'])[3]")
	WebElement ny_loc;
	@FindBy(xpath="//*[@id='vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af']/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[1]/span[1]")
	WebElement ny_time;
	@FindBy(xpath="//*[@id='vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af']/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/div[2]") 
	WebElement ny_date;
	@FindBy(xpath="//*[@id='vpc_WebPart.WorldClockWebPart.internal.60655e4a-73c8-49d0-9571-c762791557af']/div/div[2]/div/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/div[1]") 
	WebElement ny_india_gap;
	public String nyclock() {
		String nytitle=ny_loc.getText();
		return nytitle;
	}
	public String checknytime() {
		String nytime = ny_time.getText();
		return nytime;
	}
	public String checknydate() {
		String nydate = ny_date.getText();
		return nydate;
	}
	public String checknyindiagaptime() {
		String nygap=ny_india_gap.getText();
		return nygap;
}
}
