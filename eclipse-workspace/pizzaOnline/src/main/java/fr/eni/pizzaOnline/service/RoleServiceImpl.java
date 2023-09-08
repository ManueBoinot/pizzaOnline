package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Role;
import fr.eni.pizzaOnline.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
//		creerRole(new Role("LIVREUR"));
//		creerRole(new Role("PIZZAIOLO"));
//		creerRole(new Role("GERANT"));
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
	public List<Role> consulterRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> getRoleById(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public void supprimerRole(Long id) {
		roleRepository.deleteById(id);
	}

}