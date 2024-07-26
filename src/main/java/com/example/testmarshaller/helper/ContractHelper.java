package com.example.testmarshaller.helper;

import com.example.testmarshaller.entity.ContractEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContractHelper {

    // check that file is an Excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }

    // convert excel to list of products
    public static List<ContractEntity> convertExcelToListOfProduct(InputStream is) {
        List<ContractEntity> list = new ArrayList<>();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("ContractDatabon");

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

                ContractEntity p = new ContractEntity();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            p.setId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            p.setContractCode((long) cell.getNumericCellValue());
                            break;
                        case 2:
                            p.setConsentCode(cell.getStringCellValue());
                            break;
                        case 3:
                            p.setConsentedLookUp(cell.getStringCellValue());
                            break;
                        case 4:
                            p.setBranch(cell.getStringCellValue());
                            break;
                        case 5:
                            p.setPhaseOfContract(cell.getStringCellValue());
                            break;
                        case 6:
                            p.setContractStatus(cell.getStringCellValue());
                            break;
                        case 7:
                            p.setTransferStatus(cell.getStringCellValue());
                            break;
                        case 8:
                            p.setTypeOfContract(cell.getStringCellValue());
                            break;
                        case 9:
                            p.setPurposeOfFinancingLookUp(cell.getStringCellValue());
                            break;
                        case 10:
                            if (cell.getCellType() == CellType.NUMERIC) {
                                p.setInterestRate(String.valueOf(cell.getNumericCellValue()));
                            }
                            if (cell.getCellType() == CellType.STRING) {
                                p.setInterestRate(cell.getStringCellValue());
                            }
                            break;
                        case 11:
                            p.setCurrencyOfContractLookUp(cell.getStringCellValue());
                            break;
                        case 12:
                            p.setMethodOfPaymentLookUp(cell.getStringCellValue());
                            break;
                        case 13:
                            p.setTotalAmountValue(cell.getNumericCellValue());
                            break;
                        case 14:
                            p.setTotalamountcurrencylookup(cell.getStringCellValue());
                            break;
                        case 15:
                            p.setInstallmentAmountValue(cell.getNumericCellValue());
                            break;
                        case 16:
                            p.setInstallmentAmountCurrencyLookup(cell.getStringCellValue());
                            break;
                        case 17:
                            p.setNumberOfInstallments(cell.getNumericCellValue());
                            break;
                        case 18:
                            p.setNumberOfOutstandingInstallments(cell.getNumericCellValue());
                            break;
                        case 19:
                            p.setOutstandingAmountValue(cell.getNumericCellValue());
                            break;
                        case 20:
                            p.setOutstandingamountcurrencylookup(cell.getStringCellValue());
                            break;
                        case 21:
                            p.setPastDueAmountValue(cell.getNumericCellValue());
                            break;
                        case 22:
                            p.setPastDueAmountCurrencylookup(cell.getStringCellValue());
                            break;
                        case 23:
                            p.setPastDueDays(cell.getNumericCellValue());
                            break;
                        case 24:
                            p.setNumberOfDueInstallments(cell.getNumericCellValue());
                            break;
                        case 25:
                            p.setAdditionalFeesSumValue(cell.getNumericCellValue());
                            break;
                        case 26:
                            p.setAdditionalfeessumcurrencylookup(cell.getStringCellValue());
                            break;
                        case 27:
                            p.setAdditionalFeesPaidValue(cell.getNumericCellValue());
                            break;
                        case 28:
                            p.setAdditionalfeespaidcurrencylookup(cell.getStringCellValue());
                            break;
                        case 29:
                            /* System.out.println((int)cell.getNumericCellValue()); */
                            // System.out.println();
                            p.setDateOfLastPayment(cell.getStringCellValue());
                            /*
                             * if (cell.getCellType()== CellType.BLANK){
                             * p.setDateOfLastPayment(Integer.valueOf(""));
                             * System.out.println(cell.getCellType());
                             * System.out.println(cell.getStringCellValue());
                             * }
                             */
                            break;
                        case 30:

                            p.setTotalMonthlyPaymentValue(cell.getNumericCellValue());

                            /*
                             * if (cell.getCellType()== CellType.NUMERIC){
                             * p.setTotalMonthlyPaymentValue((int) cell.getNumericCellValue());
                             * }if (cell.getCellType()== CellType.STRING){
                             * p.setTotalMonthlyPaymentValue(Integer.parseInt(String.valueOf((int)cell.
                             * getNumericCellValue())));
                             * }if (cell.getCellType()== CellType.BLANK){
                             * p.setTotalMonthlyPaymentValue(Integer.parseInt(""));
                             * }
                             */

                            break;
                        case 31:
                            p.setTotalMonthlyPaymentCurrencylookup(cell.getStringCellValue());
                            break;
                        case 32:
                            p.setPaymentPeriodicityLookUp(cell.getStringCellValue());
                            break;
                        case 33:
                            p.setCreditUsageInLast30DaysValue((int) cell.getNumericCellValue());
                            break;
                        case 34:
                            p.setCreditusageinlast30dayscurrencylookup(cell.getStringCellValue());
                            break;
                        case 35:
                            // p.setAJ(cell.getNumericCellValue());
                            // System.out.println(cell.getDateCellValue().toString());
                            // System.out.println(cell.getCellType());
                            if (cell.getCellType() == CellType.NUMERIC) {
                                p.setStartDate(cell.getDateCellValue().toString());
                            }
                            if (cell.getCellType() == CellType.BLANK) {
                                p.setStartDate("");
                            }

                            break;
                        case 36:
                            // p.setAK(cell.getNumericCellValue());
                            // System.out.println(cell.getCellType());
                            // System.out.println(cell.getRowIndex());
                            if (cell.getCellType() == CellType.NUMERIC) {
                                // p.setExpectedEndDate(cell.getDateCellValue().toString());
                                p.setExpectedEndDate(cell.getDateCellValue().toString());
                                // System.out.println(cell.getDateCellValue().toString());
                            }
                            if (cell.getCellType() == CellType.BLANK) {
                                p.setExpectedEndDate("");
                                // System.out.println(cell.getNumericCellValue());
                            }

                            break;
                        case 37:
                            // p.setAL(cell.getStringCellValue());
                            // p.setRealEndDate(cell.getStringCellValue());
                            if (cell.getCellType() == CellType.NUMERIC) {
                                // p.setExpectedEndDate(cell.getDateCellValue().toString());
                                p.setRealEndDate(cell.getDateCellValue().toString());
                                // System.out.println(cell.getDateCellValue().toString());
                            }
                            if (cell.getCellType() == CellType.BLANK) {
                                p.setRealEndDate("");
                                // System.out.println(cell.getNumericCellValue());
                            }
                            break;
                        case 38:
                            p.setNegativeStatusOfContractLookUp(cell.getStringCellValue());
                            break;
                        case 39:
                            p.setDelinquencyDate(cell.getStringCellValue());
                            break;
                        case 40:
                            // System.out.println(cell.getCellType());
                            if (cell.getCellType() == CellType.STRING) {
                                p.setEffectiveCreditRate(cell.getStringCellValue());
                            }
                            if (cell.getCellType() == CellType.NUMERIC) {
                                p.setEffectiveCreditRate(String.valueOf((int) cell.getNumericCellValue()));
                            }
                            break;
                        case 41:
                            p.setContractLifetime((int) cell.getNumericCellValue());
                            break;
                        case 42:
                            p.setStateOfContractLookUp(cell.getStringCellValue());
                            break;
                        case 43:
                            p.setYES_NO(cell.getStringCellValue());
                            break;
                        case 44:
                            p.setBelongsToGroupName(cell.getStringCellValue());
                            break;
                        case 45:
                            p.setNatureOfGrantedCreditLookUp(cell.getStringCellValue());
                            break;
                        case 46:
                            p.setOutstandingcredittypelookup(cell.getStringCellValue());
                            break;
                        case 47:
                            p.setCreditTermLookUp(cell.getStringCellValue());
                            break;
                        case 48:
                            p.setCreditTypeLookUp(cell.getStringCellValue());
                            break;
                        case 49:
                            p.setIndirectcreditnaturelookup(cell.getStringCellValue());
                            break;
                        case 50:
                            p.setRecipientTypeLookUp(cell.getStringCellValue());
                            break;
                        case 51:
                            p.setInitialCreditTermLookUp(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(p);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
