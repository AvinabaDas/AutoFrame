package commonFunctions;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import driver.Driver;

/**
 * Automation Framework Driver class
 * @author Avinaba Das - BBPS
 *
 */

public class Report {

	public static int testPassCount = 0;
	public static int testFailCount = 0;
	static OutputStream htmlfile = null;
	static PrintStream printhtml = null;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest excelTest;
	public static String Path ="";
	public static String fileName ="";
	
	static FileOutputStream fileOut = null;
	
	public static Document doc;
	
	// Get current Date and append to file name
		public static Calendar calDate = Calendar.getInstance();
		public static Date currentDate = calDate.getTime();
		public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss");
		public static String dateNow = formatter.format(currentDate.getTime());
	//public static String TestReportsPath="";
	
		public static String testSuiteName="";
		public static String testCaseName="";
	
		public static String TSuiteName="";
		public static String TCaseName="";
		
	
	public static void initializeReport() {
		Path = Driver.TestReportsPath + "//Report.html";
		System.out.println(Path);
		extent = new ExtentReports(Path, true);
		fileName = Driver.TestReportsPath+"//Report_" + dateNow + ".xlsx";
		System.out.println("We are in");

	}
	
	public static void startTest(String testSuiteName, String testCaseName) {
		test = extent.startTest(testSuiteName,testCaseName);
		TSuiteName=testSuiteName;
		TCaseName=testCaseName;
		
		
	}
	
	public static void logTest(String name1, String name2, String name3, String name4, String name5, String name6)  {
		System.out.println("output ->" +name1 + "<->"+ name2 + "<->"+ name3 + "<->"+ name4 + "<->"+ name5 + "<->"+ name6);
		
		startTest(TSuiteName,TCaseName);
		
		String dtls;
		String status;
		if (name4.isEmpty())
			dtls = name5;
		else 
			dtls = name4+"::"+name5;
		
		//Excel Report Base Setup
		 try {
			
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("Automation Result");

				// First Row
				XSSFRow FirstRow = sheet.createRow(0);
				XSSFCell FirstRowcell = FirstRow.createCell(0);
				FirstRowcell.setCellValue("Automation Result Summary");

				// Second Row
				XSSFRow secondRow = sheet.createRow(1);
				XSSFCell secondRowcell = secondRow.createCell(0);
				secondRowcell.setCellValue("Browser Name :"+Driver.browserName);

				// ThirdRow
				XSSFRow thirdRow = sheet.createRow(2);
				XSSFCell thirdRowcell = thirdRow.createCell(0);
				thirdRowcell.setCellValue("Date and Time:" + dateNow);

				// Fifth Row (Result Header Row)
				XSSFRow headerRow = sheet.createRow(4);

				XSSFCell headerRowcellOne = headerRow.createCell(0);
				headerRowcellOne.setCellValue("TestSuitName");

				XSSFCell headerRowcellTwo = headerRow.createCell(1);
				headerRowcellTwo.setCellValue("TestCaseName");

				//XSSFCell headerRowcellThree = headerRow.createCell(2);
				//headerRowcellThree.setCellValue("Action");

				XSSFCell headerRowcellThree = headerRow.createCell(2);
				headerRowcellThree.setCellValue("Status");
				
				XSSFCell headerRowcellFour = headerRow.createCell(3);
				headerRowcellThree.setCellValue("StepName");
				
				XSSFCell headerRowcellFive = headerRow.createCell(4);
				headerRowcellThree.setCellValue("Details");
				
		//Excel Report Base Setup
		
		// Result Writing to Excel file

					XSSFRow rowForData = sheet.createRow(sheet.getLastRowNum() + 1);
					XSSFCell rowCellOne = rowForData.createCell(0);
					rowCellOne.setCellValue(TSuiteName);

					XSSFCell rowCellTwo = rowForData.createCell(1);
					rowCellTwo.setCellValue(TCaseName);

					XSSFCell rowCellThree = rowForData.createCell(2);
					rowCellThree.setCellValue(name3);
					
					XSSFCell rowCellFour = rowForData.createCell(3);
					rowCellThree.setCellValue(name1+"::"+name2);
					
					XSSFCell rowCellFive = rowForData.createCell(2);
					rowCellThree.setCellValue(dtls);
					

					File newFile = new File(fileName);
					if (!newFile.exists()) {
						fileOut = new FileOutputStream(fileName);
						workbook.write(fileOut);
						fileOut.flush();
						fileOut.close();
					} else {
						FileInputStream Newinput = new FileInputStream(fileName);
						XSSFWorkbook NewWb = new XSSFWorkbook(Newinput);
						XSSFSheet NewSheet = NewWb.getSheet("Automation Result");
						System.out.println("NewSheet" + NewSheet);

						int numberOfRows = NewSheet.getLastRowNum();
						System.out.println("numberOfRows " + numberOfRows);

						XSSFRow NewRow = NewSheet.createRow(numberOfRows + 1);

						XSSFCell cellNew1 = NewRow.createCell(0);
						cellNew1.setCellValue(testSuiteName);

						XSSFCell cellNew2 = NewRow.createCell(1);
						cellNew2.setCellValue(testCaseName);

						XSSFCell cellNew3 = NewRow.createCell(2);
						cellNew3.setCellValue(name3);
						
						XSSFCell cellNew4 = NewRow.createCell(3);
						cellNew3.setCellValue(name1+"::"+name2);
						
						XSSFCell cellNew5 = NewRow.createCell(4);
						cellNew3.setCellValue(dtls);

						//XSSFCell cellNew4 = NewRow.createCell(3);
						//cellNew4.setCellValue(result);

						fileOut = new FileOutputStream(fileName);
						NewWb.write(fileOut);

				 //
						//HTML Report Creation				
						
						
						switch (name3.toUpperCase()) {
							case 	"PASS" :
								 test.log(LogStatus.PASS, name1+"::"+name2, dtls);
								 break;
								 
							case 	"FAIL" :
								 test.log(LogStatus.FAIL, name1+"::"+name2, dtls + ":: Screenshot: <span style='font-weight:bold;'>"+name6+"</span>" );
								 break;

							case 	"INFO" :
								 test.log(LogStatus.INFO, name1+"::"+name2, dtls);
								 break;
						//HTML Report Creation
				 
		}
		}
		
			} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		}

	}
		
	public static void endTest() throws Exception {
		extent.endTest(test);        
        extent.flush();
        fileOut.flush();
	}

	public static void closeReport() throws Exception {
		extent.close();    
		fileOut.close();
	}
	public static void screenShot(String fileName) throws IOException, HeadlessException, AWTException
	{
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(Driver.AppScrinShotsPath+"\\"+fileName+"_"+dateNow+".png"));
		
	}
	}
