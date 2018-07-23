package org.datadriven.practice.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public static WebDriver driver;
	public static File file;
	public static Workbook w;
	public static FileInputStream stream;

	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssndr\\Documents\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public Sheet readExcel() throws IOException {
		file = new File("C:\\Users\\ssndr\\eclipse-workspace\\DataDriven\\ExcelFiles\\PracticeData.xlsx");
		stream = new FileInputStream(file);
		w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Data");
		System.out.println("Read successful");
		return s;

	}

	public String login(Sheet s) {
		// username
		Row r = s.getRow(1);
		Cell c = r.getCell(2);
		String username = c.getStringCellValue();
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		// password
		Row r2 = s.getRow(1);
		Cell c2 = r2.getCell(3);
		String password = c2.getStringCellValue();
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		// Submit
		driver.findElement(By.xpath("//input[@type='Submit']")).click();

		String searchHotel = driver.getCurrentUrl();
		return searchHotel;
	}

	public String firstPage(String searchHotelUrl, Sheet s2) throws InterruptedException {
		System.out.println(driver.getTitle());
		// Location
		WebElement loc = driver.findElement(By.xpath("//select[@name='location']"));
		Select location = new Select(loc);
		Row r1 = s2.getRow(1);
		Cell c1 = r1.getCell(0);
		location.selectByVisibleText(c1.getStringCellValue());
		// Hotels
		WebElement hot = driver.findElement(By.xpath("//select[@name='hotels']"));
		Select hotel = new Select(hot);
		Row r2 = s2.getRow(1);
		Cell c2 = r2.getCell(1);
		hotel.selectByVisibleText(c2.getStringCellValue());
		// Room type
		WebElement rt = driver.findElement(By.xpath("//select[@name='room_type']"));
		Select room_type = new Select(rt);
		Row r3 = s2.getRow(1);
		Cell c3 = r3.getCell(4);
		room_type.selectByVisibleText(c3.getStringCellValue());
		// Room nos
		WebElement rn = driver.findElement(By.xpath("//select[@name='room_nos']"));
		Select room_nos = new Select(rn);
		Row r4 = s2.getRow(1);
		Cell c4 = r4.getCell(5);
		room_nos.selectByVisibleText(c4.getStringCellValue());
		// Date in
		Row r5 = s2.getRow(1);
		Cell c5 = r5.getCell(6);
		String dateIn = c5.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys(dateIn);
		// Date out
		Row r6 = s2.getRow(1);
		Cell c6 = r6.getCell(7);
		String dateOut = c6.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='datepick_out']")).sendKeys(dateOut);
		// Adult room
		WebElement ar = driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select adult_room = new Select(ar);
		Row r7 = s2.getRow(1);
		Cell c7 = r7.getCell(8);
		adult_room.selectByVisibleText(c7.getStringCellValue());
		// Child room
		WebElement cr = driver.findElement(By.xpath("//select[@name='child_room']"));
		Select child_room = new Select(cr);
		Row r8 = s2.getRow(1);
		Cell c8 = r8.getCell(9);
		child_room.selectByVisibleText(c8.getStringCellValue());
		// Submit
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='radiobutton_0']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(1000);
		String secondUrl = driver.getCurrentUrl();
		return secondUrl;
	}

	public void secondPage(String second, Sheet s2) throws InterruptedException, IOException {
		System.out.println(driver.getTitle());
		// First name
		Row r9 = s2.getRow(1);
		Cell c9 = r9.getCell(10);
		String firstName = c9.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
		// last name
		Row r10 = s2.getRow(1);
		Cell c10 = r10.getCell(11);
		String lastName = c10.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
		// Address
		Row r11 = s2.getRow(1);
		Cell c11 = r11.getCell(12);
		String address = c11.getStringCellValue();
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(address);
		// CC num
		Row r12 = s2.getRow(1);
		Cell c12 = r12.getCell(13);
		String ccNum = c12.getStringCellValue();
		driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys(ccNum);
		// CC type
		WebElement cct = driver.findElement(By.xpath("//select[@name='cc_type']"));
		Select cc_type = new Select(cct);
		Row r13 = s2.getRow(1);
		Cell c13 = r13.getCell(14);
		cc_type.selectByVisibleText(c13.getStringCellValue());
		// cc month
		WebElement ccm = driver.findElement(By.xpath("//select[@name='cc_exp_month']"));
		Select cc_month = new Select(ccm);
		Row r14 = s2.getRow(1);
		Cell c14 = r14.getCell(15);
		cc_month.selectByVisibleText(c14.getStringCellValue());
		// cc year
		WebElement ccy = driver.findElement(By.xpath("//select[@name='cc_exp_year']"));
		Select cc_year = new Select(ccy);
		Row r15 = s2.getRow(1);
		Cell c15 = r14.getCell(16);
		double year=c15.getNumericCellValue();
		long l=(long)year;
		String s1=String.valueOf(l);
		cc_year.selectByVisibleText(s1);
		//cc cvv
		Row r16 = s2.getRow(1);
		Cell c16 = r16.getCell(17);
		double cvv = c16.getNumericCellValue();
		long l2=(long)cvv;
		String cVV=String.valueOf(l2);
		driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys(cVV);
		driver.findElement(By.xpath("//input[@name='book_now']")).click();
		Thread.sleep(5000);
		WebElement orderNo = driver.findElement(By.xpath("//input[@name='order_no']"));
		String order = orderNo.getAttribute("value");
		System.out.println(order);
		Row r17 = s2.getRow(1);
		Cell c17 = r17.getCell(18);
		if(c17 == null) {
			c17= s2.getRow(1).createCell(18);	
		}
		c17.setCellValue(order);
		stream.close();
		//Saving
		FileOutputStream o=new FileOutputStream(file);
		w.write(o);
		o.close();
		
		
	}

}
