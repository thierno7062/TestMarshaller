package com.example.testmarshaller.entiteXML.CollateralXML;

import com.example.testmarshaller.entiteXML.ContractXML.ContractXML;
import jakarta.persistence.OneToOne;
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
public class CollateralXML {

    @XmlElement(name = "BTMID_Collateral")
    private Integer Id;

    @XmlElement(name = "Contractcode")
    private Long Contractcode;

    @XmlElement(name = "CollateralCode")
    private String CollateralCode;

    @XmlElement(name = "CollateralTypeLookUp")
    private String CollateralTypeLookUp;

    @XmlElement(name = "CollateralDescription")
    private String CollateralDescription;

    @XmlElement(name = "CollateralValue")
    private int CollateralValue;

    @XmlElement(name = "collateralvaluecurrencylookup")
    private String collateralvaluecurrencylookup;

    @XmlElement(name = "ValuationDate")
    private String ValuationDate;

    @OneToOne
    private ContractXML contractXML;
}
