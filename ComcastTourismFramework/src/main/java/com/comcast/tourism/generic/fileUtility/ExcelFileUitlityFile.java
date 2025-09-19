package com.comcast.tourism.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *  This is the generic utiltiy class for  fetching  the  TestScripts from Excel Files 
 * @author rohit
 */

public class ExcelFileUitlityFile {
/**
 * 
 * To Fetch the data from Excel Sheet
 * @param Sheet
 * @param Row
 * @param Cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String getDataFromexcelFile(String Sheet, int Row, int Cell) throws EncryptedDocumentException, IOException {

		FileInputStream file = new FileInputStream(
				"D:\\Work_Space\\ComcastTourismFramework\\ComcastTourismFramework\\src\\test\\resources\\TestScriptData\\UserExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		String value = wb.getSheet(Sheet).getRow(Row).getCell(Cell).getStringCellValue();
		wb.close();
		return value;
	}
/**
 * to get the Data from Last Row
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fls = new FileInputStream(
				"D:\\\\Work_Space\\\\ComcastTourismFramework\\\\ComcastTourismFramework\\\\src\\\\test\\\\resources\\\\TestScriptData\\\\UserExcelData.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		int Data = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return Data;

	}
/**
 * to get write Data Back to the excel sheet without manually with Progarming Codes
 * @param SheetName
 * @param rowNum
 * @param celNum
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public void writeDatabackToTheExcel(String SheetName,int rowNum,int celNum, String data) throws EncryptedDocumentException, IOException {
	    		FileInputStream fls=new FileInputStream("D:\\\\Work_Space\\\\ComcastTourismFramework\\\\ComcastTourismFramework\\\\src\\\\test\\\\resources\\\\TestScriptData\\\\UserExcelData.xlsx");
	    		 Workbook wb=WorkbookFactory.create(fls);
	           wb.getSheet(SheetName).getRow(rowNum).createCell(celNum,CellType.STRING).setCellValue(data);

	           FileOutputStream fos=new FileOutputStream("D:\\\\Work_Space\\\\ComcastTourismFramework\\\\ComcastTourismFramework\\\\src\\\\test\\\\resources\\\\TestScriptData\\\\UserExcelData.xlsx");
	           wb.write(fos);
	           wb.close();
	        
	}
	/**
	 * to get write Data Back to the excel sheet without manually with Progarming Codes and
	 * to Create The row As Well As Cell
	 * @param SheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void createRowAndCell(String SheetName,int rowNum,int celNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fls=new FileInputStream("D:\\\\Work_Space\\\\ComcastTourismFramework\\\\ComcastTourismFramework\\\\src\\\\test\\\\resources\\\\TestScriptData\\\\UserExcelData.xlsx");
		 Workbook wb=WorkbookFactory.create(fls);
      wb.getSheet(SheetName).createRow(rowNum).createCell(celNum,CellType.STRING).setCellValue(data);


      FileOutputStream fos=new FileOutputStream("D:\\\\Work_Space\\\\ComcastTourismFramework\\\\ComcastTourismFramework\\\\src\\\\test\\\\resources\\\\TestScriptData\\\\UserExcelData.xlsx");
      wb.write(fos);
      wb.close();
	}
}
   
