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
public class IndividuelEntity {

    @Id
    private Integer BTMID_Individual;
    private Long ContractCode;
    private String CustomerCode;
    private String PresentSurname;
    private String FirstName;
    private String FullName;
    private String MothersMaidenName;
    private int    NumberOfChildren;
    private int    NumberOfSpouses;
    private String ClassificationOfIndividualLookUp;
    private String GenderLookUp;
    private String DateOfBirth;

    //@ManyToOne
    //private Country CountryOfBirthLookUp;
    private String CountryOfBirthLookUp;

    private String PlaceOfBirth;
    private String MaritalStatusLookUp;
    private String SocialStatusLookUp;
    private String ResidencyLookUp;
    private String NationalityLookUp;
    private String EmploymentLookUp;
    private String EducationLookUp;
    private String BusinessName;
    private Double    IncomeAvailable;
    private Double    MonthlyExpenses;
    private String NegativeStatusOfIndividualLookUp;
    private Long    PhoneNumber;
    private String ProfessionalCategoryLookUp;
    private int PaymentIncident;
    private String   IdNumbersNationalID;
    private String IdNumbersNationalIDIssueDate;
    private String IdNumbersNationalIDExpirationDate;
    private String IdNumbersNationalIDIssuerCountryLookUp;
    private String PassportNumber;
    private String PassportIssueDate;
    private String PassportExpirationDate;
    private String PassportIssuerCountry;
    private String ResidencePermitNumber;
    private String ResidencePermitIssueDate;
    private String ResidencePermitExpirationDate;
    private String ResidencePermitIssuerCountry;
    private String DrivingLicenseNumber;
    private String DrivingLicenseIssueDate;
    private String DrivingLicenseExpirationDate;
    private String DrivingLicenseIssuerCountry;
    private String ConsularCard;
    private String ConsularCardIssueDate;
    private String ConsularCardExpirationDate;
    private String ConsularCardIssuerCountry;
    private String BIN;
    private String BINIssuerCountry;
    private String IDDocumentNumber;
    private String IDDocumentIssueDate;
    private String IDDocumentExpirationDate;
    private String IDDocumentIssuerCountry;
    private String IDDocumentIssueAuthority;
    private String MainAddressAddressLine;
    private String   ContactsMobilePhone;
    private String   FixedLine;
    private String Email;
    private String WebPage;
    private String Fax;
    private long   ContactsPhoneNumber;
    /*@OneToOne
    @JoinColumn(referencedColumnName = "BTMID_ContractData")
    private Contract contract;*/
}
