package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static boolean addQuestion(CCV ccv, XSSFRow row) {
        Question o = new Question();

        String question = row.getCell(5).getStringCellValue();
        String ratingType = row.getCell(8).getStringCellValue();
        String answer = row.getCell(9).getStringCellValue();
        String findings = row.getCell(10).getStringCellValue();

        Question temp = new Question(question, ratingType, answer, findings);

        if (temp.isQuestionNotEmpty()) {
            ccv.getQuestions().add(temp);
            System.out.println("temp added");
            return true;
        }
        return false;
    }

    public static CCV readXLSXFile(File file) throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow fileRow;
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();

        CCV ccv = new CCV();
        Question temp = new Question();
        int rowIndex = 0;
        int columnIndex;
        while (rows.hasNext()) {
            fileRow = (XSSFRow) rows.next();
            Iterator cells = fileRow.cellIterator();

            columnIndex = 0;
            addQuestion(ccv, fileRow);
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();

                //get date rego name and auditor
                if (rowIndex == 3) {
                    switch (columnIndex) {
                        case 2:
                            if (cell.getCellType() == CellType.NUMERIC){
                                Date date = DateUtil.getJavaDate(cell.getNumericCellValue());
                                String dateTime =  new SimpleDateFormat("dd.MM.yyyy").format(date);
                                ccv.setAuditDate(dateTime);
                                System.out.println("date added: " + cell.getDateCellValue());
                            }else{
                                ccv.setAuditDate(cell.getStringCellValue());
                                System.out.println("date added: " + cell.getStringCellValue());
                            }
                            break;
                        case 5:
                            ccv.setRegoName(cell.getStringCellValue());
                            System.out.println("rego added: " + cell.getStringCellValue());
                            break;
                        case 11:
                            ccv.setAuditor(cell.getStringCellValue());
                            System.out.println("auditor added: " + cell.getStringCellValue());
                            break;
                    }
                }

                columnIndex++;
                if (columnIndex > 12) {
                    break;
                }
            }
            rowIndex++;
        }

        System.out.println(ccv.toString());
        ExcelFileToRead.close();
        return ccv;
    }

    public static void read(CCV ccv) throws IOException {
        FileInputStream myxls = new FileInputStream("C:\\Users\\craig.b\\Documents\\test.xlsx");
        XSSFWorkbook ccvSheet = new XSSFWorkbook(myxls);
        XSSFSheet worksheet = ccvSheet.getSheetAt(0);
        int lastRow = worksheet.getLastRowNum();
        System.out.println(lastRow);
        Row row = worksheet.createRow(++lastRow);
        List<Question> temp = ccv.getQuestions();
        for (Question question : temp) {
            row.createCell(0).setCellValue(ccv.getAuditDate());
            row.createCell(1).setCellValue(ccv.getRegoName());
            row.createCell(2).setCellValue(ccv.getAuditor());
            row.createCell(3).setCellValue(question.getQuestion());
            row.createCell(4).setCellValue(question.getRatingType());
            row.createCell(5).setCellValue(question.getAnswer());
            row.createCell(6).setCellValue(question.getFindings());
            row = worksheet.createRow(++lastRow);
        }
        myxls.close();
        FileOutputStream output_file = new FileOutputStream(new File("C:\\Users\\craig.b\\Documents\\test.xlsx"));
        //write changes
        ccvSheet.write(output_file);
        output_file.close();
        System.out.println(" is successfully written");
    }

    public static void main(String[] args) {
        // write your code here

        //File file = new File("C:\\Users\\craig.b\\Downloads\\IPL COVID-19 CCV - MOURA.xlsx");
        if (args.length != 0) {
            for (String file : args) {
                File fileToimport = new File(file);
                try {
                    CCV ccv = readXLSXFile(fileToimport);
                    read(ccv);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
