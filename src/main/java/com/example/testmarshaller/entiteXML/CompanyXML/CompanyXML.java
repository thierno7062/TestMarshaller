package com.example.testmarshaller.entiteXML.CompanyXML;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class CompanyXML {

    @XmlElement
    private Integer BTMID_Company;
    @XmlElement
    private Long ContractCode;
    @XmlElement
    private String CustomerCode;
    @XmlElement
    private String CompanyName;
    @XmlElement
    private String TradeName;
    @XmlElement
    private String LegalFormLookUp;
    @XmlElement
    private String BusinessStatusLookUp;
    @XmlElement
    private String EstablishmentDate;
    @XmlElement
    private int NumberOfEmployees;
    @XmlElement
    private String IndustrySectorLookUp;
    @XmlElement
    private String ResidencyLookUp;
    @XmlElement
    private String NationalityLookUp;
    @XmlElement
    private String Sigle;
    @XmlElement
    private String EconomicStatusLookUp;
    @XmlElement
    private int PaymentIncident;
    @XmlElement
    private Long AnnualSalesValue;
    @XmlElement
    private String AnnualSalesCurrencyLookup;
    @XmlElement
    private String IdentificationNumbersRegistrationNumber;
    @XmlElement
    private String IdRegistrationNumberIssuerCountryLookUp;
    @XmlElement
    private String IdentificationNumbersTaxNumber;
    @XmlElement
    private String IdNumbersTaxNumberIssuerCountryLookUp;
    @XmlElement
    private String BCEAONumber;
    @XmlElement
    private String BCEAONumberIssuerCountry;
    @XmlElement
    private String POBox;
    @XmlElement
    private String Street;
    @XmlElement
    private String NumberOfBuilding;
    @XmlElement
    private String City;
    @XmlElement
    private String Region;
    @XmlElement
    private String District;
    @XmlElement
    private String Country;
    @XmlElement
    private String GPS;
    @XmlElement
    private String MainAddressLine;
    @XmlElement
    private long MobilePhone;
    @XmlElement
    private long FixedLine;
    @XmlElement
    private String Email;
    @XmlElement
    private String WebPage;
    @XmlElement
    private String Fax;
}
