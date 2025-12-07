package utility;

public class Test {
    public static void main(String[] args) {
        ExcelFileHandling efh = new ExcelFileHandling();
        String path = "D:\\Selenium_Learning\\LearningFramework\\src\\test\\resources\\data.xlsx";
        String sheetName = "sheet1";
        int rowCount = efh.getRowsCount(sheetName, path);
        System.out.println(rowCount);
        String data = efh.getCellData(path, sheetName, 1, 1);
        System.out.println(data);
    }
}
