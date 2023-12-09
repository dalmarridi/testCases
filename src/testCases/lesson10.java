package testCases;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class lesson10 {
	String myWebSite = "https://www.saucedemo.com/"; // عشان كل ما بدي اناديه اكتبلو هاد المتغير هيك بكون الكود انضف
	String UserName = "standard_user";
	String Password = "secret_sauce"; // لانه نوع اليوزر نيم تكست فعرفتو ب سترينجج
	WebDriver driver = new ChromeDriver(); // يعني هاي الجملة حفظ وحفظ وحفظ ودايما لازم اكتبها مع اي بروجكت جديد

	@BeforeTest
	public void mySetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000)); // هون بمهلو 3 ثواني وبستنى ضمنيا 3 ثواني
																				// ومو شرط يكملهم ال3 ممكن يستنى اقل
		driver.manage().window().maximize(); // كبرلي الشاشه يا درايفر
		driver.get(myWebSite); // فتحت الswag labs
	}

	@Test()
	public void LoginTest() throws InterruptedException {
		WebElement UserNameInput = driver.findElement(By.id("user-name")); // جبت الاي دي من ال selectorHub
		WebElement PasswordInput = driver.findElement(By.id("password"));// txt
		WebElement LoginButton = driver.findElement(By.id("login-button"));// button
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginButton.click();

		// String [] myarray = {} ;

		// int c = myarray.length;

	}

	@Test(enabled = false)
	public void PrintTheNameOFTheFirstITems() {

		WebElement FirstItem = driver
				.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']"));// بقدر اجرب
																											// الxpath
																											// ايضا

		String itemText = FirstItem.getText();

		System.out.println(itemText);

	}

	@Test(enabled = false)
	public void PrintTheNamesOfAllItems() {

		List<WebElement> allitems = driver.findElements(By.className("inventory_item_name"));
//هاي ليست فيها elements كلهم, اسمها all items فيها كل الelements الي اسمهم بكلاس اسمه 
//		inventory_item_name
//		وهاد جبته من inspect بعدها selectorHub

		allitems.size();
		for (int i = 0; i < allitems.size(); i++) {

			System.out.println(allitems.get(i).getText());

		}
	}

	@Test(enabled = false)
	public void PressOnAllItems() throws InterruptedException {
		List<WebElement> allItems = driver.findElements(By.className("btn"));
		Thread.sleep(2000);

		allItems.size();
		for (int i = 0; i < allItems.size(); i++) {

			allItems.get(i).click();
			Thread.sleep(2000);

		}
	}

	@AfterTest
	public void AftermyTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
