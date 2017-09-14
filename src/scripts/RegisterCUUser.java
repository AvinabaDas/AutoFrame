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

public class RegisterCUUser extends Driver{
	
	
	//**User ID Duplicacy Check **//
	
	@SuppressWarnings("unused")
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
						
				
			driver.findElement(By.xpath(Dasboard.home)).click();
			FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
			FrameworkFunctions.screenShot(testCaseName);
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
			
	}	
	//**Emp ID Duplicacy Check **//
		
		public static void DuplicacyChkEmp(String[] data,String[] assertion) 
		
		{
			System.out.println("Register User Emp ID Duplicacy Check");
			//String DuplicacyChk = "";
			try{
				
				testSuiteName="RegisterCUUser";
				testCaseName="DuplicacyChkEmp";
				
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
			
				driver.findElement(By.id(RegisterUser.empId)).sendKeys(data[0]);
				driver.findElement(By.id(RegisterUser.empId)).sendKeys(Keys.TAB);
				System.out.println("Value Inputed");						
				Thread.sleep(2000);
													
				String ChkValueEmp = driver.findElement(By.xpath(RegisterUser.empIderr)).getText();
				System.out.println("Value is : "+ChkValueEmp);
				String ExpectedValueEmp = "Another user with the same employee id exists in the system.";
				String ChkValueEmpDup = "";
				if (ChkValueEmp.equals(ExpectedValueEmp))
				{
					driver.findElement(By.xpath(Dasboard.userMgmt)).click();
					ChkValueEmpDup = driver.findElement(By.xpath(RegisterUser.empIderr)).getText();
					System.out.println("Empl ID negative:" + ChkValueEmpDup);
					Result = ChkValueEmpDup;
					Thread.sleep(2000);
				}
				else
				{
					ChkValueEmpDup = driver.findElement(By.xpath(RegisterUser.empIdsucc)).getText();
					System.out.println("Empl ID positive:" + ChkValueEmpDup);
					Result = ChkValueEmpDup;
					Thread.sleep(2000);
				}
				
	
				driver.findElement(By.xpath(Dasboard.home)).click();
				FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
				FrameworkFunctions.screenShot(testCaseName);
				
			}catch(Exception e){
				
				System.out.println(e);
				
			}
		
	
					
			//Assert and write Report to File
			
			/** if(titel.equalsIgnoreCase("Dashboard"))
			{
				Result="Pass";
				
			}else{
				
				Result="Fail";
				
			}**/
			
					
			
			
			
		
		}
		
		
	public static void DuplicacyChkEmail(String[] data,String[] assertion) 
		
		{
			System.out.println("Register User Email ID Duplicacy Check");
			//String DuplicacyChk = "";
			try{
				
				testSuiteName="RegisterCUUser";
				testCaseName="DuplicacyChkEmail";
				
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
			
				driver.findElement(By.id(RegisterUser.emailId)).sendKeys(data[0]);
				driver.findElement(By.id(RegisterUser.emailId)).sendKeys(Keys.TAB);
				System.out.println("Value Inputed");						
				Thread.sleep(2000);
													
				String ChkValueEmail = driver.findElement(By.xpath(RegisterUser.empIderr)).getText();
				System.out.println("Value is : "+ChkValueEmail);
				String ExpectedValueEmp = "Another user with the same email id exists in the system.";
				String ChkValueEmailDup = "";
				if (ChkValueEmail.equals(ChkValueEmailDup))
				{
					driver.findElement(By.xpath(Dasboard.userMgmt)).click();
					ChkValueEmailDup = driver.findElement(By.xpath(RegisterUser.emailiderr)).getText();
					System.out.println("Empl ID negative:" + ExpectedValueEmp);
					Result = ChkValueEmailDup;
					Thread.sleep(2000);
				}
				else
				{
					ChkValueEmailDup = driver.findElement(By.xpath(RegisterUser.emailidavail)).getText();
					System.out.println("Empl ID positive:" + ExpectedValueEmp);
					Result = ChkValueEmailDup;
					Thread.sleep(2000);
				}
				
	
				driver.findElement(By.xpath(Dasboard.home)).click();
				FrameworkFunctions.reportGeneration(testSuiteName, testCaseName, Result);
				FrameworkFunctions.screenShot(testCaseName);
				
			}catch(Exception e){
				
				System.out.println(e);
				
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
