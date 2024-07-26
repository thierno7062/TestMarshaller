package com.example.testmarshaller.entiteXML.IndividualXML;

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

public class IndividualXML {

    @XmlElement
    private Integer BTMID_Individual;
    @XmlElement
    private Long ContractCode;
    @XmlElement
    private String CustomerCode;
    @XmlElement
    private String PresentSurname;
    @XmlElement
    private String FirstName;
    @XmlElement
    private String FullName;
    @XmlElement
    private String MothersMaidenName;
    @XmlElement
    private int  NumberOfChildren;
    @XmlElement
    private int  NumberOfSpouses;
    @XmlElement
    private String ClassificationOfIndividualLookUp;
    @XmlElement
    private String GenderLookUp;
    //@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlElement
    private String DateOfBirth;
    @XmlElement
    private String CountryOfBirthLookUp;
    @XmlElement
    private String PlaceOfBirth;
    @XmlElement
    private String MaritalStatusLookUp;
    @XmlElement
    private String SocialStatusLookUp;
    @XmlElement
    private String ResidencyLookUp;
    @XmlElement
    private String NationalityLookUp;
    @XmlElement
    private String EmploymentLookUp;
    @XmlElement
    private String EducationLookUp;
    @XmlElement
    private String BusinessName;
    @XmlElement
    private Double IncomeAvailable;
    @XmlElement
    private Double MonthlyExpenses;
    @XmlElement
    private String NegativeStatusOfIndividualLookUp;
    @XmlElement
    private Long PhoneNumber;
    @XmlElement
    private String ProfessionalCategoryLookUp;
    @XmlElement
    private int PaymentIncident;
    @XmlElement
    private String IdNumbersNationalID;
    @XmlElement
    private String IdNumbersNationalIDIssueDate;
    @XmlElement
    private String IdNumbersNationalIDExpirationDate;
    @XmlElement
    private String IdNumbersNationalIDIssuerCountryLookUp;
    @XmlElement
    private String PassportNumber;
    @XmlElement
    private String PassportIssueDate;
    @XmlElement
    private String PassportExpirationDate;
    @XmlElement
    private String PassportIssuerCountry;
    @XmlElement
    private String ResidencePermitNumber;
    @XmlElement
    private String ResidencePermitIssueDate;
    @XmlElement
    private String ResidencePermitExpirationDate;
    @XmlElement
    private String ResidencePermitIssuerCountry;
    @XmlElement
    private String DrivingLicenseNumber;
    @XmlElement
    private String DrivingLicenseIssueDate;
    @XmlElement
    private String DrivingLicenseExpirationDate;
    @XmlElement
    private String DrivingLicenseIssuerCountry;
    @XmlElement
    private String ConsularCard;
    @XmlElement
    private String ConsularCardIssueDate;
    @XmlElement
    private String ConsularCardExpirationDate;
    @XmlElement
    private String ConsularCardIssuerCountry;
    @XmlElement
    private String BIN;
    @XmlElement
    private String BINIssuerCountry;
    @XmlElement
    private String IDDocumentNumber;
    @XmlElement
    private String IDDocumentIssueDate;
    @XmlElement
    private String IDDocumentExpirationDate;
    @XmlElement
    private String IDDocumentIssuerCountry;
    @XmlElement
    private String IDDocumentIssueAuthority;
    @XmlElement
    private String MainAddressAddressLine;
    @XmlElement
    private String ContactsMobilePhone;
    @XmlElement
    private String FixedLine;
    @XmlElement
    private String Email;
    @XmlElement
    private String WebPage;
    @XmlElement
    private String Fax;
    @XmlElement
    private long ContactsPhoneNumber;
}
