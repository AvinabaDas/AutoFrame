package scripts;

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
import objectRepository.LoginPage;
import objectRepository.Dasboard;;

@SuppressWarnings("unused")
public class LoginToApplication extends Driver{
	
	
//	@SuppressWarnings("unused")
	public static void login(String[] data,String[] assertion) 
	
	{
		System.out.println("Login");
		
		try{
			
			testSuiteName="LoginToApplication";
			testCaseName="Login";
			HTMLReport.startTest(testSuiteName,testCaseName);
			
			String tite=driver.getTitle();
			System.out.println("tite"+tite);
			
			HTMLReport.logTest("LoginPage", "Admin Login Page", "INFO", "Title", ""+tite, "");
			
			driver.findElement(By.id(LoginPage.username)).sendKeys(data[0]);
			Thread.sleep(500);
			String UserName = driver.findElement(By.id(LoginPage.username)).getAttribute("value");
			System.out.println (""+UserName);
			HTMLReport.logTest("LoginPage", "UserName", "INFO", "KeyedInput", ""+UserName, "");
			driver.findElement(By.id(LoginPage.password)).sendKeys(data[1]);
			Thread.sleep(500);
			String Password = driver.findElement(By.id(LoginPage.password)).getAttribute("value");
			HTMLReport.logTest("LoginPage", "Password", "INFO", "KeyedInput", ""+Password, "");
			driver.findElement(By.xpath(LoginPage.submitBtn)).click();
			HTMLReport.logTest("LoginPage", "SubmitButton", "INFO", "ButtonClick", "Submit Button Clicked", "");
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
				HTMLReport.logTest("Login", "Login to Application", "PASS", "Login", "Login Successfull.", "");
				
			}else{
				
				Result="Fail";
				HTMLReport.logTest("Login", "Login to Application", "Fail", "Login", "Login Failed.", "");
				
			}
			
			ExcelReport.reportGeneration(testSuiteName, testCaseName, Result);
			ExcelReport.screenShot(testCaseName);
			HTMLReport.endTest();
			
			
		}catch(Exception e){
			
			System.out.println(e);
			try {
				ExcelReport.screenShot("Error"+testCaseName);
			} catch (HeadlessException | IOException | AWTException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	

}
