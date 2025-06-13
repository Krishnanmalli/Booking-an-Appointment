package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingAppointmentwithTest {

	WebDriver driver;

	@BeforeMethod
	public void login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}

	@Test
	public void appointmentbooking() throws InterruptedException {
		driver.findElement(By.id("btn-make-appointment")).click();
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
		Thread.sleep(500);
        driver.findElement(By.id("combo_facility")).click();
        Select Facility = new Select(driver.findElement(By.id("combo_facility")));
		Facility.selectByValue("Hongkong CURA Healthcare Center");
		Thread.sleep(500);
	    driver.findElement(By.id("radio_program_medicaid")).click();
		Thread.sleep(500);
	    driver.findElement(By.id("txt_visit_date")).click();
		Thread.sleep(7000);
	    driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td/span[6]")).click();
        driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[4]")).click();
        driver.findElement(By.id("txt_comment")).sendKeys("Looking forward to the appointment. Please confirm the timing");
        driver.findElement(By.id("btn-book-appointment")).click();
	}

	@AfterMethod
	public void logout() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]/i")).click();
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a")).click();
        driver.quit();
	}

}

