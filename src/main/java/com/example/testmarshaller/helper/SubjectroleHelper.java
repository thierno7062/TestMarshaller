package com.example.testmarshaller.helper;

import com.example.testmarshaller.entity.SubjectrolesEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SubjectroleHelper {

    //check that file is of Excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    //convert excel to list of products

    public static List<SubjectrolesEntity> convertExcelToListOfProduct(InputStream is) {
        List<SubjectrolesEntity> list = new ArrayList<>();

        //String dateFormat= "dd-MM-yyyy";

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Subjectroles");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            /*CellStyle style = workbook.createCellStyle();
            style.setDataFormat(style.getDataFormat());*/

            CellStyle cellStyle = workbook.createCellStyle();
            workbook.createSheet();
            XSSFCell dateCell = sheet.createRow(0).createCell(0);
            dateCell.setCellValue(new Date());

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                SubjectrolesEntity c = new SubjectrolesEntity();

                /*String excelDateFormat = "dd-MM-YYYY";
                CellStyle cellStyle = workbook.createCellStyle();
                XSSFDataFormat dateFormat = workbook.createDataFormat();

                cellStyle.setDataFormat(dateFormat(excelDateFormat));*/

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            c.setBTMID_SubjectRoles((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            c.setContractCode((long) cell.getNumericCellValue());
                            //c.getContract().setContractCode(cell.getNumericCellValue());
                            break;
                        case 2:
                            c.setCustomerCode(cell.getStringCellValue());
                            break;
                        case 3:
                            c.setRoleOfCustomer(cell.getStringCellValue());
                            //c.getContract().setContractCode((int) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(c);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
