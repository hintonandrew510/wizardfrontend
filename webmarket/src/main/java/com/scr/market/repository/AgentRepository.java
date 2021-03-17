package com.scr.market.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.scr.market.model.Agent;



public interface AgentRepository extends CrudRepository<Agent, Integer> {
	Iterable<Agent> findAll(Sort sort);
	Iterable<Agent> findByContactId(Integer contactId,Sort sort);
	Agent findByAddress(String address);

}
