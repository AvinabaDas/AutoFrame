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

public class RegisterCUUserCreation extends Driver{
	
	public static void userSetup() 
	{
		try
		{
			testSuiteName="RegisterCUUserCreation";
			testCaseName="userSetup";
			HTMLReport.startTest(testSuiteName,testCaseName);
			
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.userMgmt)).click();
				HTMLReport.logTest("User Management menu", "user mgmt Menu", "PASS", "click", "User Manegment Clicked", "");
				System.out.println("User Mgmt Clicked");
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.createUser)).click();
				System.out.println("Crt Usr Clicked");
				HTMLReport.logTest("User Management Menu", "Create Menu", "PASS", "click", "Create User menu Clicked Clicked", "");
				Thread.sleep(2000);
				driver.findElement(By.id(RegisterUser.userTypeCu)).click();
				System.out.println("BBCU rd Button Clicked");
				HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU Radio Button Selected", "", "");
				Thread.sleep(2000);
				
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				HTMLReport.endTest();
				ExcelReport.screenShot(testCaseName);
			
			}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	
	//**CU Admin Data Entry and submission **//
	
	
	public static void BBCUAdminUserSubmission(String[] data,String[] assertion) throws HeadlessException, IOException, AWTException 
	
	{
		
		System.out.println("BBCU Admin User Creation");
						
		try{
			
			testSuiteName="RegisterCUUserCreation";
			testCaseName="BBCUAdminUserSubmission";
					
			userSetup();
			
			HTMLReport.startTest(testSuiteName,testCaseName);
			
			driver.findElement(By.id(RegisterUser.loginId)).sendKeys(data[0]);
			System.out.println("Value Inputed");
			HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "Login ID Entered", "");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).click();
		//	driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).sendKeys(Keys.TAB);
			System.out.println("Clicked");
			HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "checkAvailibilitybtn", "Clicked");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.empId)).sendKeys(data[1]);
		    driver.findElement(By.id(RegisterUser.empId)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for Emp ID");						
		    HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "EMP ID", "Entered");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.userName)).sendKeys(data[2]);
		    driver.findElement(By.id(RegisterUser.userName)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for First Name");						
		    HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "First Name", "Value Inputed");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.lastName)).sendKeys(data[3]);
		    driver.findElement(By.id(RegisterUser.lastName)).sendKeys(Keys.TAB);
		    System.out.println("Value Inputed for last Name");						
		    HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "last Name", "Value Inputed");
		    Thread.sleep(2000);
					
			driver.findElement(By.id(RegisterUser.emailId)).sendKeys(data[4]);
		    System.out.println("Value Inputed for Email");
		    HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "Email ID", "Value Inputed");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(data[5]);
			System.out.println("Value Inputed for mobileNo");
			HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "mobileNo", "Value Inputed");
			Thread.sleep(2000);
	
			driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(data[6]);
			System.out.println("Value Inputed for departmnt");						
			HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "Departmnt", "Value Chosen from the dropdown");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.desglst)).sendKeys(data[7]);
			System.out.println("Value Inputed for designation");						
			HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "Designation", "Value Chosen from the dropdown");
			Thread.sleep(2000);
			
			
			driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(data[8]);
		//	driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(Keys.TAB);
			System.out.println("Value selected for Admin_User");		
			HTMLReport.logTest("User Management", "Create User", "INFO", "BBCU User Creation ", "Admin Dropdown", "Value No selected from the dropdown");
			Thread.sleep(2000);
			
		
			driver.findElement(By.xpath(RegisterUser.submitBtn)).click();
			System.out.println("Clicked Submit Button");
			HTMLReport.logTest("User Management", "Create User", "PASS", "BBCU User Creation ", "Submit Button", "Clicked");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(RegisterUser.popupOk)).click();
			System.out.println("Clicked Ok Button");
			HTMLReport.logTest("User Management", "Create User", "PASS", "BBCU User Creation ", "OK Button", "Clicked");
			Thread.sleep(2000);
			
			String submitsuccess = "New user BBCU_hirasen has been created successfully and waiting for approval.";
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
			
			
			
		}catch(Exception e){
			
			System.out.println(e);
			HTMLReport.logTest("User Management", "Create User", "FAIL", "Dashboard", "" +e, "");
			
		}
	
		ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
		ExcelReport.screenShot(testCaseName);
		HTMLReport.endTest();
	}
		//**CU Admin Data Entry and submission **//
		
		
		public static void BBCUUserSubmission(String[] data,String[] assertion) 
		
		{
			
			System.out.println("BBCU Admin User Creation");
							
			try{
				
				testSuiteName="RegisterCUUserCreation";
				testCaseName="BBCUUserSubmission";
				
				userSetup();
				
				driver.findElement(By.id(RegisterUser.loginId)).sendKeys(data[0]);
				System.out.println("Value Inputed");
				Thread.sleep(2000);
				
				driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).click();
				driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).sendKeys(Keys.TAB);
				System.out.println("Clicked");
				Thread.sleep(2000);
				
				driver.findElement(By.id(RegisterUser.empId)).sendKeys(data[1]);
			    driver.findElement(By.id(RegisterUser.empId)).sendKeys(Keys.TAB);
			    System.out.println("Value Inputed for Emp ID");						
				Thread.sleep(2000);
				
				driver.findElement(By.id(RegisterUser.userName)).sendKeys(data[2]);
			    driver.findElement(By.id(RegisterUser.userName)).sendKeys(Keys.TAB);
			    System.out.println("Value Inputed for First Name");						
				Thread.sleep(2000);
				
				driver.findElement(By.id(RegisterUser.lastName)).sendKeys(data[3]);
			    driver.findElement(By.id(RegisterUser.lastName)).sendKeys(Keys.TAB);
			    System.out.println("Value Inputed for last Name");						
				Thread.sleep(2000);
						
				driver.findElement(By.id(RegisterUser.emailId)).sendKeys(data[4]);
			//	driver.findElement(By.id(RegisterUser.emailId)).sendKeys(Keys.TAB);
				System.out.println("Value Inputed for Email");						
				Thread.sleep(2000);
				
				driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(data[5]);
		//		driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(Keys.TAB);
				System.out.println("Value Inputed for mobileNo");						
				Thread.sleep(2000);
		
				driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(data[6]);
			//	driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(Keys.TAB);
				System.out.println("Value Inputed for departmnt");						
				Thread.sleep(2000);
				
				driver.findElement(By.id(RegisterUser.desglst)).sendKeys(data[7]);
		//		driver.findElement(By.id(RegisterUser.desglst)).sendKeys(Keys.TAB);
				System.out.println("Value Inputed for designation");						
				Thread.sleep(2000);
				
				
				driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(data[8]);
			//	driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(Keys.TAB);
				System.out.println("Value selected for Admin_User");						
				Thread.sleep(2000);
				
			
				driver.findElement(By.xpath(RegisterUser.submitBtn)).click();
			//	System.out.println("Clicked Submit Button");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath(RegisterUser.popupOk)).click();
				System.out.println("Clicked Ok Button");
				Thread.sleep(2000);
				
				String submitsuccess = "New user BBCU_hiraroy has been created successfully and waiting for approval.";
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
		//		driver.findElement(By.xpath(Dasboard.home)).click();
				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
				ExcelReport.screenShot(testCaseName);
				
			}catch(Exception e){
				
				System.out.println(e);
				
			}
		

			
	
	}
	
	
	
	}
