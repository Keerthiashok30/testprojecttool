package com.autodesk.testproject;

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
import com.hrm.objectrepositrylib.CreateNewApplication;
import com.hrm.objectrepositrylib.EditPopup;
import com.hrm.objectrepositrylib.Home;
import com.hrm.objectrepositrylib.NewFolder;

@Listeners(com.hrm.gnericlib.ITestListenerImp.class)
public class AddApplicationTest extends BaseClass {
	@Test
	public void addApplicaionTest() {
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
		CreateNewApplication app = new CreateNewApplication(driver);

		try {

			homepage.getProjectarrow().click();
			homepage.getCreateproject().click();

			String projectname = excel.getExcelData("CreateProject", 1, 0) + java.generateRandomNum();
			project.getNameproject().sendKeys(projectname);
			project.getCreateproject().click();

			WebElement projectpresent = driver.findElement(By.xpath("//div[@title='" + projectname + "']"));
			wlib.waitforElement(projectpresent);
			Assert.assertTrue(projectpresent.isDisplayed());
			System.out.println(projectname);

			homepage.getApplication().click();
			homepage.getAddapplication().click();

			app.getWebapp().click();
			app.getNextapp().click();
			String appname = excel.getExcelData("AppName", 1, 0) + java.generateRandomNum();
			app.getAppname().sendKeys(appname);
			String appurl = excel.getExcelData("AppName", 1, 1);
			app.getAppurl().sendKeys(appurl);
			app.getFinish().click();

			homepage.getNewtest().click();

			test.getWeb().click();
			test.getNext().click();
			String testname = excel.getExcelData("CreateTest", 1, 0) + java.generateRandomNum();
			test.getName().sendKeys(testname);
			test.getNext().click();
			test.getWebapp().click();
			driver.findElement(By.xpath("//span[contains(text(),'" + appname + "')]")).click();
			test.getNext().click();
			test.getEdit().click();
			test.getStartediting().click();
			edit.getSaveandexit().click();

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

}
