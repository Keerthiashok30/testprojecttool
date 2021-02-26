package com.autodesk.testproject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrm.gnericlib.BaseClass;
import com.hrm.gnericlib.ExcelUtility;
import com.hrm.gnericlib.JavaUtility;
import com.hrm.gnericlib.WebdriverUtility;
import com.hrm.objectrepositrylib.AddAParameter;
import com.hrm.objectrepositrylib.CreateANewProject;
import com.hrm.objectrepositrylib.Home;
import com.hrm.objectrepositrylib.NewFolder;

@Listeners(com.hrm.gnericlib.ITestListenerImp.class)
public class CreateFolder extends BaseClass {

	@Test
	/**
	 * to create new folder
	 */
	public void createFolder() {
		Home homepage = new Home(driver);
		WebdriverUtility wlib = new WebdriverUtility();
		NewFolder newfold = new NewFolder(driver);
		ExcelUtility excel = new ExcelUtility();
		JavaUtility java = new JavaUtility();
		CreateANewProject project = new CreateANewProject(driver);

		try {

			homepage.getProjectarrow().click();
			homepage.getCreateproject().click();

			String projectname = excel.getExcelData("CreateProject", 1, 0) + java.generateRandomNum();
			project.getNameproject().sendKeys(projectname);
			project.getCreateproject().click();

			wlib.waitAndClick(driver, homepage.getNewfolder());

			wlib.waitforElement(newfold.getName());

			String foldername = excel.getExcelData("NewFolder", 1, 0) + java.generateRandomNum();
			newfold.getName().sendKeys(foldername);
			newfold.getAdd().click();

			WebElement folderpresent = driver.findElement(By.xpath("//span[contains(text(),'" + foldername + "')]"));

			wlib.waitforElement(folderpresent);
			Assert.assertTrue(folderpresent.isDisplayed());

		} catch (Throwable e) {

			e.printStackTrace();
		}

	}

}