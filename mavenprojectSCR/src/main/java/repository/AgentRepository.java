package web.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import web.model.Agent;
import web.model.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Repository
public interface AgentRepository extends CrudRepository<Agent, Integer> {
	
	Iterable<Agent> findAll(Sort sort);

	Iterable<Agent> findByContactId(Integer contactId, Sort sort);

	Agent findByAddress(String address);

	Agent findByAddressAndPassword(@Param("address") String address, @Param("password") String password);
	Agent save(Agent agent);

}
