package com.example;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UploadStudyMaterialTest {

	public static void main(String[] args) throws InterruptedException, URISyntaxException {

		System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "\\geckodriver.exe"));
		WebDriver driver = new FirefoxDriver();
		driver.get("https://studydrive.net/file-upload");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("reddyswapna55@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Vasantha@2710");
		driver.findElement(By.id("js-login-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='add-new-button js-add-new-button']")).click();

		driver.findElement(By.cssSelector("a[href='https://www.studydrive.net/file-upload']")).click();
		driver.findElement(By.id("course-selector-selectized")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='add-course-item']")).click();
		driver.findElement(By.name("university")).click();
		Select s = new Select(driver.findElement(By.name("university")));
		s.selectByValue("6160"); // 6160 is the option value of existing university "987654321" in the University
									// select menu
		driver.findElement(By.name("course_name")).sendKeys("TestCourse7");
		driver.findElement(By.xpath("//button[text()='Add course']")).click();
		// driver.get(new UploadStudyMaterialTest().getFile());s
		driver.findElement(By.xpath("//input[@name='qqfile']"))
				.sendKeys(System.getProperty("user.dir") + "\\SampleTestDocument.docx");
		Select semester = new Select(driver.findElement(By.className("semester")));
		semester.selectByValue("40");// value 40 corresponds to Summer 2019 semester
		Select documentType = new Select(driver.findElement(By.className("type")));
		documentType.selectByValue("10");
		driver.findElement(By.className("description")).sendKeys("Sample file");
		driver.findElement(By.xpath("//button[@class='submit-btn']")).click();

	}

}
