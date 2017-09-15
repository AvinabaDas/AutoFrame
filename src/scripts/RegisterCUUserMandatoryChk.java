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

public class RegisterCUUserMandatoryChk extends Driver{
	

		
//	@SuppressWarnings("unused")
	public static void mandatoryErrorChk() 
	
	{
		System.out.println("Register User Error Check");
		//String DuplicacyChk = "";
		try{
			
			testSuiteName="RegisterCUUserMandatoryChk";
			testCaseName="mandatoryErrorChk";
			
			String titel=driver.getTitle();
			System.out.println("tite"+titel);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Dasboard.userMgmt)).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(Dasboard.createUser)).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id(RegisterUser.userTypeCu)).click();
			Thread.sleep(2000);
			
			
			driver.findElement(By.xpath(RegisterUser.submitBtn)).click();
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
