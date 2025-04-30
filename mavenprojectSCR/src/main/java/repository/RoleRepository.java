package web.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import web.model.Role;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface RoleRepository extends CrudRepository<Role, Integer> {

	Iterable<Role> findAll(Sort sort);

	Role findByRole(String role);

}
