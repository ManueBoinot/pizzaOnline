package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.Role;

public interface RoleService {

	Role creerRole(Role role);

	List<Role> consulterRoles();

	Optional<Role> getRoleById(Long id);

	Role modifierRole(Role role, Long id);

	void supprimerRole(Long id);

}
