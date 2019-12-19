package JavaScriptExicuterConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementVisibilityTest {

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
		
		d.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		boolean b1 = d.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).isDisplayed();  //Tells element is displayed in screen or not
		System.out.println(b1); //true
		
		boolean b3 = d.findElement(By.xpath("//button[@id='ppaFormSbtBtn']")).isEnabled();  //Tells element is enabled or not
		System.out.println(b3); //false
		
		boolean b2 = d.findElement(By.xpath("//input[@name='checkbox-default']")).isSelected();  //Used for dropdown, Checkbox & radio btn
		System.out.println(b2); //false
		
		
		
		
		
		
	}

}
