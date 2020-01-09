package com.codecool.curencyexchange.repositories;

import com.codecool.curencyexchange.models.ExchangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Long> {

}
