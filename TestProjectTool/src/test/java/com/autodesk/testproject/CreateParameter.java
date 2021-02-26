package com.autodesk.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.gnericlib.BaseClass;
import com.hrm.gnericlib.ExcelUtility;
import com.hrm.gnericlib.JavaUtility;
import com.hrm.objectrepositrylib.AddAParameter;
import com.hrm.objectrepositrylib.CreateANewProject;
import com.hrm.objectrepositrylib.Home;

@Listeners(com.hrm.gnericlib.ITestListenerImp.class)
public class CreateParameter extends BaseClass {

	@Test
	/**
	 * to create parameter for particular project
	 **/
	public void addparameter() {
		Home homepage = new Home(driver);
		CreateANewProject project = new CreateANewProject(driver);
		ExcelUtility excel = new ExcelUtility();
		JavaUtility java = new JavaUtility();
		AddAParameter param = new AddAParameter(driver);

		try {

			homepage.getProjectarrow().click();
			homepage.getCreateproject().click();

			String projectname = excel.getExcelData("CreateProject", 1, 0) + java.generateRandomNum();
			project.getNameproject().sendKeys(projectname);
			project.getCreateproject().click();

			WebElement projectpresent = driver.findElement(By.xpath("//div[@title='" + projectname + "']"));
			wlib.waitforElement(projectpresent);
			Assert.assertTrue(projectpresent.isDisplayed());

			homepage.getParameter().click();
			homepage.getAddparameter().click();
			String parametername = excel.getExcelData("Parameter", 1, 0);
			param.getParamname().sendKeys(parametername);
			String parametervalue = excel.getExcelData("Parameter", 1, 1);
			param.getParamvalue().sendKeys(parametervalue);
			param.getParamcreate().click();

			WebElement parampresent = driver.findElement(By.xpath("//div[contains(text(),'" + parametername + "')]"));
			wlib.waitforElement(parampresent);
			Assert.assertTrue(parampresent.isDisplayed());

		} catch (Throwable e) {

			e.printStackTrace();
		}
	}
}
