package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
