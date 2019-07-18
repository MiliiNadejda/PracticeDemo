package apachePOI;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PracticeExcelDrivenData {
    public static void main(String[] args) throws IOException {
        //ACCEPTS FILE STREAM INPUT ARGUMENT
        FileInputStream file = new FileInputStream("/Users/nadejdamilii/Downloads/DEMO.DATA.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
    }
}
