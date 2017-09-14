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
import objectRepository.Dasboard;
import objectRepository.RegisterUser;

public class Register extends Driver{
	
	
	
	
//	@SuppressWarnings("unused")
	public static void DuplicacyChk(String[] data,String[] assertion) 
	
	{
		System.out.println("Register User Duplicacy Check");
		String DuplicacyChk = "";
		try{
			
			testSuiteName="Register";
			testCaseName="DuplicacyChk";
			
			String titel=driver.getTitle();
			System.out.println("tite"+titel);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dasboard.userMgmt)).click();
			System.out.println("User Mgmt Clicked");
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dasboard.createUser)).click();
			System.out.println("Crt Usr Clicked");
			Thread.sleep(2000);
			driver.findElement(By.id(RegisterUser.userTypeCu)).click();
			System.out.println("BBCU rd Button Clicked");
			Thread.sleep(2000);
			driver.findElement(By.id(RegisterUser.loginId)).sendKeys(data[0]);
			System.out.println("Value Inputed");
			Thread.sleep(2000);
			driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).click();
			System.out.println("Clicked");
			Thread.sleep(2000);
			String ChkValue = driver.findElement(By.id(RegisterUser.loadedErrorResult)).getText();
			System.out.println("Value is : "+ChkValue);
			String ExpectedValue = "Duplicate login id, please provide another id";
			
			if (ChkValue.equals(ExpectedValue))
			{
				driver.findElement(By.xpath(Dasboard.userMgmt)).click();
				DuplicacyChk = driver.findElement(By.id(RegisterUser.loadedErrorResult)).getText();
				System.out.println(DuplicacyChk);
				Result = DuplicacyChk;
				Thread.sleep(2000);
			}
			else
			{
				DuplicacyChk = driver.findElement(By.id(RegisterUser.loadedSuccessResult)).getText();
				System.out.println(DuplicacyChk);
				Result = DuplicacyChk;
				Thread.sleep(2000);
			}
			
			
			
			
			FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
			FrameworkFunctions.screenShot(testCaseName);
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
			
		if(DuplicacyChk.contains("Duplicate"))
		{
			System.out.println("Duplicate CHk Failed");
		}
		else if(DuplicacyChk.equalsIgnoreCase("available "))
		{
			System.out.println("Duplicate CHk Passed");
		}
			
			//Assert and write Report to File
			
			/** if(titel.equalsIgnoreCase("Dashboard"))
			{
				Result="Pass";
				
			}else{
				
				Result="Fail";
				
			}**/
			
					
			
			
			
		
		}
		
	}
