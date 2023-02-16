package com.vilcart.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class loginCase {

	public static void main(String[] args) throws IOException, InterruptedException {
		//WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Admin\\Downloads\\msedgedriver.exe" );
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties p =new Properties();
		p.load(fis);
		
		driver.get(p.getProperty("url"));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(p.getProperty("user"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(p.getProperty("password"));
		driver.findElement(By.xpath("(//span[@class='button-inner'])[5]")).click();
		
						
		Thread.sleep(10000);
		driver.close();
	}

}
