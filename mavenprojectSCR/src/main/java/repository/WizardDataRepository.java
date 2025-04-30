package web.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import web.model.Contact;
import web.model.WebClient;
import web.model.WizardData;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface WizardDataRepository extends CrudRepository<WizardData, Integer> {

	Iterable<WizardData> findAll(Sort sort);

	public WizardData findByPagesequenceAndWizardid(@Param("pagesequence") Integer pagesequence,
			@Param("wizardid") Integer wizardid);

	public Iterable<WizardData> findByWizardid(@Param("wizardid") Integer wizardid);

}
