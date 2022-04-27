package com.bootcamp.enterprise.active.loan.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.bootcamp.enterprise.active.loan.entity.EnterpriseActiveLoan;

public interface EnterpriseActiveLoanRepository extends ReactiveCrudRepository<EnterpriseActiveLoan, String> {

}
