package com.polishchuk_s.university.helper;

import com.polishchuk_s.university.model.Lecture;
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

public class hExcelLecture {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "id", "name" };
    static String SHEET = "lectures";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Lecture> excelToLecture(InputStream is) {
        try {
            List<Lecture> lectures;
            try (Workbook workbook = new XSSFWorkbook(is)) {
                Sheet sheet = workbook.getSheet(SHEET);
                Iterator<Row> rows = sheet.iterator();
                lectures = new ArrayList<>();
                int rowNumber = 0;
                while (rows.hasNext()) {
                    Row currentRow = rows.next();
                    // пропустить шапку таблицы
                    if (rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }
                    Iterator<Cell> cellsInRow = currentRow.iterator();
                    Lecture lecture = new Lecture();
                    int cellIdx = 0;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();
                        switch (cellIdx) {
                            case 0:
                                lecture.setIdLecture((int) currentCell.getNumericCellValue());
                                break;
                            case 1:
                                lecture.setNameLecture(currentCell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cellIdx++;
                    }
                    lectures.add(lecture);
                }
                workbook.close();
            }
            return lectures;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel helper: " + e.getMessage());
        }
    }
}
