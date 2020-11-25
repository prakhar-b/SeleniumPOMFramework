package utilities;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelData {
	static WebDriver driver;
	public static String path = System.getProperty("user.dir") + "\\TestData\\Input.xlsx";
	public static File file;
	public static FileInputStream fin;

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileOutputStream fout;
	static XSSFRow row = null;
	static String[] login=new String[2];
	static String[] login1=new String[2];
	static String[] search = new String[2];

	public static String[] readExcel(String sheetName) throws Exception {
		file = new File(path);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet(sheetName);
		for(int i=0;i<2;i++) {
			login[i]=sh.getRow(3).getCell(i).getStringCellValue();
			System.out.println("it is..."+login[i]);
		}
		return login;
	}
	public static String[] readExcel1(String sheetName) throws Exception {
		file = new File(path);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet(sheetName);
		for(int i=0;i<2;i++) {
			login1[i]=sh.getRow(2).getCell(i).getStringCellValue();
			System.out.println("it is..."+login1[i]);
		}
		return login1;
	}
	public static String[] getCity(String sheetName ) throws IOException {
		file = new File(path);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet(sheetName);
		for(int i=0;i<2;i++) {
			search[i]=sh.getRow(5).getCell(i).getStringCellValue();
			System.out.println("it is..."+search[i]);
		}
		return search;
		
	}
	public static void writeExcel(String[] name,String sheetname) throws Exception {

		String path1 = System.getProperty("user.dir") + "\\TestData\\Output.xlsx";
		file = new File(path1);
		fin = new FileInputStream(file);
		wb = new XSSFWorkbook(fin);
		sh = wb.getSheet(sheetname);
		//sh.createRow(0).createCell(0).setCellValue("Total Number of Hotels");
		//sh.createRow(0).createCell(1).setCellValue(length);
		//sh.createRow(1).createCell(0).setCellValue("List of hotels displayed on the page");
		// iterating rows and printing the headphones with price
		for (int i = 0; i < name.length; i++) {
			row = sh.createRow(i);
			row.createCell(0).setCellValue(name[i]);

		}
		sh.autoSizeColumn(0);
		// Writing the output to Excel file using FileOutputStream
		
			fout = new FileOutputStream(path1);
			wb.write(fout);
			fout.close();
		
	}
	
}
