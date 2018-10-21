package com.w2a.rough;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	public void insertData(Object[][] data) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet("SheetTest2");
		
		int rowCount=0;
		for(Object[] abook:data) {
			Row row=sh.createRow(rowCount++);
			int colCount=0;
			for(Object field:abook) {
				Cell cell=row.createCell(colCount++);
				if(field instanceof String) {
					cell.setCellValue((String)field);
				}
				else if (field instanceof Integer) {
					cell.setCellValue((Integer)field);
				}
			}
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Vikash\\Desktop\\Java\\DataDrivenFramework\\src\\test\\resources\\excel\\TestDataWrite.xlsx");
		wb.write(fos);
		fos.close();


		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Object[][] data= {
				{"Vikash","Infosys",29},
				{"Nisha","TCS",32},
				{"Mahesh","Cogni",34},
				{"Sujay","Barclays",30},
		};
		ExcelWrite ex=new ExcelWrite();
		ex.insertData(data);
			}

}
