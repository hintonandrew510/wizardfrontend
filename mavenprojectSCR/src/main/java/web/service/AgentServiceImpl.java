package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import web.model.Agent;
import web.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService{
	 @Autowired
	    private AgentRepository agentRepository;

	@Override
	public Iterable<Agent> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return agentRepository.findAll(sort);
	}

	@Override
	public Iterable<Agent> findByContactId(Integer contactId, Sort sort) {
		return agentRepository.findByContactId(contactId, sort);
	}
	
	public Agent save(Agent agent) {
		agent = agentRepository.save(agent);
		return agent;
		
	}

	@Override
	public Agent findByAddress(String address) {
		// TODO Auto-generated method stub
		return agentRepository.findByAddress(address);
	}

	@Override
	public Agent findByAddressAndPassword(String address, String password) {
		// TODO Auto-generated method stub
		return agentRepository.findByAddressAndPassword(address, password);
	}

}
