package com.Flipkart.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.mail.HtmlEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.Flipkart.Electonics.Mobile.MobilePhonesIndexPage;
import com.Flipkart.Electonics.Mobile.MobilePhonesVerification;
import com.Flipkart.Utility.FlipkartReporter;




public class SeleniumInit
{
	public WebDriver driver;
	public static String TestURL;
	public static String Testpath;
	public static String filepath ;
	public static String Testbrowser;
	

	
	public MobilePhonesIndexPage mobilePhonesIndexPage;
	public MobilePhonesVerification mobilePhonesVerification;
	public Common common;
	public FlipkartReporter flipkartReporter;
	
	
		
	@BeforeTest(alwaysRun = true)
	public void BrowserSetup() throws IOException
	{
		TestURL=Common.getConfigValue("config.properties","URL");
		
		Testbrowser=Common.getConfigValue("config.properties", "Browser");
		Testpath=Common.getConfigValue("config.properties", "Path");
		System.setProperty("webdriver."+Testbrowser+".driver", Testpath);
		if(Testbrowser.equalsIgnoreCase("gecko"))
		{
		
		    driver= new FirefoxDriver();
		}	
		else if(Testbrowser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
			
		driver.manage().window().maximize();
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		mobilePhonesIndexPage = new MobilePhonesIndexPage(driver);
		mobilePhonesVerification = new MobilePhonesVerification(driver);
		common=new Common(driver);
		flipkartReporter = new FlipkartReporter();
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void postConfig(ITestResult TestResult) throws IOException {
			
		if (TestResult.getStatus() == ITestResult.FAILURE) 
		{
			try
			{
				filepath = common.takeScreenshot(TestResult.getName());
				Reporter.setCurrentTestResult(TestResult);
				Reporter.log("<a href=\"" + filepath + "\">" +filepath + "</a>");
				//sendMail();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}



		}
		//driver.close();
		//driver.quit();
		

	}
	//@AfterClass(alwaysRun = true)
	/*public void sendMail() throws MessagingException, EmailException, FileNotFoundException
	{
		String username="jaykishan.kiwiqa@gmail.com";
		String password="J@ckdave199110";
		String from_Email="jaykishan.kiwiqa@gmail.com";
		String to_Email="jaykishan.kiwiqa@gmail.com";
		//String htmlEmailTemplate = "D:\\Automation\\Flipkart\\FlipKartReport\\test-output\\emailable-report-new.html";
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		email.setFrom(from_Email);
		email.setSubject("This is a test mail ... :-)");
		//email.setContent(flipkartReporter, flipkartReporter.startResultSummaryTable("methodOverview"));
		//email.setMsg(htmlEmailTemplate);
		email.setHtmlMsg(Common.email());
		
		
		email.addTo(to_Email);
		email.send();
		//test
// testing
		
	}*/
	
	
	
	
	
	
	
	

}
