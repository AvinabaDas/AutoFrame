package scripts;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctions.ExcelReport;
import commonFunctions.HTMLReport;
import driver.Driver;
import objectRepository.LoginPage;
import objectRepository.Dasboard;;

public class LogoutFromApplication extends Driver{
	
	
	public static void logout() 
	
	{
		System.out.println("Logout");
		
		try{
			
			testSuiteName="LogoutFromApplication";
			testCaseName="logout";
			HTMLReport.startTest(testSuiteName,testCaseName);
			
			String titel=driver.getTitle();
			System.out.println("titel"+titel);
			HTMLReport.logTest("LogoutPage", "Admin Logout Page", "INFO", "Title", ""+titel, "");
			Thread.sleep(500);
			//WebDriver webDriver = null;
			//WebDriverWait wait = new WebDriverWait(webDriver, 60);
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(Dasboard.helthInfo))));
			
			//System.out.println("HelthInfo is  "+driver.findElement(By.xpath(Dasboard.helthInfo)));
			
					
			//Assert and write Report to File
			
			if(titel.equalsIgnoreCase("Dashboard"))
			{
				Result="Pass";
				
			}else{
				
				Result="Fail";
				
			}
			
			 WebElement element = driver.findElement(By.xpath(".//*[@id='rmenu']/div/div[1]/div/a/span"));
			 boolean status = element.isEnabled();
			 if (status = true)
			 {
				 HTMLReport.logTest("Dashboard Page", "LogoutLink", "INFO", "LinkClick", "Logout Link Found", "");
			 }
			 else
			 {
				 HTMLReport.logTest("Dashboard Page", "LogoutLink", "INFO", "LinkClick", "Logout Link Not Found", "");
			 }
			 
			 
		        Actions action = new Actions(driver);
		 
		        action.moveToElement(element).build().perform();
		 
		        driver.findElement(By.linkText("Log out")).click();
		        HTMLReport.logTest("Dashboard Page", "LogoutLink", "INFO", "LinkClick", "Logout Link Clicked", "");
		        
		        Thread.sleep(500);
			
			System.out.println("Byeeee");
			HTMLReport.logTest("LogoutPage", "Admin Logout Page", "PASS", "Logout", "Logout Successfull.",  "");
			driver.close();
			
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
