package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value = null;
	
	public String getCellvalue(int c, int r) throws IOException {
		fis=new FileInputStream("C:\\Users\\Vikash\\Desktop\\Java\\DataDrivenFramework\\src\\test\\resources\\excel\\DataPractice.xlsx");
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet-1");
		row=sheet.getRow(r);		
		
		try {
			cell=row.getCell(c);
			if(cell.getCellTypeEnum()==CellType.STRING) {
				value= cell.getStringCellValue();			
			}
			else {
				value= NumberToTextConverter.toText(cell.getNumericCellValue());
				
			}
		}catch(Exception e) {
			
		}			
		return value;							
	}
	
	
	public void  getCell(String v) throws IOException {
		fis=new FileInputStream("C:\\Users\\Vikash\\Desktop\\Java\\DataDrivenFramework\\src\\test\\resources\\excel\\DataPractice.xlsx");
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet-1");		
		int i=sheet.getPhysicalNumberOfRows();
		int j;
		int k = 0,l = 0;
		for(j=0;j<i;j++) {
			row=sheet.getRow(j);
			Iterator<Cell> c=row.cellIterator();
			while(c.hasNext()) {
				Cell c1=c.next();	

				String s1;
				if(c1.getCellTypeEnum()==CellType.STRING) {
					s1=c1.getStringCellValue();	
				}
				else {
					s1= NumberToTextConverter.toText(c1.getNumericCellValue());
				}
				if(s1.equals(v)) {
					l++;
					System.out.println("Cell Found at row :"+j+ " and column :"+k);
				}
				k++;				
				
			}k=0;
			
		}
		if(l==0) {
			System.out.println("Cell not Found");		}
		
		
	}
	public ArrayList<String> getRow(String v) throws IOException{
		fis=new FileInputStream("C:\\Users\\Vikash\\Desktop\\Java\\DataDrivenFramework\\src\\test\\resources\\excel\\DataPractice.xlsx");
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet-1");
		int i=sheet.getPhysicalNumberOfRows();
		int j;
		
		
		ArrayList<String> a=new ArrayList<String>();
		for(j=0;j<i;j++) {
			row=sheet.getRow(j);
			Iterator<Cell> c1=row.cellIterator();
			Iterator<Cell> c2=row.cellIterator();
			while(c1.hasNext()) {
				Cell c3=c1.next();
				String s1;
				if(c3.getCellTypeEnum()==CellType.STRING) {
					s1=c3.getStringCellValue();	
				}
				else {
					s1= NumberToTextConverter.toText(c3.getNumericCellValue());
				}
				
				if(s1.equals(v)) {
					while(c2.hasNext()){				
						String s2;
						Cell c4=c2.next();
						if(c4.getCellTypeEnum()==CellType.STRING) {
							s2=c4.getStringCellValue();
							a.add(s2);	
						}
						else {
							s2= NumberToTextConverter.toText(c4.getNumericCellValue());
							a.add(s2);
						}
						
					}
					
				}
				
			}			
			
		}
		return a;
		
		
	}

	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelReading r1=new ExcelReading();
		String value=r1.getCellvalue(2, 3);
		if(value==null) {
			System.out.println("cell data Doesn't Exist");
		}else {
			System.out.println("Cell data is : "+value);
		}
		r1.getCell("Wipro");
		
		ArrayList<String> a=r1.getRow("Wipro");
		Iterator<String> i=a.iterator();
		int temp=0;
		while(i.hasNext()) {
			String s=i.next();
			temp++;
			System.out.println(s);
		}
		if(temp==0) {
			System.out.println("Cell doesn't exist");
		}
		
	
	
		

	}

}
