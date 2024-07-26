package com.example.testmarshaller.entiteXML.ContractXML;


import com.example.testmarshaller.entiteXML.AmountXML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractXML {

    @XmlElement(name = "BTMID_ContractData")
    private Integer BTMID_ContractData;

    @XmlElement(name = "ContractCode")
    private Long ContractCode;

    @XmlElement(name = "ConsentCode")
    private String ConsentCode;

    @XmlElement(name = "ConsentedLookUp")
    private String ConsentedLookUp;

    @XmlElement(name = "Branch")
    private String Branch;

    @XmlElement(name = "PhaseOfContractLookUp")
    private String PhaseOfContractLookUp;

    @XmlElement(name = "ContractStatusLookUp")
    private String ContractStatusLookUp;

    @XmlElement(name = "TransferStatusLookUp")
    private String TransferStatusLookUp;

    @XmlElement(name = "TypeOfContractLookUp")
    private String TypeOfContractLookUp;

    @XmlElement(name = "PurposeOfFinancingLookUp")
    private String PurposeOfFinancingLookUp;

    @XmlElement(name = "InterestRate")
    private String InterestRate;

    @XmlElement(name = "CurrencyOfContractLookUp")
    private String CurrencyOfContractLookUp;

    @XmlElement(name = "MethodOfPaymentLookUp")
    private String MethodOfPaymentLookUp;
    
    @XmlElement(name = "TotalAmount")
    public AmountXML totalAmont;
    
    @XmlElement(name = "InstallmentAmount")
    public AmountXML installmentAmount;
    
    @XmlElement(name = "NumberOfInstallments")
    private Double NumberOfInstallments;

    @XmlElement(name = "NumberOfOutstandingInstallments")
    private Double NumberOfOutstandingInstallments;

    @XmlElement(name = "OutstandingAmount")
    public AmountXML outstandingAmount;

    @XmlElement(name = "PastDueAmount")
    public AmountXML pastDueAmount;

    @XmlElement(name = "PastDueDays")
    private Double PastDueDays;

    @XmlElement(name = "NumberOfDueInstallments")
    private Double NumberOfDueInstallments;

    @XmlElement(name = "AdditionalFeesSum")
    public AmountXML additionalFeesSum;

    @XmlElement(name = "AdditionalFeesPaid")
    public AmountXML additionalFeesPaid;

    @XmlElement(name = "DateOfLastPayment")
    private String DateOfLastPayment;

    @XmlElement(name = "TotalMonthlyPayment")
    public AmountXML totalMonthlyPayment;

    @XmlElement(name = "PaymentPeriodicityLookUp")
    private String PaymentPeriodicityLookUp;

    @XmlElement(name = "CreditUsageInLast30Days")
    public AmountXML creditUsageInLast30Days;

    @XmlElement(name = "StartDate")
    private String StartDate;

    @XmlElement(name = "ExpectedEndDate")
    private String ExpectedEndDate;

    @XmlElement(name = "RealEndDate")
    private String RealEndDate;

    @XmlElement(name = "NegativeStatusOfContractLookUp")
    private String NegativeStatusOfContractLookUp;

    @XmlElement(name = "DelinquencyDate")
    private String DelinquencyDate;

    @XmlElement(name = "EffectiveCreditRate")
    private String EffectiveCreditRate;

    @XmlElement(name = "ContractLifetime")
    private int ContractLifetime;

    @XmlElement(name = "StateOfContractLookUp")
    private String StateOfContractLookUp;

    @XmlElement(name = "BelongsToGroup")
    private String BelongsToGroup;

    @XmlElement(name = "BelongsToGroupName")
    private String BelongsToGroupName;

    @XmlElement(name = "NatureOfGrantedCreditLookUp")
    private String NatureOfGrantedCreditLookUp;

    @XmlElement(name = "outstandingcredittypelookup")
    private String outstandingcredittypelookup;

    @XmlElement(name = "CreditTermLookUp")
    private String CreditTermLookUp;

    @XmlElement(name = "CreditTypeLookUp")
    private String CreditTypeLookUp;

    @XmlElement(name = "indirectcreditnaturelookup")
    private String indirectcreditnaturelookup;

    @XmlElement(name = "RecipientTypeLookUp")
    private String RecipientTypeLookUp;

    @XmlElement(name = "InitialCreditTermLookUp")
    private String InitialCreditTermLookUp;
    
}
