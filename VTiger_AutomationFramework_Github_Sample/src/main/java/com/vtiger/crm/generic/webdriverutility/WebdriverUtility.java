package com.vtiger.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	//maximize window
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();;
	}
	//implicit wait
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	//explicit wait
	public void waitForElementToBePresent(WebDriver driver, WebElement element)
	{
		WebDriverWait ew=new WebDriverWait(driver,Duration.ofSeconds(20));
		ew.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait ew=new WebDriverWait(driver,Duration.ofSeconds(20));
		ew.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToBeSelected(WebDriver driver, WebElement element)
	{
		WebDriverWait ew=new WebDriverWait(driver,Duration.ofSeconds(20));
		ew.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitForElementToBeSelectedTrue(WebDriver driver, WebElement element)
	{
		WebDriverWait ew=new WebDriverWait(driver,Duration.ofSeconds(20));
		ew.until(ExpectedConditions.elementSelectionStateToBe(element,true));
	}
	
	//switch to window/tab using iterator
	public void switchToTabOnUrlUsingIterator(WebDriver driver, String partialUrl)
	{
		Set<String> wins=driver.getWindowHandles();
		Iterator<String> i = wins.iterator();
		while(i.hasNext())
		{
			String win=i.next();
			driver.switchTo().window(win);
			if(driver.getCurrentUrl().contains(partialUrl))
			{
				
			}
		}
	}
	public void switchToTabOnTitleUsingIterator(WebDriver driver, String partialTitle)
	{
		Set<String> wins=driver.getWindowHandles();
		Iterator<String> i = wins.iterator();
		while(i.hasNext())
		{
			String win=i.next();
			driver.switchTo().window(win);
			if(driver.getCurrentUrl().contains(partialTitle))
			{
				
			}
		}
	}
	//switch to parent window
	public void switchToParentTab(WebDriver driver)
	{
		String win=driver.getWindowHandle();
		driver.switchTo().window(win);
	}
	//switch to window/tab using for-each
	public void switchToTabOnUrl(WebDriver driver, String partialUrl)
	{
		Set<String> wins=driver.getWindowHandles();
		for(String win: wins)
		{
			driver.switchTo().window(win);
			if(driver.getCurrentUrl().contains(partialUrl))
			{
				
			}
		}
	}
	public void switchToTabOnTitle(WebDriver driver, String partialTitle)
	{
		Set<String> wins=driver.getWindowHandles();
		for(String win: wins)
		{
			driver.switchTo().window(win);
			if(driver.getCurrentUrl().contains(partialTitle))
			{
				
			}
		}
	}
	
	//Frames
	public void switchToFrame(WebDriver driver, String nameId)
	{
		driver.switchTo().frame(nameId);
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	//Alert
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public String switchToAlertAndGetText(WebDriver driver)
	{
		String txt=driver.switchTo().alert().getText();
		return txt;
	}
	public void switchToAlertAndSetText(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	//Actions
	public void mouseMoveOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void mouseMoveOnElementAndClick(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	public void clickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.click(element).perform();
	}
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void contextClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	public void dragAndDropElement(WebDriver driver, WebElement src, WebElement target)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, target).perform();
	}
	public void clickAndHoldElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.clickAndHold(element).perform();
	}
	public void releaseElementUsingActions(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.release(element).perform();
	}
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	//Handling dropdown
	public void selectByIndex(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectByValue(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void selectByVisibleText(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	//capture screenshot 
	public void capturePageScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshots");
		FileHandler.copy(temp, perm);
	}
	public void captureElementScreenshot(WebDriver driver, WebElement element) throws IOException
	{
		File temp=element.getScreenshotAs(OutputType.FILE);
		File perm=new File("./Screenshots");
		FileHandler.copy(temp, perm);
	}
	//JavascriptExecutor
	public void handleDisabledElementAndEnterValue_UingJSE(WebDriver driver, WebElement JSElement, String data)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(JSElement+".value='"+data+"'");
	}
	public void scrollToElement_UingJSE(WebDriver driver, WebElement JSElement, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(JSElement+".scrollIntoView()", element);
	}
	public void handleDisabledElementAndEnterValue(WebDriver driver, WebElement element, String data)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+data+"'", element);
	}
	public void scrollToElementUsingJSE(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	public void scrollToPoint(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public void scrollToPageTop(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	public void scrollToPageBottom(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void zoomInAndOutPage(WebDriver driver, int percentage)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='"+percentage+"%'");
	}
}
