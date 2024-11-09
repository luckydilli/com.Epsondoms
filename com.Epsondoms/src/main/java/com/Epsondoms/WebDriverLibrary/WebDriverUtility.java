package com.Epsondoms.WebDriverLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;




/**
 * This Class is used to Provide the Reusable Methods to Perform all Browser related Actions
 * @author dell*/

public class WebDriverUtility {

	public static WebDriver driver_static;
	public WebDriver driver;
	public static Select selectobj;
	public static Actions actionsobj;
	public static Robot robotobj;
	public WebDriverWait wait;

	
	/**
	 * This Method Is Used To Launch The Specific Browser 
	 * @param String Browser Name
	 * @return void*/
	public void launchBrowser(String browser) {

		// Step1: Launch the Browser-----> Chrome, Edge, safari
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver_static = driver;
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver_static = driver;
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver_static = driver;
			break;

		default:
			System.out.println("Entered incorrect browser name stupid");
			break;
		}
		Reporter.log("Step1: Successully launched");
	}

	
	/**
	 * This Method Is Used To Navigate To The Application
	 * @param String url
	 * @return void*/
	
	public void NavigateToApplication(String url) {
		driver.get(url);
	}

	/**
	 * This Method Is Used To Maximize The Browser
	 * @return void*/
	public void maximizeTheBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This Method Is Used To Close The Browser Action
	 * @return void*/
	public void closeTheBrowser() {
		driver.close();
	}

	/**
	 * This Method Is Used To Close The Entire Browser
	 * @return void*/
	public void closeAllBrowser() {
		driver.quit();
	}

	/**
	 * This Method Is Used To Wait For the web page element
	 * @param long duration
	 * @return void*/
	public void waitImplicitly(long duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	/**
	 * This Method is used to perform wait on the web element
	 * @param long duration, WebElement element
	 * @return void*/
	public void waitExplicitily(long duration, WebElement element) {
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to select the DropDown 
	 * @param WebElement element, int index*/
	public void selectOptionInDropdown(WebElement element, int index) {
		selectobj.selectByIndex(index);
	}

	/**
	 * This method is used to select DropDown using visibletext
	 * @param WebElement element, String visibletext
	 * @return void*/
	public void selectOptionInDropdown(WebElement element, String visibletext) {
		selectobj.selectByVisibleText(visibletext);
	}

	/**
	 * This method is used to select DropDown using value
	 * @param String value, WebElement element
	 * @return void*/
	public void selectOptionInDropdown(String value, WebElement element) {
		selectobj.selectByVisibleText(value);
	}

	/**
	 * This method is used to Mouse actions 
	 * @param  WebElement element
	 * @return void*/
	public void mouseHovering(WebElement element) {
		actionsobj.moveToElement(element).perform();
	}

	/**
	 * This method is used to KeyBoard Actions to perform key press page down action
	 * @param 
	 * @return void*/
	public void pressTheKey_pageDown() {
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);
	}

	/**
	 * This method is used to KeyBoard Actions to perform key release
	 * @param 
	 * @return void*/

	public void ReleaseTheKey() {
		robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}

	/**
	 * This method is used to Accept Alert 
	 * @param 
	 * @return void*/

	public void alertPopupAccept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to Dismiss Alert
	 * @param 
	 * @return void*/

	public void alertPopupDismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to Switching the control
	 * @param int index
	 * @return void*/

	public void switchControlToFrame(int index) {
		driver.switchTo().frame(0);
	}

	/**
	 * This method is used to Switch The Control to Frame
	 * @param WebElement element
	 * @return void*/

	public void switchControlToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to Switch Back To main Frame/Window
	 * @param 
	 * @return void*/

	public void switchBackControlToMain() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to Switch Back To Window
	 * @param String windowaddress
	 * @return void*/

	public void switchControlToWindow(String windowaddress) {

		driver.switchTo().window(windowaddress);
	}

}
