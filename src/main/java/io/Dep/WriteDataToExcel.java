package io.Dep;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDataToExcel {
    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Student Data");
        XSSFRow row;
        
        // Sample data (you can replace this with your own data)
        Map<String, Object[]> studentData = new TreeMap<>();
        studentData.put("1", new Object[] { "Roll No", "NAME", "Year" });
        studentData.put("2", new Object[] { "128", "Aditya", "2nd year" });
        studentData.put("3", new Object[] { "129", "Narayana", "2nd year" });
        studentData.put("4", new Object[] { "130", "Mohan", "2nd year" });
        studentData.put("5", new Object[] { "131", "Radha", "2nd year" });
        studentData.put("6", new Object[] { "132", "Gopal", "2nd year" });

        int rowId = 0;
        for (String key : studentData.keySet()) {
            row = spreadsheet.createRow(rowId++);
            Object[] objectArr = studentData.get(key);
            int cellId = 0;
            for (Object obj : objectArr) {
                XSSFCell cell = row.createCell(cellId++);
                cell.setCellValue((String) obj);
            }
        }

        // Save the workbook to a file
        FileOutputStream out = new FileOutputStream(new File("E:/Arshadalee/Testing/Java/PorjectWork/GFGsheet.xlsx"));
        workbook.write(out);
        out.close();

        System.out.println("Data written successfully to GFGsheet.xlsx");
    }
}

