package ExealReading;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IExtentTestClass;
import com.relevantcodes.extentreports.LogStatus;

import Browser_Inti.HeroBrowser_Inti;
import ProjectObjectModel.HeroPOM;

public class NewTest {
	WebDriver driver;
	ExtentReports ext;
	ExtentTest test;
	@BeforeSuite
	public void extendReports() {
		 ext= new ExtentReports("C:\\Users\\fokhr\\eclipse-workspace\\MavenProject_class\\target\\report.html");
		 test =ext.startTest("Sobuj");
	}
	@BeforeMethod
	public void runBrowser() throws IOException  {
		driver= new ChromeDriver();
		HeroBrowser_Inti b = new HeroBrowser_Inti();
		driver=b.browser_int();
		}
	@AfterSuite
	public void aftersuiteExtend() {
		ext.endTest(test);
		ext.flush();
		
	}
  @Test
  public void LoginFromExcel() throws IOException {
	  test.log(LogStatus.PASS, "test");
	  FileInputStream file= new FileInputStream("C:\\Users\\fokhr\\Desktop\\Execute Excel files\\Book 7.xlsx");
	  XSSFWorkbook workbook= new XSSFWorkbook(file);
      XSSFSheet sheet= workbook.getSheetAt(0);
      String username= sheet.getRow(0).getCell(0).getStringCellValue();
      String password= sheet.getRow(0).getCell(1).getStringCellValue();
      System.out.println("Get username : "+username +"     Get password :"+ password);
      
      HeroPOM hero= new HeroPOM(driver);
      hero.username(username);
      hero.password(password);
      hero.clik();
      
  }
}
