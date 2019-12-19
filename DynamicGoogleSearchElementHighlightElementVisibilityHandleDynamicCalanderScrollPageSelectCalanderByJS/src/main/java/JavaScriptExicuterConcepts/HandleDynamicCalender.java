package JavaScriptExicuterConcepts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicCalender {

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

		d.get("*******");

		String date = "18/September/19";
		String dateArray[] = date.split("-"); // .split will split the date into 18-September-19
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];

		// In this example month & year selected in the drop down

		// [@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		// [@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		// [@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]

		String before_xpath = "[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String after_xpath = "]/td[";

		final int weekdays = 7;
		boolean flag = false;
		String dayval = null;

		for (int rownum = 2; rownum <= weekdays; rownum++) {

			for (int colnum = 0; colnum <= weekdays; colnum++) {
				try {
					dayval = d.findElement(By.xpath(before_xpath + rownum + after_xpath + colnum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("Please enter a correct date value ");
					flag = false;
					break;
				}
				System.out.println(dayval);
				if (day.equals(dayval)) {
					d.findElement(By.xpath(before_xpath + rownum + after_xpath + colnum + "]")).click();
					flag = true;
					break;
				}

			}
			if (flag) {
				break;
			}
		}

	}

}
