package WorldClockcass;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
		public static XSSFSheet sheet;
		public static FileOutputStream fileOp;
		public static XSSFWorkbook wb;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static String exFilePath=System.getProperty("user.dir")+"\\testdata\\MyData.xlsx";
		
		public static void writeExcel() {
			try {
				fileOp = new FileOutputStream(exFilePath); 
				wb=new XSSFWorkbook();
				sheet=wb.getSheet("MyData.xlsx");
				row=sheet.getRow(2);
				cell=row.getCell(1);
				cell.setCellValue(worldclock.webtime);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
