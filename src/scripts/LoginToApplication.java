package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.FrameworkFunctions;
import driver.Driver;
import objectRepository.LoginPage;
import objectRepository.Dasboard;;

public class LoginToApplication extends Driver{
	
	
//	@SuppressWarnings("unused")
	public static void login(String[] data,String[] assertion) 
	
	{
		System.out.println("Login");
		
		try{
			
			testSuiteName="LoginToApplication";
			testCaseName="Login";
			
			String tite=driver.getTitle();
			System.out.println("tite"+tite);
			
			driver.findElement(By.id(LoginPage.username)).sendKeys(data[0]);
			driver.findElement(By.id(LoginPage.password)).sendKeys(data[1]);
			driver.findElement(By.xpath(LoginPage.submitBtn)).click();
			
			Thread.sleep(500);
			//WebDriver webDriver = null;
			//WebDriverWait wait = new WebDriverWait(webDriver, 60);
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Dasboard.helthInfo))));
			
			System.out.println("assertion is "+assertion[0]);
			//System.out.println("HelthInfo is  "+driver.findElement(By.xpath(Dasboard.helthInfo)));
			
			String titel=driver.getTitle();
			System.out.println("titel"+titel);		
			//Assert and write Report to File
			
			if(titel.equalsIgnoreCase("Dashboard"))
			{
				Result="Pass";
				
			}else{
				
				Result="Fail";
				
			}
			
			FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
			FrameworkFunctions.screenShot(testCaseName);
			
			
		}catch(Exception e){
			
			System.out.println(e);
			try {
				FrameworkFunctions.screenShot("Error"+testCaseName);
			} catch (HeadlessException | IOException | AWTException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	

}
