package helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WriteToExcelHelper {

	/**
	 * This method is to set the values to excel, the method is smart enough to
	 * know what columns in the sheet and write in the next one in order to not
	 * override the existing data
	 * 
	 * @param WorkbookLocation
	 *            the sheet path (Note: the sheet should be saved with type
	 *            "Excel 97-2003 Workbook(*.xls))
	 * @param WorkSheet
	 *            which sheet needs to write the data (0,1...)
	 * @param values
	 *            it should have all values in array in order to write them in
	 *            row
	 */
	public static void SetCellValue(String WorkbookLocation, int WorkSheet,
			String values) {

		try {
			// Read the file
			FileInputStream fileIn = new FileInputStream(WorkbookLocation);

			POIFSFileSystem fs = new POIFSFileSystem(fileIn);

			// Get the workbook instance for XLS file
			HSSFWorkbook wb = new HSSFWorkbook(fs);

			// Get first sheet from the workbook
			HSSFSheet sheet = wb.getSheetAt(WorkSheet);

			Cell cell;

			// Get Last row number
			int rowNumber = sheet.getPhysicalNumberOfRows();

			Row NextRow = sheet.createRow(rowNumber);

			cell = NextRow.createCell(0);
			cell.setCellValue(values);

			FileOutputStream fileOut = new FileOutputStream(WorkbookLocation);
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception ex) {
			System.out.println("There is an error writing into excel");
		}
	}

}
