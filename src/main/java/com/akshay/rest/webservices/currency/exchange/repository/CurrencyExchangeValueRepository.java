package com.akshay.rest.webservices.currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.rest.webservices.currency.exchange.entity.CurrencyExchangeValue;

@Repository
public interface CurrencyExchangeValueRepository extends JpaRepository<CurrencyExchangeValue, Integer> {

	CurrencyExchangeValue findByFromAndTo(String from, String to);
}
