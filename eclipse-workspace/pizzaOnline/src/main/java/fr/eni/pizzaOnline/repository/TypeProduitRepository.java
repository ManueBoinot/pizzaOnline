package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.TypeProduit;

@Repository
public interface TypeProduitRepository extends JpaRepository<TypeProduit, Long> {
	
}
