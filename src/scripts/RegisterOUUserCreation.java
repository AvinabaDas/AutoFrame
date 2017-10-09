package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.RegisterUser;

public class RegisterOUUserCreation extends Driver{
	
	public static void userSetupOUUser() 
	{
		try
		{
			testSuiteName="RegisterOUUserCreation";
			testCaseName="userSetupOUUser";
			HTMLReport.startTest(testSuiteName,testCaseName);
					
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.OUuserMgmt)).click();
				System.out.println("User Mgmt Clicked");
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.createUser)).click();
				System.out.println("Crt Usr Clicked");
				Thread.sleep(2000);
				//driver.findElement(By.id(RegisterUser.userTypeOu)).click();
				//System.out.println("BBOU rd Button Clicked");
				//Thread.sleep(2000);
				
			
			}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	//**CU Admin Data Entry and submission **//
	
	public static void BBOUUserSubmission(String[] data,String[] assertion) 
	
	{
		
		System.out.println("BBOU User Creation");
						
		try{
			
			testSuiteName="RegisterOUUserCreation";
			testCaseName="BBOUUserSubmission";
			
			userSetupOUUser();
			
			
			driver.findElement(By.id(RegisterUser.loginId)).sendKeys(data[0]);
			System.out.println("user id entered");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).click();
			System.out.println("Clicked");
			Thread.sleep(2000);
			driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).sendKeys(Keys.TAB);
			System.out.println("Tab to Orgid");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(RegisterUser.OUID)).sendKeys(Keys.TAB);
			System.out.println("Clicked");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.userName)).sendKeys(data[1]);
		    driver.findElement(By.id(RegisterUser.userName)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for First Name");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.lastName)).sendKeys(data[2]);
		    driver.findElement(By.id(RegisterUser.lastName)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for last Name");						
			Thread.sleep(2000);
					
			driver.findElement(By.id(RegisterUser.emailId)).sendKeys(data[3]);
			System.out.println("Value Inputed for Email");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(data[4]);
			System.out.println("Value Inputed for mobileNo");						
			Thread.sleep(2000);
	
			driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(data[5]);
			System.out.println("Value Inputed for departmnt");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.desglst)).sendKeys(data[6]);
			driver.findElement(By.id(RegisterUser.desglst)).sendKeys(Keys.TAB);
			System.out.println("Value Inputed for designation");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(RegisterUser.OUsubmitBtn)).click();
			System.out.println("Clicked Submit Button");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(RegisterUser.popupOk)).click();
			System.out.println("Clicked Ok Button");
			Thread.sleep(2000);
			
			String submitsuccess = "New user RB02_user100 has been created successfully and waiting for approval.";
			String submitsuccessVal = driver.findElement(By.xpath(RegisterUser.msgSuccess)).getText();
			
			if (submitsuccessVal.equals(submitsuccess))
			{
			Result = "Pass";
			Thread.sleep(2000);
			}
			else
			{
			Result = "Fail";
			Thread.sleep(2000);
			}
			driver.findElement(By.xpath(Dasboard.home)).click();
			ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
			ExcelReport.screenShot(testCaseName);
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
	
	}
		//**OU Admin Data Entry and submission **//
		
			
	
	}
