package testutilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadDataFromExcel {


    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

        try
        {
            int col;
            //Create an object of File class to open xlsx file
            File file = new File(filePath +"\\"+ fileName);

            //Create an object of FileInputStream class to read excel file
            FileInputStream inputStream = new FileInputStream(file);

            Workbook ParaBankWorkbook = null;

            //Find the file extension by splitting file name in substring  and getting only extension name
            String fileExtensionName = fileName.substring(fileName.indexOf("."));

            //Check condition if the file is xlsx file or xls file
            if (fileExtensionName.equals(".xlsx"))
            {
                ParaBankWorkbook = new XSSFWorkbook(inputStream);
            }
            else if (fileExtensionName.equals(".xls"))
            {
                ParaBankWorkbook = new HSSFWorkbook(inputStream);
            }

            //Read sheet inside the workbook by its name
            assert ParaBankWorkbook != null;
            Sheet ParaBankSheet = ParaBankWorkbook.getSheet(sheetName);

            //Find number of rows in excel file
            int rowCount = ParaBankSheet.getLastRowNum() - ParaBankSheet.getFirstRowNum();

            //Create a loop over all the rows of excel file to read it
            for (int i=0; i<=rowCount; i++)
            {
                Row row = ParaBankSheet.getRow(i);
                //System.out.println(row.getLastCellNum());
                col = row.getLastCellNum();
                String[] input = new String[col];
                //Create a loop to print cell values in a row
                //System.out.println(row.getCell(1).getStringCellValue());
                //System.out.println(row.getCell(0).getStringCellValue());
                for (int j=0; j<row.getLastCellNum(); j++)
                {
                    //Print Excel data in console
                    //System.out.println(row.getCell(j).getStringCellValue()+"|| ");
                    input[j] = new DataFormatter().formatCellValue(row.getCell(j));
                    //System.out.println(input[j]);
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void Initialze() throws IOException
    {
        //Create an object of ReadGuru99ExcelFile class
        //ReadDataFromExcel objExcel = new ReadDataFromExcel();
        //Prepare the path of excel file
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\ParaBank_TestData.xlsx";

        readExcel(filePath, "ParaBank_TestData.xlsx", "LoginTests");

    }

    public static String Data(String ColumnName) throws FileNotFoundException, IOException, InterruptedException, AWTException, EncryptedDocumentException, InvalidFormatException
    {
        //CommonMethods.ReadTestData("GSKSearch");

        String SheetName = "LoginTests";
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\ParaBank_TestData.xlsx");
        FileInputStream fis = new FileInputStream(file);

        Workbook wBook = WorkbookFactory.create(fis);

        Sheet sheet = wBook.getSheet(SheetName);
        // it will take value from first row
        Row row = sheet.getRow(0);
        //it will give you count of row which is used or filled
        short lastcolumnused = row.getLastCellNum();

        int colnum = 0;
        for (int i = 0; i < lastcolumnused; i++)
        {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName))
            {
                colnum = i;
                break;
            }
        }

        // it will take value from Second row
        row = sheet.getRow(1);
        Cell column = row.getCell(colnum);

        return column.getStringCellValue();

    }



}