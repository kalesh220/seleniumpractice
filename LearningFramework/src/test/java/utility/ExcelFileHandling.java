package utility;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;

public class ExcelFileHandling {

    public static FileInputStream fileInputStream;
    public static FileOutputStream fileOutputStream;
    public XSSFWorkbook workbook;
    public XSSFSheet workSheet;
    public XSSFRow row;
    public XSSFCell cell;
    public XSSFCellStyle style;

    public int getRowsCount(String sheet, String path){
        try {
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            workSheet = workbook.getSheet(sheet);
            return workSheet.getLastRowNum();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCellsCount(String path, String sheetName, int rowNumber){
        try{
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            workSheet = workbook.getSheet(sheetName);
            row = workSheet.getRow(rowNumber);
            return row.getLastCellNum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(String path, String sheetName, int rowNumber, int cellNumber){
        try{
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            workSheet = workbook.getSheet(sheetName);
            row = workSheet.getRow(rowNumber);
            cell = row.getCell(cellNumber);

            return cell.getStringCellValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
