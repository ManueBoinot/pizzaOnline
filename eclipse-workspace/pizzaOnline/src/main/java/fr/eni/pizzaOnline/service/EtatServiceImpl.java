package fr.eni.pizzaOnline.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Etat;
import fr.eni.pizzaOnline.repository.EtatRepository;

@Service
public class EtatServiceImpl implements EtatService {

	@Autowired
	EtatRepository etatRepository;

	@Override
	public Etat creerEtat(Etat etat) {
		return etatRepository.save(etat);
	}

	@Override
	public Etat modifierEtat(Etat etat, Long id) {
		Etat etatDB = etatRepository.findById(id).get();
		if (Objects.nonNull(etat.getLibelle()) && !"".equalsIgnoreCase(etat.getLibelle())) {
			etatDB.setLibelle(etat.getLibelle());
		}
		return etatRepository.save(etatDB);
	}

	@Override
	public void supprimerEtat(Long id) {
		etatRepository.deleteById(id);
	}

}
