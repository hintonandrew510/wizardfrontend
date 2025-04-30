package web.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import web.model.Agent;


public interface AgentService {
	Iterable<Agent> findAll(Sort sort);

	Iterable<Agent> findByContactId(Integer contactId, Sort sort);

	Agent findByAddress(String address);

	public Agent findByAddressAndPassword(@Param("address") String address, @Param("password") String password);


}
