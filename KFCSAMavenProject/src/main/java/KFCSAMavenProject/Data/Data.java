package KFCSAMavenProject.Data;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public Data(String excelpath)
	{
		try
		{
			File file = new File(excelpath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public String getData(int SheetNum, int row, int col)
	{
		sheet = wb.getSheetAt(SheetNum);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
