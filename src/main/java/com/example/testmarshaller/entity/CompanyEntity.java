package com.example.testmarshaller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CompanyEntity {

    @Id
    private Integer BTMID_Company;
    private Long ContractCode;
    private String CustomerCode;
    private String CompanyName;
    private String TradeName;
    private String LegalFormLookUp;
    private String BusinessStatusLookUp;
    private String EstablishmentDate;
    private int NumberOfEmployees;
    private String IndustrySectorLookUp;
    private String ResidencyLookUp;
    private String NationalityLookUp;
    private String Sigle;
    private String EconomicStatusLookUp;
    private int PaymentIncident;
    private Long AnnualSalesValue;
    private String AnnualSalesCurrencyLookup;
    private String IdentificationNumbersRegistrationNumber;
    private String IdRegistrationNumberIssuerCountryLookUp;
    private String IdentificationNumbersTaxNumber;
    private String IdNumbersTaxNumberIssuerCountryLookUp;
    private String BCEAONumber;
    private String BCEAONumberIssuerCountry;
    private String POBox;
    private String Street;
    private String NumberOfBuilding;
    private String City;
    private String Region;
    private String District;
    private String Country;
    private String GPS;
    private String MainAddressLine;
    private long MobilePhone;
    private long FixedLine;
    private String Email;
    private String WebPage;
    private String Fax;
    /*@OneToOne
    @JoinColumn(referencedColumnName = "BTMID_ContractData")
    private Contract contract;*/
}
