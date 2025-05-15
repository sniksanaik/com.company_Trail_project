package vtiger_genericUtility;
/**
 * the class consist of method related to read the data from Excel file
 * @author naimi
 * 
 * 
 */
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * this method is used to read data from Excel file provided with Sheetname, row and cell
	 * 
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String toReadDataFromExcelFile(String sheetname,int row ,int cell) throws EncryptedDocumentException, IOException {
	
	 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\test_Excel.xlsx");
     Workbook wb=WorkbookFactory.create(fis);
     String value=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	return value;
}
}