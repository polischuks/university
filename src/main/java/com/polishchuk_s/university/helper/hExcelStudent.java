package com.polishchuk_s.university.helper;

import com.polishchuk_s.university.model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class hExcelStudent {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "id", "first_name", "last_name" };
    static String SHEET = "students";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Student> excelToStudents(InputStream is) {
        try {
            List<Student> students;
            try (Workbook workbook = new XSSFWorkbook(is)) {
                Sheet sheet = workbook.getSheet(SHEET);
                Iterator<Row> rows = sheet.iterator();
                students = new ArrayList<>();
                int rowNumber = 0;
                while (rows.hasNext()) {
                    Row currentRow = rows.next();
                    // пропустить шапку таблицы
                    if (rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }
                    Iterator<Cell> cellsInRow = currentRow.iterator();
                    Student student = new Student();
                    int cellIdx = 0;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();
                        switch (cellIdx) {
                            case 0:
                                student.setId((int) currentCell.getNumericCellValue());
                                break;
                            case 1:
                                student.setFirstName(currentCell.getStringCellValue());
                                break;
                            case 2:
                                student.setLastName(currentCell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cellIdx++;
                    }
                    students.add(student);
                }
                workbook.close();
            }
            return students;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel helper: " + e.getMessage());
        }
    }
}
