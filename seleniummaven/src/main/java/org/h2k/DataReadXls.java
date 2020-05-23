package org.h2k;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.DataProvider;




public class DataReadXls {
	
	
	@DataProvider(name="excelRead")
	public String[][] loginData() throws IOException{
		 
		 String[][] userCred = null;
		 HSSFRow row;
		 FileInputStream fis = new FileInputStream(new File("C:\\Users\\vikib\\Desktop\\Selenium\\MyDataSheet.xls"));
		 
		 HSSFWorkbook workbook = new HSSFWorkbook(fis);
		 HSSFSheet spreadsheet = workbook.getSheetAt(0);
	      /* Getting number of rows and columns*/
		 int rowCount = spreadsheet.getPhysicalNumberOfRows();
		 Iterator<Row> rowIterator = spreadsheet.iterator();
	      System.out.println("Rows ->" + rowCount);
	      row = (HSSFRow) rowIterator.next();
	      int colCount = row.getPhysicalNumberOfCells();
	      System.out.println("Col-->" + colCount);
	      
	      
	      userCred = new String[rowCount][colCount];
	      for(int i=0;i<rowCount;i++)
	      {
	    	  row = spreadsheet.getRow(i);
	    	  for(int j=0;j< colCount;j++)
	    	  {
	    		  String cellText = row.getCell(j).toString();
	    		  System.out.print(cellText + "\t\t" ); //[0][0],[0][1]/[1][0],[1][1]/[2][0],[2][1]
	    		  userCred[i][j] = cellText;
	    	  }
	    	  
	    	  System.out.println();
	    	  
	      }
	      
		fis.close();
		return userCred ;
		
	}
	

}
