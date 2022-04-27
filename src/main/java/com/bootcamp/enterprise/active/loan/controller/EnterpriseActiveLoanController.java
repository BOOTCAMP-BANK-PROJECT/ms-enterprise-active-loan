package com.bootcamp.enterprise.active.loan.controller;

import com.bootcamp.enterprise.active.loan.entity.EnterpriseActiveLoan;
import com.bootcamp.enterprise.active.loan.service.EnterpriseActiveLoanServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/enterprise/active/loan")
@Tag(name = "Enterprise Active Loan Information", description = "Manage entreprise active loans.")
@CrossOrigin( value = { "*" })
@RequiredArgsConstructor
public class EnterpriseActiveLoanController {
	
	/*@Autowired
	private CircuitBreakerFactory cbFactory;*/

	@Autowired
    public final EnterpriseActiveLoanServiceImpl service;

    @GetMapping
    public Flux<EnterpriseActiveLoan> getAll() {
        return service.findAll();
    }
    
    //@CircuitBreaker(name="enterpriseactiveloan", fallbackMethod = "getAllFallBack")
    //@TimeLimiter(name="enterpriseactiveloan")
    @GetMapping("/find/{id}")
    public Mono<EnterpriseActiveLoan> findById(@PathVariable String id){
    	return service.findByClientId(id);
    }
    
    /*public Flux<EnterpriseActiveLoan> getAllFallBack() {
        return service.findAll();
    }*/
    
    /*public CompletableFuture<Mono<EnterpriseActiveLoan>> findById(@PathVariable String id) throws InterruptedException{
    	if(id.equals(10L)) {
    		throw new IllegalStateException("Listado no es posible de ver.");
    	}
    	if(id.equals(7L)) {
    		TimeUnit.SECONDS.sleep(5L);
    	}
    	return CompletableFuture.supplyAsync(()-> service.findByClientId(id));
    }*/

    @PostMapping
    public Mono<EnterpriseActiveLoan> create(@RequestBody EnterpriseActiveLoan e) {
        return service.create(e);
    }

    @PutMapping("/update/{id}")
    public Mono<EnterpriseActiveLoan> update(@RequestBody EnterpriseActiveLoan e, @PathVariable String id) {
        return service.update(e);
    }
    
    @DeleteMapping("/byId/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.deleteById(id);
    }

}