package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
