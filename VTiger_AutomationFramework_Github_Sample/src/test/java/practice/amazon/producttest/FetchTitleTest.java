package practice.amazon.producttest;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;


public class FetchTitleTest {
@Test
public void fetchTitleTest()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	driver.findElement(By.xpath("//*[local-name()='svg']/*[name()='image']/../..")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
	Actions a=new Actions(driver);
	a.scrollToElement(driver.findElement(By.xpath("//span[.='Chrome Web Store']"))).perform();
	a.click(driver.findElement(By.xpath("//span[.='Chrome Web Store']"))).perform();
	System.out.println(driver.findElement(By.xpath("//span[.='Art & Design']")).getText());
//	System.out.println(driver.findElement(By.xpath("(//h2[.='Welcome to the Chrome Web Store'])[2]")).getText());
//	RelativeLocator(driver.findElement(By.xpath("//span[.='Art & Design']")))
}

}
