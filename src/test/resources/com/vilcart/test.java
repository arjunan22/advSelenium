package com.vilcart;

public class test {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties p =new Properties();
		p.load(fis);
		
		driver.get(p.getProperty("url"));
		driver.findElement(By.xpath("(//input[@class='text-input text-input-md'])[1]")) .sendKeys(p.getProperty("email"));
		driver.findElement(By.xpath("(//input[@class='text-input text-input-md'])[2]")).sendKeys(p.getProperty("password"));
		driver.findElement(By.xpath("(//span[@class='button-inner'])[5]")).click();
			
						
		Thread.sleep(10000);
		
		driver.close();

	}

}
