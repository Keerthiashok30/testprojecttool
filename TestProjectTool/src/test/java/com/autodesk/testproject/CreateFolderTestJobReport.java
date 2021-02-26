package com.autodesk.testproject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.gnericlib.BaseClass;
import com.hrm.gnericlib.ExcelUtility;
import com.hrm.gnericlib.JavaUtility;
import com.hrm.gnericlib.WebdriverUtility;
import com.hrm.objectrepositrylib.CreateANewJob;
import com.hrm.objectrepositrylib.CreateANewProject;
import com.hrm.objectrepositrylib.CreateANewTest;
import com.hrm.objectrepositrylib.EditPopup;
import com.hrm.objectrepositrylib.Home;
import com.hrm.objectrepositrylib.NewFolder;

@Listeners(com.hrm.gnericlib.ITestListenerImp.class)
public class CreateFolderTestJobReport extends BaseClass {

	@Test
	public void createFolderTestJobReport() {
		Home homepage = new Home(driver);
		WebdriverUtility wlib = new WebdriverUtility();
		NewFolder newfold = new NewFolder(driver);
		ExcelUtility excel = new ExcelUtility();
		JavaUtility java = new JavaUtility();
		CreateANewTest test = new CreateANewTest(driver);
		CreateANewJob job = new CreateANewJob(driver);
		Actions act = new Actions(driver);
		CreateANewProject project = new CreateANewProject(driver);
		EditPopup edit = new EditPopup(driver);

		try {

			homepage.getProjectarrow().click();
			homepage.getCreateproject().click();

			String projectname = excel.getExcelData("CreateProject", 1, 0) + java.generateRandomNum();
			project.getNameproject().sendKeys(projectname);
			project.getCreateproject().click();

			WebElement projectpresent = driver.findElement(By.xpath("//div[@title='" + projectname + "']"));
			wlib.waitforElement(projectpresent);
			Assert.assertTrue(projectpresent.isDisplayed());

			wlib.waitAndClick(driver, homepage.getNewfolder());

			wlib.waitforElement(newfold.getName());

			String foldername = excel.getExcelData("NewFolder", 1, 0) + java.generateRandomNum();
			newfold.getName().sendKeys(foldername);
			newfold.getAdd().click();

			WebElement folderpresent = driver.findElement(By.xpath("//span[contains(text(),'" + foldername + "')]"));

			wlib.waitforElement(folderpresent);
			Assert.assertTrue(folderpresent.isDisplayed());

			folderpresent.click();
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
			test.getEdit().click();
			test.getStartediting().click();
			edit.getSaveandexit().click();

			System.out.println("test is created");

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

			driver.findElement(By.xpath("//div[text()='" + jobname + "']")).click();

			driver.findElement(By.xpath("//div[text()='" + jobname + "']//..//..//..//..//..//div[@title='Run']"))
					.click();

			Thread.sleep(30000);
			wlib.waitforElement(homepage.getReport());
			homepage.getReport().click();
			homepage.getRefreshbuttton().click();
			WebElement reportval = driver.findElement(By.xpath("//span[@title='" + jobname + "']"));
			wlib.waitforElement(reportval);
			reportval.click();

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

}
