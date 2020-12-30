package com.akshay.rest.webservices.currency.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.rest.webservices.currency.exchange.entity.CurrencyExchangeValue;
import com.akshay.rest.webservices.currency.exchange.repository.CurrencyExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeValue retrieveCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchangeValue currencyExchangeValue = repository.findByFromAndTo(from, to);
		currencyExchangeValue.setPort(Integer.parseInt(environment.getProperty("server.port")));
		return currencyExchangeValue;
	}
}
