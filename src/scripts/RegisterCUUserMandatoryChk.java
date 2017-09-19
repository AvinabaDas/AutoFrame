package scripts;

// Archita

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.RegisterUser;

public class RegisterCUUserMandatoryChk extends Driver{
	

		
//	@SuppressWarnings("unused")
	public static void mandatoryErrorChk() 
	
	{
		
		testSuiteName="RegisterCUUserMandatoryChk";
		testCaseName="mandatoryErrorChk";
		HTMLReport.startTest(testSuiteName,testCaseName);

		
		try{
					
			String titel=driver.getTitle();
			System.out.println("tite"+titel);
			HTMLReport.logTest("RegisterUser Page", ""+titel, "INFO", "RegisterUser", "", "");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Dasboard.userMgmt)).click();
			HTMLReport.logTest("RegisterUser Page", "RegisterCUUserMandatoryChk", "INFO", "RegisterUser", "User Manegment Clicked", "");
			System.out.println("User Mgmt Clicked");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Dasboard.createUser)).click();
			System.out.println("Crt Usr Clicked");
			HTMLReport.logTest("RegisterUser Page", "RegisterCUUserMandatoryChk", "INFO", "RegisterUser", "Create User Clicked", "");
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.userTypeCu)).click();
			HTMLReport.logTest("RegisterUser Page", "RegisterUserSetup", "INFO", "RegisterUser", "BBCU Radio Button Clicked", "");
			System.out.println("BBCU rd Button Clicked");
			Thread.sleep(2000);
			
			
			driver.findElement(By.xpath(RegisterUser.submitBtn)).click();
			System.out.println("Clicked");
			HTMLReport.logTest("RegisterUser Page", "RegisterUser", "INFO", "RegisterUser", "Submit Button Clicked", "");
			Thread.sleep(2000);
			
			String username = "Please provide login Id.";
			String EmpId = "Please provide Employee Id.";
			String Fname = "Please provide First name .";
			String LName = "Please provide Last name.";
			String Email = "Please provide email id.";
			String Mobile = "Please provide mobile number .";
			String Dept = "Please select department.";
			String Desig = "Please select designation.";
			
			
			String usernameVal = driver.findElement(By.id(RegisterUser.loadedErrorResult)).getText();
			String EmpIdVal = driver.findElement(By.xpath(RegisterUser.empIderr)).getText();
			String FnameVal = driver.findElement(By.xpath(RegisterUser.userNameerr)).getText();
			String LNameVal = driver.findElement(By.xpath(RegisterUser.lastNameerr)).getText();
			String EmailVal = driver.findElement(By.xpath(RegisterUser.emailiderr)).getText();
			String MobileVal = driver.findElement(By.xpath(RegisterUser.moberr)).getText();
			String DeptVal = driver.findElement(By.xpath(RegisterUser.depterr)).getText();
			String DesigVal = driver.findElement(By.xpath(RegisterUser.designerr)).getText();
			
			String TotalVal = usernameVal + EmpIdVal + FnameVal + LNameVal + EmailVal + MobileVal + DeptVal + DesigVal ;
			String Total = username + EmpId + Fname + LName + Email + Mobile + Dept + Desig ;
			
			
			if (Total.equals(TotalVal))
				{
				Result = "Pass";
				Thread.sleep(2000);
			}
			else
			{
				Result = "Fail";
				Thread.sleep(2000);
			}
			
						
			ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
			ExcelReport.screenShot(testCaseName);
			
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
