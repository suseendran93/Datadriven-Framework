package org.datadriven.practice.DataDriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;

public class AdactinApp extends Base{

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
			AdactinApp adact=new AdactinApp();
			adact.getDriver();
			adact.getUrl("http://adactin.com/HotelApp/SearchHotel.php");
			Sheet s2 = adact.readExcel();
			String searchHotelUrl = adact.login(s2);
			String second = adact.firstPage(searchHotelUrl,s2);
			adact.secondPage(second,s2);
			adact.quitBrowser(driver);
	}

}
