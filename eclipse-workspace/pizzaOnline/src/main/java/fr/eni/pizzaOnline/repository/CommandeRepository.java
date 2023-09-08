package fr.eni.pizzaOnline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.entity.Etat;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	//@Query(value = "SELECT * FROM commande where etat_id = ?1", nativeQuery = true)
	//List<Commande> getCommandeByEtat(long etatId);
	Optional<List<Commande>> findByEtatIs(Etat etat);
	
}
