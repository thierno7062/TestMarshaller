package com.example.testmarshaller.helper;

import com.example.testmarshaller.entity.IndividuelEntity;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
//@RequiredArgsConstructor
@Service
public class IndividuelHelper {



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
    public static List<IndividuelEntity> convertExcelToListOfProduct(InputStream is){
        List<IndividuelEntity> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Individual");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                IndividuelEntity ind = new IndividuelEntity();
                //Country country = new Country();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            ind.setBTMID_Individual((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            ind.setContractCode((long) cell.getNumericCellValue());
                            break;
                        case 2:
                            ind.setCustomerCode(cell.getStringCellValue());
                            break;
                        case 3:
                            ind.setPresentSurname(cell.getStringCellValue());
                            break;
                        case 4:
                            ind.setFirstName(cell.getStringCellValue());
                            break;
                        case 5:
                            ind.setFullName(cell.getStringCellValue());
                            break;
                        case 6:
                            ind.setMothersMaidenName(cell.getStringCellValue());
                            break;
                        case 7:
                            ind.setNumberOfChildren((int) cell.getNumericCellValue());
                            break;
                        case 8:
                            ind.setNumberOfSpouses((int) cell.getNumericCellValue());
                            break;
                        case 9:
                            ind.setClassificationOfIndividualLookUp(cell.getStringCellValue());
                            break;
                        case 10:
                            ind.setGenderLookUp(cell.getStringCellValue());
                            break;
                        case 11:
                            //System.out.println(cell.getCellType());
                            if (cell.getCellType()== CellType.NUMERIC){
                                ind.setDateOfBirth(cell.getDateCellValue().toString());
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setDateOfBirth(cell.getDateCellValue().toString());
                            }
                            //ind.setDateOfBirth(country.getCode());

                            break;
                        case 12:
                            /*String code = cell.getStringCellValue();
                            Country country= countryService.getCountryByCode(code);
                            if (country==null){
                                //return Exception()
                            }else {
                                ind.setCountryOfBirthLookUp(country);
                            }*/
                           ind.setCountryOfBirthLookUp(cell.getStringCellValue());
                            System.out.println(cell.getCellType());

                            break;
                        case 13:
                            ind.setPlaceOfBirth(cell.getStringCellValue());
                            break;
                        case 14:
                            ind.setMaritalStatusLookUp(cell.getStringCellValue());
                            break;
                        case 15:
                            ind.setSocialStatusLookUp(cell.getStringCellValue());
                            break;
                        case 16:
                            ind.setResidencyLookUp(cell.getStringCellValue());
                            break;
                        case 17:
                            ind.setNationalityLookUp(cell.getStringCellValue());
                            break;
                        case 18:
                            ind.setEmploymentLookUp(cell.getStringCellValue());
                            break;
                        case 19:
                            ind.setEducationLookUp(cell.getStringCellValue());
                            break;
                        case 20:
                            ind.setBusinessName(cell.getStringCellValue());
                            break;
                        case 21:
                            ind.setIncomeAvailable(cell.getNumericCellValue());
                            break;
                        case 22:
                            ind.setMonthlyExpenses(cell.getNumericCellValue());
                            break;
                        case 23:
                            ind.setNegativeStatusOfIndividualLookUp(cell.getStringCellValue());
                            break;
                        case 24:
                            ind.setPhoneNumber((long)cell.getNumericCellValue());
                            break;
                        case 25:
                            ind.setProfessionalCategoryLookUp(cell.getStringCellValue());
                            break;
                        case 26:
                            ind.setPaymentIncident((int) cell.getNumericCellValue());
                            break;
                        case 27:
                            if (cell.getCellType()== CellType.NUMERIC){
                                ind.setIdNumbersNationalID(String.valueOf((long)cell.getNumericCellValue()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setIdNumbersNationalID(cell.getStringCellValue());
                            }
                            //ind.setIdNumbersNationalID((long)cell.getNumericCellValue());
                            break;
                        case  28:
                            if (cell.getCellType()== CellType.NUMERIC){
                                ind.setIdNumbersNationalIDIssueDate(String.valueOf(cell.getDateCellValue().toString()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setIdNumbersNationalIDIssueDate(cell.getStringCellValue());
                            }

                            break;
                        case  29:
                            if (cell.getCellType()== CellType.NUMERIC){
                                ind.setIdNumbersNationalIDExpirationDate(String.valueOf(cell.getDateCellValue().toString()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setIdNumbersNationalIDExpirationDate(cell.getStringCellValue());
                            }
                            //ind.setIdNumbersNationalIDExpirationDate(cell.getDateCellValue().toString());
                            break;
                        case 30:
                            ind.setIdNumbersNationalIDIssuerCountryLookUp(cell.getStringCellValue());
                            break;
                        case 31:
                            if (cell.getCellType()==CellType.NUMERIC){
                                ind.setPassportNumber(String.valueOf(cell.getNumericCellValue()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                            ind.setPassportNumber(cell.getStringCellValue());
                            }

                            break;
                        case 32:
                            //ind.setPassportIssueDate(cell.getStringCellValue());
                            if (cell.getCellType()== CellType.NUMERIC){
                                ind.setPassportIssueDate(String.valueOf(cell.getDateCellValue().toString()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setPassportIssueDate(cell.getStringCellValue());
                            }
                            break;
                        case 33:
                            //ind.setPassportExpirationDate(cell.getStringCellValue());
                            if (cell.getCellType()== CellType.NUMERIC){
                                ind.setPassportExpirationDate(String.valueOf(cell.getDateCellValue().toString()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setPassportExpirationDate(cell.getStringCellValue());
                            }
                            break;
                        case 34:
                            ind.setPassportIssuerCountry(cell.getStringCellValue());
                            break;
                        case 35:
                            ind.setResidencePermitNumber(cell.getStringCellValue());
                            break;
                        case 36:
                            ind.setResidencePermitIssueDate(cell.getStringCellValue());
                            break;
                        case 37:
                            ind.setResidencePermitExpirationDate(cell.getStringCellValue());
                            break;
                        case 38:
                            ind.setResidencePermitIssuerCountry(cell.getStringCellValue());
                            break;
                        case 39:
                            ind.setDrivingLicenseNumber(cell.getStringCellValue());
                            break;
                        case 40:
                            ind.setDrivingLicenseIssueDate(cell.getStringCellValue());
                            break;
                        case 41:
                            ind.setDrivingLicenseExpirationDate(cell.getStringCellValue());
                            break;
                        case 42:
                            ind.setDrivingLicenseIssuerCountry(cell.getStringCellValue());
                            break;
                        case 43:
                            ind.setConsularCard(cell.getStringCellValue());
                            break;
                        case 44:
                            ind.setConsularCardIssueDate(cell.getStringCellValue());
                            break;
                        case 45:
                            ind.setConsularCardExpirationDate(cell.getStringCellValue());
                            break;
                        case 46:
                            ind.setConsularCardIssuerCountry(cell.getStringCellValue());
                            break;
                        case 47:
                            ind.setBIN(cell.getStringCellValue());
                            break;
                        case 48:
                            ind.setBINIssuerCountry(cell.getStringCellValue());
                            break;
                        case 49:
                            ind.setIDDocumentNumber(cell.getStringCellValue());
                            break;
                        case 50:
                            ind.setIDDocumentIssueDate(cell.getStringCellValue());
                            break;
                        case 51:
                            ind.setIDDocumentExpirationDate(cell.getStringCellValue());
                            break;
                        case 52:
                            ind.setIDDocumentIssuerCountry(cell.getStringCellValue());
                            break;
                        case 53:
                            ind.setIDDocumentIssueAuthority(cell.getStringCellValue());
                            break;
                        case 54:
                            if (cell.getCellType()==CellType.NUMERIC){
                                ind.setMainAddressAddressLine(String.valueOf(cell.getNumericCellValue()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setMainAddressAddressLine(cell.getStringCellValue());
                            }
                            break;
                        case 55:
                            if (cell.getCellType()==CellType.NUMERIC){
                                ind.setContactsMobilePhone(String.valueOf((long)cell.getNumericCellValue()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setContactsMobilePhone(cell.getStringCellValue());
                            }
                            break;
                        case 56:
                            if (cell.getCellType()==CellType.NUMERIC){
                                ind.setFixedLine(String.valueOf((long)cell.getNumericCellValue()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setFixedLine(cell.getStringCellValue());
                            }

                            break;
                        case 57:
                            ind.setEmail(cell.getStringCellValue());
                            break;
                        case 58:
                            ind.setWebPage(cell.getStringCellValue());
                            break;
                        case 59:
                            if (cell.getCellType()==CellType.NUMERIC){
                                ind.setFax(String.valueOf(cell.getNumericCellValue()));
                            }
                            if (cell.getCellType()==CellType.STRING){
                                ind.setFax(cell.getStringCellValue());
                            }
                            break;
                        case 60:
                            ind.setContactsPhoneNumber((long)cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(ind);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
