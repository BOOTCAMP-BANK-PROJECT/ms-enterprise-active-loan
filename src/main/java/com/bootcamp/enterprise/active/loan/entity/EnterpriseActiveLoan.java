package com.bootcamp.enterprise.active.loan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class EnterpriseActiveLoan {
	
	@Id
	private String id;
    private Enterprise documentRUC;
    private String creditDate;
    private String loanAmount;
    private String loanTermInMonths;
    private String annualInterestRate;

}