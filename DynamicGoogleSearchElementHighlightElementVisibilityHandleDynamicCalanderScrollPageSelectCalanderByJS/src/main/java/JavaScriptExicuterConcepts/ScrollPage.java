package JavaScriptExicuterConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPage {

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
		// wait until the page loads.0
		
		d.get("https://www.facebook.com/");

		
		d.findElement(By.xpath("//input[@id='email']")).sendKeys("mouryabhushan.kgl@gmail.com");
		d.findElement(By.xpath("//input[@id='pass']")).sendKeys("Manishmanvi@123");
		d.findElement(By.xpath("//input[@id='u_0_2']")).click();
		
		ScrollIntoView(d);
		
		
	}
	public static void ScrollIntoView(WebDriver d ) {
		JavascriptExecutor js = ((JavascriptExecutor) d);
		js.executeScript("argument[0].scrollIntoView(true);");

	}

}
