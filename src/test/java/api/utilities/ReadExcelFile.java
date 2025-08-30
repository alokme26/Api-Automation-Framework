package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static FileInputStream inputStream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet excelsheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    // ✅ Get value from a cell
	/*
	 * public static String getCellValue(String filename, String sheetName, int
	 * rowNo, int cellNo) { try (FileInputStream inputStream = new
	 * FileInputStream(filename); XSSFWorkbook workbook = new
	 * XSSFWorkbook(inputStream)) {
	 * 
	 * XSSFSheet sheet = workbook.getSheet(sheetName); XSSFRow row =
	 * sheet.getRow(rowNo); XSSFCell cell = row.getCell(cellNo);
	 * 
	 * return cell.getStringCellValue(); // Only works if cell type is STRING
	 * 
	 * } catch (Exception e) { e.printStackTrace(); return ""; } }
	 */
    
    public static String getCellValue(String filename, String sheetName, int rowNo, int cellNo) {
        try (FileInputStream inputStream = new FileInputStream(filename);
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNo);
            XSSFCell cell = row.getCell(cellNo);

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // ✅ Get total row count
    public static int getRowCount(String filename, String sheetName) {
        int rowCount = 0;
        try {
            inputStream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(inputStream);
            excelsheet = workbook.getSheet(sheetName);
            rowCount = excelsheet.getLastRowNum() + 1; // +1 because row index starts at 0
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    // ✅ Get total column count (based on first row)
    public static int getColCount(String filename, String sheetName) {
        int colCount = 0;
        try {
            inputStream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(inputStream);
            excelsheet = workbook.getSheet(sheetName);
            row = excelsheet.getRow(0); // assuming first row defines headers/columns
            if (row != null) {
                colCount = row.getLastCellNum();
            }
            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return colCount;
    }
}


