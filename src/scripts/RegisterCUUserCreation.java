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

import commonFunctions.FrameworkFunctions;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.RegisterUser;

public class RegisterCUUserCreation extends Driver{
	
	public static void userSetup() 
	{
		try
		{
			
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
			
			}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	
	//**User ID Data Entry  **//
	
	
	public static void BBCUAdminUserSubmission(String[] data,String[] assertion) 
	
	{
		
		System.out.println("BBCU Admin User Creation");
						
		try{
			
			testSuiteName="BBCUAdminUserSubmission";
			testCaseName="BBCUAdmin_Creation";
			
		
			driver.findElement(By.id(RegisterUser.loginId)).sendKeys(data[0]);
			System.out.println("Value Inputed");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).click();
			driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).sendKeys(Keys.TAB);
			System.out.println("Clicked");
			Thread.sleep(2000);
			
			
			driver.findElement(By.id(RegisterUser.userName)).sendKeys(data[0]);
		    driver.findElement(By.id(RegisterUser.userName)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for First Name");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.lastName)).sendKeys(data[0]);
		    driver.findElement(By.id(RegisterUser.lastName)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for last Name");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.empId)).sendKeys(data[0]);
		    driver.findElement(By.id(RegisterUser.empId)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for Emp ID");						
			Thread.sleep(2000);
			
			
			driver.findElement(By.id(RegisterUser.emailId)).sendKeys(data[0]);
			driver.findElement(By.id(RegisterUser.emailId)).sendKeys(Keys.TAB);
			System.out.println("Value Inputed for Email");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(data[0]);
			driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(Keys.TAB);
			System.out.println("Value Inputed for mobileNo");						
			Thread.sleep(2000);
	
			driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(data[0]);
			driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(Keys.TAB);
			System.out.println("Value Inputed for departmnt");						
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.desglst)).sendKeys(data[0]);
			driver.findElement(By.id(RegisterUser.desglst)).sendKeys(Keys.TAB);
			System.out.println("Value Inputed for designation");						
			Thread.sleep(2000);
			
			
			driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(data[0]);
			driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(Keys.TAB);
			System.out.println("Value selected for Admin_User");						
			Thread.sleep(2000);
			
		
			driver.findElement(By.xpath(RegisterUser.submitBtn)).click();
			System.out.println("Clicked");
			Thread.sleep(2000);
			
			
	//		driver.findElement(By.xpath(Dasboard.home)).click();
			FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
			FrameworkFunctions.screenShot(testCaseName);
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
	

				
		
		
		/** if(titel.equalsIgnoreCase("Dashboard"))
		{
			Result="Pass";
			
		}else{
			
			Result="Fail";
			
		}**/
		
				
		
		
		
	
	}
	
	
	
	}
