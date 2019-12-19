package JavaScriptExicuterConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCalendarByJavascript {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();

		WebDriver d = new FirefoxDriver();

		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		d.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // pageLoadTimeout() will wait for 40sec if page
																		// loaded before that remaining time will be
																		// ignored
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicitlyWait() will wait for 30sec if page
																	// loaded before that remaining time will be ignored
		// Also this timeouts() are global variable no need to assign again & again to
		// wait until the page loads.

		d.get("http://Spicejet.com");
		
		WebElement date = d.findElement(By.id("ctl00_mainContent_view_date1"));
		String datevalue = "30-12-2019";
		
		
		SelectCalendarByJavascript(d, date, datevalue);
		
	}
	
	public static void SelectCalendarByJavascript(WebDriver d, WebElement element, String datevalue) {
		JavascriptExecutor js = ((JavascriptExecutor) d);
		js.executeScript("arguments[0].setAttribute('value','"+datevalue+"');", element);
	}

}
