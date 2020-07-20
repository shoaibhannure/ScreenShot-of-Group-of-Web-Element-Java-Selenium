package com.shoaib;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfForm {

	public static void main(String[] args) throws IOException {
		// WebDriverManager.firefoxdriver().setup();
				// WebDriver driver = new FirefoxDriver();
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://register.freecrm.com/register/");
				
				WebElement registrationForm = driver.findElement(By.xpath("//form[@class='ui form']"));
				takescreenshot(registrationForm, "regForm");
				
				//driver.quit();
	}
public static void takescreenshot(WebElement element, String FileName){
	File srcFile= element.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(srcFile, new File("./target/screenshot/" +FileName+".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
}
}
