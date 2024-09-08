package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenerator {
	public static ExtentReports extent;
	public static ExtentTest logger;
	static int i = 1;
	public static ExtentTest test;

	public void startReport() {
		extent = new ExtentReports(
				"C:\\Users\\Administrator\\Desktop\\Capstoneproject\\jsonplaceholderapi\\src\\test\\resources\\reports\\report.html",true);
	}

	public void startTest() {
		logger = extent.startTest("test" + i);
		logger.log(LogStatus.PASS, "Test is pass");
		i++;

	}

	public void endTest() {
		extent.endTest(logger);
	}

	public void endReport() {
		extent.flush();
		extent.close();
	}
}
