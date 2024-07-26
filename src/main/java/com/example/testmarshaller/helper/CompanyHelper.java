package com.example.testmarshaller.helper;

import com.example.testmarshaller.entity.CompanyEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompanyHelper {

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
    public static List<CompanyEntity> convertExcelToListOfelement(InputStream is){

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

                    switch (cid) {
                        case 0:
                            p.setBTMID_Company((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            p.setContractCode((long) cell.getNumericCellValue());
                            break;
                        case 2:
                            p.setCustomerCode(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setCompanyName(cell.getStringCellValue());
                            break;
                        case 4:
                            p.setTradeName(cell.getStringCellValue());
                            break;
                        case 5:
                            p.setLegalFormLookUp(cell.getStringCellValue());
                            break;
                        case 6:
                            p.setBusinessStatusLookUp(cell.getStringCellValue());
                            break;
                        case 7:
                            p.setEstablishmentDate(cell.getDateCellValue().toString());
                            break;
                        case 8:
                            p.setNumberOfEmployees((int) cell.getNumericCellValue());
                            break;
                        case 9:
                            p.setIndustrySectorLookUp(cell.getStringCellValue());
                            break;
                        case 10:
                            p.setResidencyLookUp(cell.getStringCellValue());
                            break;
                        case 11:
                            p.setNationalityLookUp(cell.getStringCellValue());
                            break;
                        case 12:
                            p.setSigle(cell.getStringCellValue());
                            break;
                        case 13:
                            p.setEconomicStatusLookUp(cell.getStringCellValue());
                            break;
                        case 14:
                            p.setPaymentIncident((int)cell.getNumericCellValue());
                            break;
                        case 15:
                            p.setAnnualSalesValue((long)cell.getNumericCellValue());
                            break;
                        case 16:
                            p.setAnnualSalesCurrencyLookup(cell.getStringCellValue());
                            break;
                        case 17:
                            p.setIdentificationNumbersRegistrationNumber(cell.getStringCellValue());
                            break;
                        case 18:
                            p.setIdRegistrationNumberIssuerCountryLookUp(cell.getStringCellValue());
                            break;
                        case 19:
                            //System.out.println(cell.getCellType());
                            if (cell.getCellType()== CellType.STRING){
                                p.setIdentificationNumbersTaxNumber(cell.getStringCellValue());
                            }
                            if (cell.getCellType()== CellType.NUMERIC){
                                p.setIdentificationNumbersTaxNumber(String.valueOf((int)cell.getNumericCellValue()));
                            }
                            break;
                        case 20:
                            p.setIdNumbersTaxNumberIssuerCountryLookUp(cell.getStringCellValue());
                            break;
                        case 21:
                            p.setBCEAONumber(cell.getStringCellValue());
                            break;
                        case 22:
                            p.setBCEAONumberIssuerCountry(cell.getStringCellValue());
                            break;
                        case 23:
                            p.setPOBox(cell.getStringCellValue());
                            break;
                        case 24:
                            p.setStreet(cell.getStringCellValue());
                            break;
                        case 25:
                            p.setNumberOfBuilding(cell.getStringCellValue());
                            break;
                        case 26:
                            p.setCity(cell.getStringCellValue());
                            break;
                        case 27:
                            p.setRegion(cell.getStringCellValue());
                            break;
                        case 28:
                            p.setDistrict(cell.getStringCellValue());
                            break;
                        case 29:
                            p.setCountry(cell.getStringCellValue());
                            break;
                        case 30:
                            p.setGPS(cell.getStringCellValue());
                            break;
                        case 31:
                            p.setMainAddressLine(cell.getStringCellValue());
                            break;
                        case 32:
                            p.setMobilePhone((long)cell.getNumericCellValue());
                            break;
                        case 33:
                            p.setFixedLine((long) cell.getNumericCellValue());
                            break;
                        case 34:
                            p.setEmail(cell.getStringCellValue());
                            break;
                        case 35:
                            p.setWebPage(cell.getStringCellValue());
                            break;
                        case 36:
                            p.setFax(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
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
