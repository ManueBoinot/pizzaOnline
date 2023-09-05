package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
