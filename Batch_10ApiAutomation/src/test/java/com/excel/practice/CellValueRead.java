package com.excel.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellValueRead {

	static FileInputStream fis;
	static XSSFWorkbook wb;

	public static void main(String[] args) {

	File filepath = new File("./Data folder/Test Data Financial.xlsx");
	try {
	fis =new FileInputStream(filepath);//data >>>stream
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	//Apache POI >> JAR to handle excel >>> read the excel data as stream

	try {
	wb = new XSSFWorkbook(fis);
	} catch (IOException e) {
	e.printStackTrace();
	}

	XSSFCell cellValue =wb.getSheetAt(1).getRow(1).getCell(1);
	System.out.println(cellValue.toString());  	
	
	
}
}