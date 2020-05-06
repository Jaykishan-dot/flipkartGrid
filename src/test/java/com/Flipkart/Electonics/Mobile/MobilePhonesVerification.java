package com.Flipkart.Electonics.Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Flipkart.init.AbstractPage;

public class MobilePhonesVerification extends AbstractPage
{

	public MobilePhonesVerification(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//verify the 'X' button is available
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")  public WebElement loginX;
	public boolean showloginXbutton()
	{
		if(loginX.getText().equals("✕"))
		{
			System.out.println("This Statement is from MobilePhonesVerification..................................................................");
			return true;
		}
		else
		{
			return false;
		}
		
			
	}
	
	//Title
	@FindBy(xpath="//title[text()='Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!']")  public WebElement flipkartTitle;
	public boolean getFlipkartTitle()
	{
		
		if(flipkartTitle.getText().equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			System.out.println("This Statement is from MobilePhonesVerification.................................................................."+flipkartTitle.getText());
			return true;
		}
		else
		{
			System.out.println("This Statement is from MobilePhonesVerification fail statement.................................................................."+flipkartTitle.getText());
			return false;
		}
		
			
	}
	
	@FindBy(xpath="//span[text()='Electronics']") public WebElement ElectronicsMenu;
	public boolean showElectronicsMenu()
	{
		if(ElectronicsMenu.getText().equals("Electronics"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	
              
                
           
	

}
