package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dbs {

	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        ChromeDriver driver = new ChromeDriver();
	        JavascriptExecutor js= (JavascriptExecutor)driver;

	        //opening dbs URL
	        driver.get("https://www.drivenbystyle.com/");
	        driver.manage().window().maximize();
	        
	        Thread.sleep(3000);
	        
	        //For make
	        WebElement make= driver.findElement(By.xpath("//select[@id='make']"));
	        Select s1= new Select(make);
	        s1.selectByVisibleText("BMW");
	        Thread.sleep(1000);
	        
	        //For model
	        WebElement model= driver.findElement(By.id("model"));
	        Select s2= new Select(model);
	        s2.selectByVisibleText("1 Series");
	        Thread.sleep(1000);
	        
	        //For year
	        WebElement year= driver.findElement(By.id("year"));
	        Select s3= new Select(year);
	        s3.selectByVisibleText("2021");
	        Thread.sleep(1000);
	        
	        //Go button
	        driver.findElement(By.xpath("//button[@title='GO']")).click();
	        Thread.sleep(2000);
	        
	        js.executeScript("window.scrollBy(0,500)","");
	        Thread.sleep(2000);

	        //open category
	       // driver.findElement(By.xpath("//a[@href='https://www.drivenbystyle.com/2021-bmw-1series/sway-bars']")).click();
	        driver.findElement(By.partialLinkText("Sway Bars")).click();
	        Thread.sleep(2000);
	        
	        js.executeScript("window.scrollBy(0,500)","");
	        Thread.sleep(2000);
	        
	        //open product link
	        driver.findElement(By.xpath("//a[@class='product-item-link']")).click();
	        Thread.sleep(2000);
	        
	        js.executeScript("window.scrollBy(0,200)","");
	        Thread.sleep(2000);
	        
	        //select calculate shipping radio button
	        driver.findElement(By.id("shippingRadio")).click();
	        Thread.sleep(2000);
	        
	        //state
	        WebElement state= driver.findElement(By.name("country_id"));
	        Select s4= new Select(state);
	        s4.selectByVisibleText("United States");
	        Thread.sleep(1000);
	        
	        //region
	        WebElement region= driver.findElement(By.xpath("//select[@id='region']"));
	        Select s5= new Select(region);
	        s5.selectByVisibleText("California");
	        Thread.sleep(1000);
	        
	        js.executeScript("window.scrollBy(0,400)","");
	        Thread.sleep(2000);
	        
	        //get flat rate quote
	        driver.findElement(By.xpath("//button[@on=\"tap: AMP.setState({ productShippingStateUri: (flatrate.is) ? '//www.drivenbystyle.com/pramp/shipping/flatrateshipping?isAjax=true&productId=84521&country_id='+contry.selected+'&region_id='+regionId+'&postcode='+postcode+'&product_vendor=17&amount=205&weight=50.0000&org_country=US&org_postalcode=91748&flatrateprice=45&flatratezoneb=55&flatresidential=0&brand=2697&qty='+productQty+'&region_text='+regiontext: '//www.drivenbystyle.com/pramp/shipping/shippingmanager/id/84521?country=' + contry.selected +'&region='+regionId+'&shippingType='+shippingType+'&region_text='+regiontext, shippingBtnClicked: true })\"]")).click();
	        Thread.sleep(5000);
	        
	        //available shipping
	        WebElement shipping= driver.findElement(By.xpath("//select[@name='product_shipping']"));
	        Select s6= new Select(shipping);
	        s6.selectByVisibleText("Home Delivery (+$45)");
	        Thread.sleep(1000);

			driver.findElement(By.xpath("//button[text()=' Add to Cart']")).click();
		    Thread.sleep(3000);

			//opening cart page
			driver.get("https://www.drivenbystyle.com/checkout/cart/");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//span[text()='Checkout with Credit Card']")).click();
		Thread.sleep(5000);

		/*WebElement email=driver.findElement(By.id("customer-email"));
		email.sendKeys("test@gmail.com");*/

		WebElement firstname=driver.findElement(By.name("firstname"));
		firstname.sendKeys("test");

		WebElement lastname=driver.findElement(By.name("lastname"));
		lastname.sendKeys("tester");

		WebElement company=driver.findElement(By.name("company"));
		company.sendKeys("test");

		WebElement streetdd=driver.findElement(By.name("street[0]"));
		streetdd.sendKeys("shivaji nagar");

		WebElement city=driver.findElement(By.name("city"));
		city.sendKeys("Nagpur");

		WebElement provincs=driver.findElement(By.name("region_id"));
		Select s9=new Select(provincs);
		s9.selectByVisibleText("California");

		WebElement zip=driver.findElement(By.xpath("//input[@name='postcode']"));
		zip.sendKeys(" 12345-6789");

		WebElement country=driver.findElement(By.name("country_id"));
		Select s11=new Select(country);
		s11.selectByVisibleText("United States");

		js.executeScript("window.scrollBy(0,200)","");
		Thread.sleep(1000);
		WebElement phonenum=driver.findElement(By.name("telephone"));
		phonenum.sendKeys("123-456-7890");

		driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();


		driver.quit();

	        
	        
	        
	}

}
