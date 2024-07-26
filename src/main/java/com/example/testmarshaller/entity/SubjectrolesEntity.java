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
public class SubjectrolesEntity {

    @Id
    private Integer BTMID_SubjectRoles;
    //@Column(length = 250)
    private Long ContractCode;
    /*@OneToOne
    //@JoinColumn(name = "code", referencedColumnName = "id")
    private Contract contract;*/
    private String CustomerCode;
    private String RoleOfCustomer;



}
