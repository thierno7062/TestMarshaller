package com.example.testmarshaller.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class ContractEntity {

    //@Id
    private Integer id;
    //private Integer BTMID_ContractData;
    @Id
    @Column(unique = true,nullable = false)
    private Long contractCode;
    private String ConsentCode;
    private String ConsentedLookUp;
    private String branch;

    //@OneToOne
    private String phaseOfContract;

    private String ContractStatus;
    private String TransferStatus;
    private String TypeOfContract;
    private String PurposeOfFinancingLookUp;
    private String InterestRate;
    private String CurrencyOfContractLookUp;
    private String MethodOfPaymentLookUp;
    private Double TotalAmountValue;
    private String Totalamountcurrencylookup;
    private Double InstallmentAmountValue;
    private String InstallmentAmountCurrencyLookup;
    private Double NumberOfInstallments;
    private Double NumberOfOutstandingInstallments;
    private Double OutstandingAmountValue;
    private String Outstandingamountcurrencylookup;
    private Double PastDueAmountValue;
    private String PastDueAmountCurrencylookup;
    private Double PastDueDays;
    private Double NumberOfDueInstallments;
    private Double AdditionalFeesSumValue;
    private String Additionalfeessumcurrencylookup;
    private Double AdditionalFeesPaidValue;
    private String additionalfeespaidcurrencylookup;

    private String DateOfLastPayment;
    private Double TotalMonthlyPaymentValue;
    private String TotalMonthlyPaymentCurrencylookup;
    private String PaymentPeriodicityLookUp;
    private int CreditUsageInLast30DaysValue;
    private String creditusageinlast30dayscurrencylookup;
    private String StartDate;
    private String ExpectedEndDate;

    private String RealEndDate;
    private String NegativeStatusOfContractLookUp;
    private String DelinquencyDate;
    private String EffectiveCreditRate;
    private int ContractLifetime;
    private String StateOfContractLookUp;
    private String YES_NO;
    private String BelongsToGroup;
    private String BelongsToGroupName;
    private String NatureOfGrantedCreditLookUp;
    private String outstandingcredittypelookup;
    private String CreditTermLookUp;
    private String CreditTypeLookUp;
    private String indirectcreditnaturelookup;
    private String RecipientTypeLookUp;
    private String InitialCreditTermLookUp;
//   @OneToOne(mappedBy = "contract")
    @OneToOne(mappedBy = "contract")
    private CollateralEntity collateral;
//   @OneToOne(mappedBy = "contract")
//    private Company company;
//    @OneToOne(mappedBy = "contract")
//    private Individuel individuel;
//    @OneToOne(mappedBy = "contract")
//    private Subjectroles subjectroles;
}















