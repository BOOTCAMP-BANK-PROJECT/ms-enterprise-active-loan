package com.bootcamp.enterprise.active.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.enterprise.active.loan.entity.EnterpriseActiveLoan;
import com.bootcamp.enterprise.active.loan.repository.EnterpriseActiveLoanRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EnterpriseActiveLoanServiceImpl implements EnterpriseActiveLoanService {
	
	@Autowired
    public final EnterpriseActiveLoanRepository repo;

	@Override
	public Flux<EnterpriseActiveLoan> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<EnterpriseActiveLoan> create(EnterpriseActiveLoan aloan) {
		return repo.save(aloan);
	}

	@Override
	public Mono<EnterpriseActiveLoan> findByClientId(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<EnterpriseActiveLoan> update(EnterpriseActiveLoan aloan) {
		return repo.save(aloan);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repo.deleteById(id);
	}

}
