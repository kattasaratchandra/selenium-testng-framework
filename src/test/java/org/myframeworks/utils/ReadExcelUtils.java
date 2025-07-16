package org.myframeworks.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadExcelUtils {

    public static List<HashMap<String, String>> getDataFromExcel(String filePath, String sheetName) throws IOException {
        try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File(filePath))) {
            XSSFSheet sheet = xssfWorkbook.getSheet(sheetName);
            int rowNum = sheet.getPhysicalNumberOfRows();
            int colNum = sheet.getRow(0).getPhysicalNumberOfCells();
             List<HashMap<String, String>> objects = new ArrayList<>();
            for (int i = 1; i < rowNum; i++) {
                HashMap<String, String> dataMap = new HashMap<>();
                for (int j = 0; j < colNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    dataMap.put(key, value);
                }
                objects.add(dataMap);
            }
            return objects;
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
