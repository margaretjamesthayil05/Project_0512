package utilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static FileInputStream f;
	static XSSFWorkbook w;//handle excel file
	static XSSFSheet sh;//handle excel sheet
	
	public static String getStringData(int a,int b,String path,String sheetname) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+path);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		XSSFRow r=sh.getRow(a);// the selected row
		XSSFCell c=r.getCell(b);// the selected cell
		
		return c.getStringCellValue();
		}
	
	public static String getIntegerData(int a,int b,String path,String sheetname) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+path);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int x=(int) c.getNumericCellValue();
		return String.valueOf(x);
		}
	
	public static int getIntData(int a,int b,String path,String sheetname) throws IOException {
		f=new FileInputStream(System.getProperty("user.dir")+path);
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheetname);
		XSSFRow r=sh.getRow(a);
		XSSFCell c=r.getCell(b);
		int x=(int) c.getNumericCellValue();
		return x;
		}
	
}
