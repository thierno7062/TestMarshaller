package com.example.testmarshaller.entiteXML.ContractXML;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

// @AllArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractCodeXML {

    @XmlElement
    private Long ContractCode;


}
