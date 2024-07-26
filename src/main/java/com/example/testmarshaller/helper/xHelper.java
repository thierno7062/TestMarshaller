package com.example.testmarshaller.helper;

import com.example.testmarshaller.entity.CompanyEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xHelper {

    //check that file is of Excel type or not
    @SuppressWarnings("null")
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    //convert excel to list of products
    public static List<CompanyEntity> convertExcelToListOfCompany(InputStream is){
        List<CompanyEntity> list = new ArrayList<>();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Company");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0 ) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                CompanyEntity p = new CompanyEntity();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    /* switch (cid) {
                        case 0:
                            p.setBTMID_Company((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            p.setContractCode(cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    } */
                    cid++;

                }

                list.add(p);


            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
