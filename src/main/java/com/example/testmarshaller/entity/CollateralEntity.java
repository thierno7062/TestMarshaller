package com.example.testmarshaller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CollateralEntity {

    @Id
    private Integer Id;
    private Long ContractCode;

    private String CollateralCode;
    private String CollateralTypeLookUp;
    private String CollateralDescription;
    private int CollateralValue;
    private String collateralvaluecurrencylookup;
    private String ValuationDate;

    @OneToOne
    //@JoinColumn(name ="contract_code")
    private ContractEntity contract;

}
