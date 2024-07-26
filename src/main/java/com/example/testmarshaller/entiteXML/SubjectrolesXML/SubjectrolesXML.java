package com.example.testmarshaller.entiteXML.SubjectrolesXML;

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
public class SubjectrolesXML {

    @XmlElement(name = "BTMID_SubjectRoles")
    private Integer btmdId;
    @XmlElement(name = "contractCode")
    private Long contractCode;
    @XmlElement(name = "customerCode")
    private String customerCode;
    @XmlElement(name = "roleOfCustomer")
    private String roleOfCustomer;
}
