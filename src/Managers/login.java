package Managers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class login extends paramenters {
	SoftAssert Myassertion = new SoftAssert();

	@Test(priority = 1)
	public void LoginAsManagerAndAddCustomer() {
		WebElement ManagerLogIN = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"));
		ManagerLogIN.click();
		WebElement AddCustomerButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));
		AddCustomerButton.click();
		WebElement FirstNameElement = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"));
		FirstNameElement.sendKeys(FirstName);

		WebElement LastNameElement = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));
		LastNameElement.sendKeys(LastName);

		String PostCodeASstring = Integer.toString(PostCode);

		WebElement PostCodeElement = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));
		PostCodeElement.sendKeys(PostCodeASstring);

		WebElement AddCustomerButton2 = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
		AddCustomerButton2.click();
		String PopUpAlert = driver.switchTo().alert().getText();
		Myassertion.assertEquals(PopUpAlert.contains("successfully"), true);
		driver.switchTo().alert().accept();
		Myassertion.assertAll();

	}

	@Test(priority = 2)

	public void OpenAccount() {
		WebElement OpenAccountButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]"));
		OpenAccountButton.click();

		WebElement SelectCustomerName = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select CustomerSelect = new Select(SelectCustomerName);
		CustomerSelect.selectByVisibleText(FirstName + " " + LastName);

		WebElement SelectCurrency = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		Select CurrencySelect = new Select(SelectCurrency);
		CurrencySelect.selectByVisibleText(Currency);
		WebElement ProcessButton = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
		ProcessButton.click();

		String AccountPopUpAlert = driver.switchTo().alert().getText();
		Myassertion.assertEquals(AccountPopUpAlert.contains("successfully"), true);
		driver.switchTo().alert().accept();
		Myassertion.assertAll();

	}

	@Test(priority = 3)
	public void CustomersPage() throws InterruptedException {

		WebElement CustomersButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"));
		CustomersButton.click();
		WebElement SearchBar = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));
		SearchBar.sendKeys(FirstName);

		String GetTextSearchBar1 = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]")).getText();

		Myassertion.assertEquals(GetTextSearchBar1, FirstName, "firstName");
		Thread.sleep(3);
		SearchBar.clear();
		Thread.sleep(3);
		SearchBar.sendKeys(LastName);
		String GetTextSearchBar2 = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[2]")).getText();
		Myassertion.assertEquals(GetTextSearchBar2, LastName, "LastName");

		WebElement DeleteButton = driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[1]/td[5]/button"));
		DeleteButton.click();
		Myassertion.assertAll();

	}

}
