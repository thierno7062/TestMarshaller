package com.example.testmarshaller.entiteXML.ContractXML;

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
public class ContractListXML {

    @XmlElement(name = "ContractCode")
    ContractCodeXML contractCode;

    @XmlElement(name = "ContractData")
    ContractXML contractXMLS;

 /*    @XmlElement(name = "Collateral")
    CollateralXML collateralXMLS; */

  /*   @XmlElement(name = "Company")
    CompanyXML companyXMLS;

    @XmlElement(name = "Individual")
    IndividualXML individualXMLS;

    @XmlElement(name = "Subjectroles")
    SubjectrolesXML subjectrolesXMLS; */
}
