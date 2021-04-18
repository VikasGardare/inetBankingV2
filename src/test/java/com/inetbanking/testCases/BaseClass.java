package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
//	public String baseURL="http://demo.guru99.com/v4/index.php";
//	public String username="mngr319730";
//	public String password="savyqev";
	public static WebDriver driver;
	Logger logger;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) {
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefox());
			driver=new FirefoxDriver();
		}
		if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIE());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String Fname) throws IOException {
		TakesScreenshot scr=(TakesScreenshot)driver;
		File Source=scr.getScreenshotAs(OutputType.FILE);
		File Target=new File("./Screenshot/"+Fname+".png");
		FileUtils.copyFile(Source, Target);
		System.out.println("ScreenShot Taken");
	}
	
	public String RandomEmail() {
		String randomString=RandomStringUtils.random(8);
		return randomString;
	}
}
