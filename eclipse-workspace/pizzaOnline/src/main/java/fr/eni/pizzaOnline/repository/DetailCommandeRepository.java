package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.DetailCommande;

@Repository
public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long> {

}
