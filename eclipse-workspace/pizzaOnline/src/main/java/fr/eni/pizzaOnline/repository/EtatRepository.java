package fr.eni.pizzaOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.eni.pizzaOnline.entity.Etat;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Long> {

}
