package com.comcast.crm.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppotunityPopupPage {
	
	WebDriver driver;
	
	public OppotunityPopupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchtxtifeld;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebElement getsearchtxtifeld()
	{
		return searchtxtifeld;
	}
	
	public WebElement getsearchBtn()
	{
		return searchBtn;
	}
	

}
