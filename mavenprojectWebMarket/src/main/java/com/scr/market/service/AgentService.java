package com.scr.market.service;

import com.scr.market.model.Agent;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;



public interface AgentService {
	Iterable<Agent> findAll(Sort sort);

	Iterable<Agent> findByContactId(Integer contactId, Sort sort);

	Agent findByAddress(String address);

	public Agent findByAddressAndPassword(@Param("address") String address, @Param("password") String password);


}
