package org.datadriven.practice.DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	public static File file;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		file = new File("C:\\Users\\ssndr\\eclipse-workspace\\DataDriven\\ExcelFiles\\PracticeData.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Data");
		System.out.println("Read successful");
		Row r = s.getRow(0);
		Cell c = r.getCell(2);
		System.out.println(c);
	}

}
