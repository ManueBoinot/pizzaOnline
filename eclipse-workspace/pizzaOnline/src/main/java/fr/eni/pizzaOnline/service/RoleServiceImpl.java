package fr.eni.pizzaOnline.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Role;
import fr.eni.pizzaOnline.repository.RoleRepository;
import jakarta.inject.Singleton;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Singleton
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
		creerRole(new Role("Serveur"));
		creerRole(new Role("Pizzaïolo"));
		creerRole(new Role("Gérant"));
	}

	@Override
	public Role creerRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role modifierRole(Role role, Long id) {
		Role roleDB = roleRepository.findById(id).get();

		if (Objects.nonNull(role.getLibelle()) && !"".equalsIgnoreCase(role.getLibelle())) {
			roleDB.setLibelle(role.getLibelle());
		}

		return roleRepository.save(roleDB);
	}

	@Override
	public void supprimerRole(Long id) {
		roleRepository.deleteById(id);
	}

}
