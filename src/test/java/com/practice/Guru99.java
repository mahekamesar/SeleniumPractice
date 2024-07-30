package com.practice;

	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	
	public class Guru99 {

	@Test
	public void f() throws IOException {

	System.setProperty("webdriver.chrome.driver",
	"C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	ChromeDriver driver = new ChromeDriver(options);

	driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
	driver.manage().window().maximize();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement genCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//header[@id='header']/descendant::a[text()='Generate Card Number']")));

	String mainwindow = driver.getWindowHandle();
	System.out.println("Main window: " + mainwindow);

	genCardNo.click();

	Set<String> allwindows = driver.getWindowHandles();
	for (String handles : allwindows) {
	while (!allwindows.equals(mainwindow)) {
	driver.switchTo().window(handles);
	break;
	}
	}
	String newwindow = driver.getCurrentUrl();
	System.out.println("newwindow" + newwindow);

	wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//header[@id='header']/descendant::a[text()='Generate Card Number']")));
	js.executeScript("window.scrollBy(0,600);", "");
	// js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	WebElement CardnoText = driver
	.findElement(By.xpath("//section[@id='three']/descendant::h4[contains(text(),'Card Number:- ')]"));
	String CardNoText1 = CardnoText.getText();
	String Cardno = CardNoText1.split(":-")[1].trim();
	System.out.println("CardNo =" + Cardno);

	WebElement ExpiryText = driver
	.findElement(By.xpath("//section[@id='three']/descendant::h4[contains(text(),'Exp:-  ')]"));
	String ExpiryText1 = ExpiryText.getText();
	String Expiry = ExpiryText1.split(":-")[1].trim();
	System.out.println("Expiry =" + Expiry);

	String month = Expiry.split("/")[0].trim();
	String year = Expiry.split("/")[1].trim();

	WebElement CVVText = driver
	.findElement(By.xpath("//section[@id='three']/descendant::h4[contains(text(),'CVV:-  ')]"));
	String CVVText1 = CVVText.getText();
	String CVV = CVVText1.split(":-")[1].trim();
	System.out.println("CVV =" + CVV);

	WebElement CreditLimit = driver
	.findElement(By.xpath("//section[@id='three']/descendant::h4[text()='Credit Limit ']/span"));
	String cLimit = CreditLimit.getText();
	System.out.println("Credit Limit =" + cLimit);

	driver.switchTo().window(mainwindow);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//header[@id='header']/descendant::a[text()='Generate Card Number']")));
	js.executeScript("window.scrollBy(0,600);", "");

	WebElement qty = driver.findElement(By.xpath("//select[@name='quantity']"));
	Select Qtydrop = new Select(qty);
	Qtydrop.selectByVisibleText("4");

	WebElement buynow = driver.findElement(By.xpath("//input[@value='Buy Now']"));
	buynow.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//header[@id='header']/descendant::a[text()='Generate Card Number']")));

	WebElement cardnofield = driver.findElement(By.xpath("//input[@id='card_nmuber']"));
	cardnofield.sendKeys(Cardno);

	WebElement monthfield = driver.findElement(By.xpath("//select[@id='month']"));
	Select monthdrop = new Select(monthfield);
	monthdrop.selectByVisibleText(month);

	WebElement yearfield = driver.findElement(By.xpath("//select[@id='year']"));
	Select yeardrop = new Select(yearfield);
	yeardrop.selectByVisibleText(year);

	WebElement cvvfield = driver.findElement(By.xpath("//input[@id='cvv_code']"));
	cvvfield.sendKeys(CVV);

	driver.findElement(By.xpath("//input[@name='submit']")).click();

	WebElement Actual = driver.findElement(By.xpath("//section[@id='three']/descendant::h2[text()='Payment successfull!']"));
	String ActualText = Actual.getText();
	String ExpectedText = "Payment successfull!";

	System.out.println("Actual Text is "+ActualText);
	System.out.println("Expected Text is "+ExpectedText);

	Assert.assertEquals(ActualText, ExpectedText);
	System.out.println("Assertion is successful");

	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(source, new File("D:\\Selenium Tools repository\\Eclipse workspace\\Java_codes_website_automate_BDD\\target\\screenshot" +System.currentTimeMillis()+"png"));
	System.out.println("Screenshot is taken");
	}
	
}
