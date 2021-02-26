package com.autodesk.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.gnericlib.BaseClass;
import com.hrm.gnericlib.ExcelUtility;
import com.hrm.gnericlib.IConstant;
import com.hrm.gnericlib.JavaUtility;
import com.hrm.objectrepositrylib.AddANewDataSource;
import com.hrm.objectrepositrylib.CreateANewJob;
import com.hrm.objectrepositrylib.CreateANewProject;
import com.hrm.objectrepositrylib.CreateANewTest;
import com.hrm.objectrepositrylib.Home;
import com.hrm.objectrepositrylib.OptionsOfTest;

@Listeners(com.hrm.gnericlib.ITestListenerImp.class)
public class CreateProjectAndTestDataSource extends BaseClass {
	@Test
	public void createProject() {
		Home homepage = new Home(driver);
		CreateANewProject project = new CreateANewProject(driver);
		ExcelUtility excel = new ExcelUtility();
		JavaUtility java = new JavaUtility();
		CreateANewTest test = new CreateANewTest(driver);
		CreateANewJob job = new CreateANewJob(driver);
		Actions act = new Actions(driver);
		OptionsOfTest optiontest = new OptionsOfTest(driver);
		AddANewDataSource datasource = new AddANewDataSource(driver);

		try {
			homepage.getProjectarrow().click();
			homepage.getCreateproject().click();

			String projectname = excel.getExcelData("CreateProject", 1, 0) + java.generateRandomNum();
			project.getNameproject().sendKeys(projectname);
			project.getCreateproject().click();

			WebElement projectpresent = driver.findElement(By.xpath("//div[@title='" + projectname + "']"));
			wlib.waitforElement(projectpresent);
			Assert.assertTrue(projectpresent.isDisplayed());

			homepage.getCreatetest().click();

			test.getWeb().click();
			test.getNext().click();
			String testname = excel.getExcelData("CreateTest", 1, 0) + java.generateRandomNum();
			test.getName().sendKeys(testname);
			test.getNext().click();
			test.getWebapp().click();
			test.getChooseapp().click();
			String appname = excel.getExcelData("AppName", 1, 0) + java.generateRandomNum();
			test.getAppname().sendKeys(appname);
			String appurl = excel.getExcelData("AppName", 1, 1);
			test.getAppurl().sendKeys(appurl);
			test.getFinish().click();
			test.getNext().click();
			test.getBlanktest().click();
			test.getCreate().click();

			WebElement testpresent = driver.findElement(By.xpath("//div[contains(text(),'" + testname + "')]"));
			wlib.waitforElement(testpresent);
			Assert.assertTrue(testpresent.isDisplayed());

			homepage.getAddjob().click();

			job.getWebjob().click();
			job.getNextjob().click();
			String jobname = excel.getExcelData("CreateJob", 1, 0) + java.generateRandomNum();
			job.getNamejob().sendKeys(jobname);
			job.getNextjob().click();
			job.getAgentbrowser().click();
			job.getCreatejob().click();
			WebElement src = driver.findElement(By.xpath("//div[contains(@title,'" + testname + "')]"));
			act.dragAndDrop(src, homepage.getDroptest()).perform();

			homepage.getDatasource().click();
			optiontest.getDatasource().click();
			optiontest.getAdddatasource().click();
			String dataname = excel.getExcelData("DataSource", 1, 0) + java.generateRandomNum();
			datasource.getDatasourcename().sendKeys(dataname);
			String datadescription = excel.getExcelData("DataSource", 1, 1) + java.generateRandomNum();
			datasource.getDatasourcedescription().sendKeys(datadescription);

			wlib.waitforElementToBeClickable(driver, datasource.getUploadfile());
			datasource.getUploadfile().sendKeys("C:\\Users\\DELL\\Downloads\\Sample Login TestParameters (1).csv");

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

}
