package apachePOI;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class PracticeExcelDrivenData {
    public static void main(String[] args) throws IOException {
        //ACCEPTS FILE STREAM INPUT ARGUMENT
        FileInputStream file = new FileInputStream("/Users/nadejdamilii/Downloads/DEMO.DATA.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        int sheets = workbook.getNumberOfSheets();
        System.out.println(sheets);
        for (int i = 0; i < sheets; i++) {
            if(workbook.getSheetName(i).equalsIgnoreCase("DEMO.DATA")){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();
                Iterator<Cell> columnIterator = firstRow.cellIterator();

                while(columnIterator.hasNext()){

                    Cell value = columnIterator.next();
                    if(value.getStringCellValue().equalsIgnoreCase("Test Cases")){

                    }
                }
            }

        }
    }
}
