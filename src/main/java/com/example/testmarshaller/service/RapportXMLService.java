package com.example.testmarshaller.service;


import com.example.testmarshaller.entiteXML.CollateralXML.CollateralXML;
import com.example.testmarshaller.entiteXML.CompanyXML.CompanyXML;
import com.example.testmarshaller.entiteXML.ContractXML.ContractCodeXML;
import com.example.testmarshaller.entiteXML.ContractXML.ContractListXML;
import com.example.testmarshaller.entiteXML.ContractXML.ContractXML;
import com.example.testmarshaller.entiteXML.RapportXML;
import com.example.testmarshaller.entity.*;
import com.example.testmarshaller.helper.FileHelper;
import com.example.testmarshaller.repository.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



@SuppressWarnings("unused")
@Service
@AllArgsConstructor
@Slf4j
public class RapportXMLService {


    private ContractRepo contractRepo;
    private CollateralRepo collateralRepo;
    private IndividuelRepo individuelRepo;
    private SubjectroleRepository subjectroleRepository;
    private CompanyRepo companyRepo;

    public ContractListXML listXML() throws Exception {
        List<ContractEntity> contractListEntity = this.contractRepo.findAll();
        List<CollateralEntity> collateralListEntity = this.collateralRepo.findAll();
        System.out.println(contractListEntity);

        // List<Collateral> collateralListEntity = this.collateralRepo.findAll();

        ContractListXML contractListXML = new ContractListXML();
        List<ContractXML> contractXMLS = new ArrayList<>();
        List<CollateralXML> collateralXMLs = new ArrayList<>();
        List<CompanyXML> companyXMLs = new ArrayList<>();

        /* ************ */
        RapportXML rapportXML = new RapportXML();
        List<ContractListXML> contractListXMLs = new ArrayList<>();

        for (ContractEntity item : contractListEntity) {

            log.info("dans item on a :{}", item.toString());

            ContractXML element = new ContractXML();

            element.setBTMID_ContractData(item.getId());
            element.setContractCode(item.getContractCode());
            element.setConsentCode(item.getConsentCode());
            element.setConsentedLookUp(item.getConsentedLookUp());
            element.setBranch(item.getBranch());
            element.setPhaseOfContractLookUp(item.getPhaseOfContract());
            element.setContractStatusLookUp(item.getContractStatus());
            element.setTransferStatusLookUp(item.getTransferStatus());
            element.setTypeOfContractLookUp(item.getTypeOfContract());
            element.setPurposeOfFinancingLookUp(item.getPurposeOfFinancingLookUp());
            element.setInterestRate(item.getInterestRate());
            element.setCurrencyOfContractLookUp(item.getCurrencyOfContractLookUp());
            element.setMethodOfPaymentLookUp(item.getMethodOfPaymentLookUp());
            // element.setTotalAmont(item.getTotalAmountValue());
            // element.setTotalAmountValue(item.getTotalAmountValue());
            // element.setTotalamountcurrencylookup(item.getTotalamountcurrencylookup());
            // element.setInstallmentAmountValue(item.getInstallmentAmountValue());
            // element.setInstallmentAmountCurrencyLookup(item.getInstallmentAmountCurrencyLookup());
            element.setNumberOfInstallments(item.getNumberOfInstallments());
            element.setNumberOfOutstandingInstallments(item.getNumberOfOutstandingInstallments());
            // element.setOutstandingAmountValue(item.getOutstandingAmountValue());
            // element.setOutstandingamountcurrencylookup(item.getOutstandingamountcurrencylookup());
            // element.setPastDueAmountValue(item.getPastDueAmountValue());
            // element.setPastDueAmountCurrencylookup(item.getPastDueAmountCurrencylookup());
            element.setPastDueDays(item.getPastDueDays());
            element.setNumberOfDueInstallments(item.getNumberOfDueInstallments());
            // element.setAdditionalFeesSumValue(item.getAdditionalFeesSumValue());
            // element.setAdditionalfeessumcurrencylookup(item.getAdditionalfeessumcurrencylookup());
            // element.setAdditionalFeesPaidValue(item.getAdditionalFeesPaidValue());
            // element.setAdditionalfeespaidcurrencylookup(item.getAdditionalfeespaidcurrencylookup());
            element.setDateOfLastPayment(item.getDateOfLastPayment());
            // element.setTotalMonthlyPaymentValue(item.getTotalMonthlyPaymentValue());
            // element.setTotalMonthlyPaymentCurrencylookup(item.getTotalMonthlyPaymentCurrencylookup());
            element.setPaymentPeriodicityLookUp(item.getPaymentPeriodicityLookUp());
            // element.setCreditUsageInLast30DaysValue(item.getCreditUsageInLast30DaysValue());
            // element.setCreditusageinlast30dayscurrencylookup(item.getCreditusageinlast30dayscurrencylookup());
            element.setStartDate(item.getStartDate());
            element.setExpectedEndDate(item.getExpectedEndDate());
            element.setRealEndDate(item.getRealEndDate());
            element.setNegativeStatusOfContractLookUp(item.getNegativeStatusOfContractLookUp());
            element.setDelinquencyDate(item.getDelinquencyDate());
            element.setEffectiveCreditRate(item.getEffectiveCreditRate());
            element.setContractLifetime(item.getContractLifetime());
            element.setStateOfContractLookUp(item.getStateOfContractLookUp());
            element.setBelongsToGroup(item.getBelongsToGroup());
            element.setBelongsToGroupName(item.getBelongsToGroupName());
            element.setNatureOfGrantedCreditLookUp(item.getNatureOfGrantedCreditLookUp());
            element.setOutstandingcredittypelookup(item.getOutstandingcredittypelookup());
            element.setCreditTermLookUp(item.getCreditTermLookUp());
            element.setCreditTypeLookUp(item.getCreditTypeLookUp());
            element.setIndirectcreditnaturelookup(item.getIndirectcreditnaturelookup());
            element.setRecipientTypeLookUp(item.getRecipientTypeLookUp());
            element.setInitialCreditTermLookUp(item.getInitialCreditTermLookUp());

            contractXMLS.add(element);
        }

        // contractListXML.setContractXMLS(contractXMLS);
        // contractListXML.setCollateralXMLS(collateralXMLs);
        // System.out.println(contractListXML.toString());
        JAXBContext context = JAXBContext.newInstance(ContractListXML.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(contractListXML,
                new FileWriter("C:\\Users\\user\\Documents\\2024\\2024\\Fichier XML\\test\\rapport.xml"));
        // new FileWriter("/Users/thiernoniang/Documents/2024/Fichier
        // XML/contract.xml"));
        System.out.println("Marshalling done");

        return contractListXML;
    }

    public RapportXML rapportXML() throws Exception{
        List<ContractEntity> contractListEntity = this.contractRepo.findAll();
        RapportXML rapportXML= null;

        List<ContractListXML> contract = new ArrayList<ContractListXML>();

        ContractCodeXML contractCode= new ContractCodeXML();
        ContractXML contractXML = new ContractXML();

        for (ContractEntity item: contractListEntity){

            contractXML.setBTMID_ContractData(item.getId());
            contractXML.setContractCode(item.getContractCode());

        }

        ContractListXML contractListXML= new ContractListXML(contractCode, contractXML);
        rapportXML= new RapportXML(contract);
        FileHelper.convertReportToXML(rapportXML, "/Users/thiernoniang/Documents/2024/Fichier XML");

        return rapportXML;
    }

    public ContractListXML contractListXML() throws Exception{
        List<ContractEntity> contractListEntity = this.contractRepo.findAll();
        RapportXML rapportXML= null;

        List<ContractListXML> contract = new ArrayList<ContractListXML>();

        ContractCodeXML contractCode= new ContractCodeXML();
        ContractXML contractXML = new ContractXML();

        for (ContractEntity item: contractListEntity){
            ContractListXML ctl = new ContractListXML();

            ContractCodeXML contractCodeXML = new ContractCodeXML();
            contractCodeXML.setContractCode(item.getContractCode());

            ctl.setContractCode(contractCodeXML);

            ContractXML ctxml = new ContractXML();
            ctxml.setBTMID_ContractData(item.getId());

            ctl.setContractXMLS(ctxml);

            contract.add(ctl);
            //contractXML.setBTMID_ContractData(item.getId());
            //contractXML.setContractCode(item.getContractCode());

        }

        ContractListXML contractListXML= new ContractListXML(contractCode, contractXML);
        rapportXML= new RapportXML(contract);
        FileHelper.convertReportToXML(rapportXML, "./");

        return contractListXML;
    }
}
