package WorldClockcass;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pagemodelapps {
	  WebDriver driver;
	  
	pagemodelapps(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	    @FindBy (xpath="(//div[@id='QuicklinksItemTitle'])[6]") WebElement ele;
	    @FindBy (xpath="//div[@class='viewAllHotAppsBtn']") WebElement ele2;
	    @FindBy (xpath="//div[@class ='aZHolder']/div") List<WebElement> ele3;
public void onecognizant()
{
	ele.click();
}

public void hotapps()
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();",ele2);
	js.executeScript("arguments[0].click();", ele2);
}

}
