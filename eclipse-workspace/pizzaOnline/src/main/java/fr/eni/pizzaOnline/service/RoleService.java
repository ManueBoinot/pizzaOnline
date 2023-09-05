package fr.eni.pizzaOnline.service;

import fr.eni.pizzaOnline.entity.Role;

public interface RoleService {

	Role creerRole(Role role);

	Role modifierRole(Role role, Long id);

	void supprimerRole(Long id);

}
