package com.practice;
import org.openqa.selenium.By;import org.openqa.selenium.By;
//button[@name='login']
import org.openqa.selenium.chrome.ChromeDriver;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        ChromeDriver driver = new ChromeDriver();

	        //opening Facebook URL
	        driver.get("https://www.facebook.com/");

	        //Entering Email id by id, name or xpath locator
	       /* driver.findElement(By.id("email")).sendKeys("test@gmail.com");
	        driver.findElement(By.name("email")).sendKeys("test@gmail.com");*/
	        driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("test@gmail.com");


	        //Entering Email id by xpath
	        driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("123");

	        //Click on login button
	       // driver.findElement(By.xpath("//button[@name='login']")).click();

	        //Click on Forgotten Password Link by link text & partial link text
	       //driver.findElement(By.linkText("Forgotten password?")).click();
	        driver.findElement(By.partialLinkText("password")).click();


	}

}
