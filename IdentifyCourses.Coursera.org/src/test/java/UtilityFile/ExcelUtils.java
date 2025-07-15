package UtilityFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

public class ExcelUtils {
	public static void writingToExcel(Set <String> set) throws Exception{
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\resources\\Count_Of_Languages.xlsx");
		Workbook workBook=new XSSFWorkbook(file);
		file.close();
		Sheet sheet = workBook.getNumberOfSheets()==0 ? workBook.createSheet("Languages Count") : workBook.getSheetAt(0);
		if(sheet.getPhysicalNumberOfRows()==0) {
			Row header=sheet.createRow(0);
			Cell headerCell= header.createCell(0);
			headerCell.setCellValue("Languages And Count");
		}
		
		int rowNum = sheet.getLastRowNum() + 1;
		for(String language: set) {
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(language);
			rowNum++;
		}
		
		FileOutputStream outPutFile=new FileOutputStream(System.getProperty("user.dir")+"\\resources\\Count_Of_Languages.xlsx");
		workBook.write(outPutFile);
		workBook.close();
		
		
	}
}
