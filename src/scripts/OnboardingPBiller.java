package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.ExcelReport;
import driver.Driver;
import objectRepository.Dasboard;
import objectRepository.OnboardingParentBiller;
import objectRepository.RegisterUser;

public class OnboardingPBiller extends Driver{
	
	public static void onboardingParentBiller() 
	{
		try
		{
			
				String titel=driver.getTitle();
				System.out.println("tite"+titel);
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.onboarding)).click();
				System.out.println("OnboardingClicked");
				Thread.sleep(2000);
				driver.findElement(By.xpath(Dasboard.onboardingParentBiller)).click();
				System.out.println("Onboarding Biller  Clicked");
				Thread.sleep(2000);
				
			
			}
		
			catch(Exception e){
				
				System.out.println(e);
		}
	}
	
	
	//**CU Admin Data Entry and submission **//
	
	
	public static void ParentBillerSubmission(String[] data,String[] assertion) 
	
	{
		
		System.out.println("BBCU Admin User Creation");
						
		try{
			
			testSuiteName="OnboardingPBiller";
			testCaseName="ParentBillerSubmission";
			
			onboardingParentBiller();
			
			driver.findElement(By.xpath(OnboardingParentBiller.billerName)).sendKeys(data[0]);
			System.out.println("billerName Inputed");
			Thread.sleep(2000);

			driver.findElement(By.xpath(OnboardingParentBiller.billerAliasName)).sendKeys(data[1]);
			System.out.println("billerAliasName Inputed");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.tanNo)).sendKeys(data[2]);
			System.out.println("tanNo Inputed");
			Thread.sleep(2000);
		
			driver.findElement(By.xpath(OnboardingParentBiller.billerCategory)).sendKeys(data[3]);
		    System.out.println("billerCategory Selected");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.ownership)).sendKeys(data[4]);
		    System.out.println("ownsership Selected");						
			Thread.sleep(2000);
						
			driver.findElement(By.xpath(OnboardingParentBiller.coverage)).sendKeys(data[5]);
		    System.out.println("coverage state Selected");						
			Thread.sleep(2000);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(document.body.scrollHeight,0)");
			
			driver.findElement(By.xpath(OnboardingParentBiller.statecoverageselection)).click();
			
			//Selection of multiple values from combo box	
			Select oSelect = new Select(driver.findElement(By.id("coverageState")));
			List<WebElement> oSize = oSelect.getOptions();
			int iListSize = oSize.size();
			for(int i =0; i < iListSize ; i++){
				String sValue = oSelect.getOptions().get(i).getText();
				for(int j =0; j < assertion.length ; j++){
				if (sValue.equals(assertion[j])){
					oSelect.selectByIndex(i);
				}
				}
				System.out.println(sValue);
			
				Thread.sleep(2000);
				
				}
			System.out.println("multipli state Selected");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.servicetaxreg)).sendKeys(data[6]);
		    System.out.println("servicetaxreg Selected");						
			Thread.sleep(2000);
						
			driver.findElement(By.xpath(OnboardingParentBiller.rocUIN)).sendKeys(data[7]);
		    System.out.println("ROCUIN Selected");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.avgticketSize)).sendKeys(data[8]);
		    System.out.println("avgticketSize entered");						
			Thread.sleep(2000);
						
			driver.findElement(By.xpath(OnboardingParentBiller.volPerDay)).sendKeys(data[9]);
		    System.out.println("volPerDay entered");						
			Thread.sleep(2000);
			
			/*Reg Address------*/
			driver.findElement(By.xpath(OnboardingParentBiller.regAddressline)).sendKeys(data[10]);
		    System.out.println("regAddressline entered");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.regState)).sendKeys(data[11]);
		    System.out.println("regState entered");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.regCity)).sendKeys(data[12]);
		    System.out.println("regCity entered");						
			Thread.sleep(2000);
			driver.findElement(By.xpath(OnboardingParentBiller.regPincode)).sendKeys(data[13]);
			System.out.println("regPincode entered");	
			Thread.sleep(2000);
			driver.findElement(By.xpath(OnboardingParentBiller.regPincode)).sendKeys(Keys.TAB);
			Thread.sleep(2000);
			
		//	driver.findElement(By.xpath(OnboardingParentBiller.regCountry)).sendKeys(Keys.TAB);
			//driver.findElement(By.xpath(OnboardingParentBiller.sameAsReg)).click();
			//System.out.println("sameAsReg entered");
			//Thread.sleep(2000);
			
			
			//*Comm Address------*/
		
			
			driver.findElement(By.xpath(OnboardingParentBiller.commAddressline)).sendKeys(data[14]);
		    System.out.println("commAddressline entered");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.commState)).sendKeys(data[15]);
		    System.out.println("commState entered");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.commCity)).sendKeys(data[16]);
		    System.out.println("commCity entered");						
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.commPincode)).sendKeys(data[17]);
			System.out.println("commPincode entered");	
			Thread.sleep(2000);
					
		//	driver.findElement(By.xpath(OnboardingParentBiller.commPincode)).sendKeys(Keys.TAB);
			//driver.findElement(By.xpath(OnboardingParentBiller.commState)).sendKeys(Keys.TAB);
			//System.out.println("commState entered");
			//Thread.sleep(2000);
			
			
			driver.findElement(By.xpath(OnboardingParentBiller.saveAsDraftbtn)).click();
			System.out.println("Clicked saveAsDraftbtn Button");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(OnboardingParentBiller.okbtn)).click();
			System.out.println("Clicked Ok Button");
			Thread.sleep(2000);
			
//			String submitsuccess = "New user BBCU_hirasen has been created successfully and waiting for approval.";
//			String submitsuccessVal = driver.findElement(By.xpath(Onboarding_ParentBiller.msgSuccess)).getText();
//			
//			if (submitsuccessVal.equals(submitsuccess))
//			{
//			Result = "Pass";
//			Thread.sleep(2000);
//			}
//			else
//			{
//			Result = "Fail";
//			Thread.sleep(2000);
//			}
//			driver.findElement(By.xpath(Dasboard.home)).click();
			ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
			ExcelReport.screenShot(testCaseName);
			
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}
	
	}
		//**CU Admin Data Entry and submission **//
		
		
//		public static void BBCUUserSubmission(String[] data,String[] assertion) 
//		
//		{
//			
//			System.out.println("BBCU Admin User Creation");
//							
//			try{
//				
//				testSuiteName="RegisterCUUserCreation";
//				testCaseName="BBCUUserSubmission";
//				
//				userSetup();
//				
//				driver.findElement(By.id(RegisterUser.loginId)).sendKeys(data[0]);
//				System.out.println("Value Inputed");
//				Thread.sleep(2000);
//				
//				driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).click();
//				driver.findElement(By.id(RegisterUser.checkAvailibilitybtn)).sendKeys(Keys.TAB);
//				System.out.println("Clicked");
//				Thread.sleep(2000);
//				
//				driver.findElement(By.id(RegisterUser.empId)).sendKeys(data[1]);
//			    driver.findElement(By.id(RegisterUser.empId)).sendKeys(Keys.TAB);
//			    System.out.println("Value Inputed for Emp ID");						
//				Thread.sleep(2000);
//				
//				driver.findElement(By.id(RegisterUser.userName)).sendKeys(data[2]);
//			    driver.findElement(By.id(RegisterUser.userName)).sendKeys(Keys.TAB);
//			    System.out.println("Value Inputed for First Name");						
//				Thread.sleep(2000);
//				
//				driver.findElement(By.id(RegisterUser.lastName)).sendKeys(data[3]);
//			    driver.findElement(By.id(RegisterUser.lastName)).sendKeys(Keys.TAB);
//			    System.out.println("Value Inputed for last Name");						
//				Thread.sleep(2000);
//						
//				driver.findElement(By.id(RegisterUser.emailId)).sendKeys(data[4]);
//			//	driver.findElement(By.id(RegisterUser.emailId)).sendKeys(Keys.TAB);
//				System.out.println("Value Inputed for Email");						
//				Thread.sleep(2000);
//				
//				driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(data[5]);
//		//		driver.findElement(By.id(RegisterUser.mobileNo)).sendKeys(Keys.TAB);
//				System.out.println("Value Inputed for mobileNo");						
//				Thread.sleep(2000);
//		
//				driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(data[6]);
//			//	driver.findElement(By.id(RegisterUser.departmntlst)).sendKeys(Keys.TAB);
//				System.out.println("Value Inputed for departmnt");						
//				Thread.sleep(2000);
//				
//				driver.findElement(By.id(RegisterUser.desglst)).sendKeys(data[7]);
//		//		driver.findElement(By.id(RegisterUser.desglst)).sendKeys(Keys.TAB);
//				System.out.println("Value Inputed for designation");						
//				Thread.sleep(2000);
//				
//				
//				driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(data[8]);
//			//	driver.findElement(By.id(RegisterUser.admnlst)).sendKeys(Keys.TAB);
//				System.out.println("Value selected for Admin_User");						
//				Thread.sleep(2000);
//				
//			
//				driver.findElement(By.xpath(RegisterUser.submitBtn)).click();
//			//	System.out.println("Clicked Submit Button");
//				Thread.sleep(2000);
//				
//				driver.findElement(By.xpath(RegisterUser.popupOk)).click();
//				System.out.println("Clicked Ok Button");
//				Thread.sleep(2000);
//				
//				String submitsuccess = "New user BBCU_hiraroy has been created successfully and waiting for approval.";
//				String submitsuccessVal = driver.findElement(By.xpath(RegisterUser.msgSuccess)).getText();
//				
//				if (submitsuccessVal.equals(submitsuccess))
//				{
//				Result = "Pass";
//				Thread.sleep(2000);
//				}
//				else
//				{
//				Result = "Fail";
//				Thread.sleep(2000);
//				}
//		//		driver.findElement(By.xpath(Dasboard.home)).click();
//				ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
//				ExcelReport.screenShot(testCaseName);
//				
//			}catch(Exception e){
//				
//				System.out.println(e);
//				
//			}
//		

			
	
	}
	
	
	
	
