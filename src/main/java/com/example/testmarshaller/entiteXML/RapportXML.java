package com.example.testmarshaller.entiteXML;

import com.example.testmarshaller.entiteXML.ContractXML.ContractListXML;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement(name = "Batch")
@XmlAccessorType(XmlAccessType.FIELD)
public class RapportXML {

    @XmlElement(name = "Contract")
    public List<ContractListXML> rapportXMLS;

}
