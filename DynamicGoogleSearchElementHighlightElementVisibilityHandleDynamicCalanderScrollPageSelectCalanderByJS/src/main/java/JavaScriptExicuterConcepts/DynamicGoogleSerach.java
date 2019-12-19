package JavaScriptExicuterConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicGoogleSerach {

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

		d.get("http://Google.com");
		d.findElement(By.xpath("//input[@name='q']")).sendKeys("Java");
		List<WebElement> List = d.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']")); // Dynamic
																														// xpath
		System.out.println("Total search list: " + List.size()); //Gives the count of search list

		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i).getText());
			if (List.get(i).getText().equals("java tutorial")) {
				List.get(i).click();
				break; // Search until "java tutorial" is available then for loop stops due to break;
			}
		}

	}

}
