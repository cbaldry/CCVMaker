package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {


    public static void readXLSXFile() throws IOException
    {

        InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\craig.b\\Downloads\\IPL COVID-19 CCV - MOURA.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();


        int rowIndex = 0;
        int columnIndex = 0;
        String Date;
        String Rego;
        String Owner;

        while (rows.hasNext())
        {
            System.out.print("row " + rowIndex + ": ");
            row=(XSSFRow) rows.next();
            Iterator cells = row.cellIterator();

            columnIndex = 0;
            while (cells.hasNext())
            {

                cell=(XSSFCell) cells.next();
                if (cell.getCellType() == CellType.STRING)
                {
                    System.out.print("column "+ columnIndex + ": " + cell.getStringCellValue()+" ");
                }
                else if(cell.getCellType() == CellType.NUMERIC)
                {
                    System.out.print("column "+ columnIndex + ": " + cell.getNumericCellValue()+" ");
                }
                else
                {
                }
                columnIndex++;
            }
            System.out.println();
            rowIndex++;
        }
    }

    public static void createROW(){

    }

    public static void main(String[] args) {
	// write your code here

        try {
            readXLSXFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
