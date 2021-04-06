package com.ARSHAD.phptravels.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_excel
{
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
public read_excel(String excelpath)
{
	try 
	{
	fis=new FileInputStream(excelpath);
	wb=new XSSFWorkbook(fis);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}	
public int totalrows(String sheetname)
{
	sh=wb.getSheet(sheetname);
	int last_row=sh.getLastRowNum();
	last_row=last_row+1;
	return last_row;	
}
public short totalcolumns(String sheetname)
{
	short last_col=0;
	sh=wb.getSheet(sheetname);
	for(int i=0;i<sh.getLastRowNum();i++)
	{
		last_col=sh.getRow(i).getLastCellNum();
	}
	return last_col;
}
public String GTDATA(String sheetname,int row,int column)
{
	String gtdata=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	return gtdata;
}
	
}


