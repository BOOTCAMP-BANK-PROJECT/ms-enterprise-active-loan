package com.bootcamp.enterprise.active.loan.service;

import com.bootcamp.enterprise.active.loan.entity.EnterpriseActiveLoan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnterpriseActiveLoanService {
	
    Flux<EnterpriseActiveLoan> findAll();
    Mono<EnterpriseActiveLoan> create(EnterpriseActiveLoan aloan);
    Mono<EnterpriseActiveLoan> findByClientId(String id);
    Mono<EnterpriseActiveLoan> update(EnterpriseActiveLoan aloan);
    Mono<Void> deleteById(String id);

}
