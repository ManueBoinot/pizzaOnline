package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.TypeProduit;
import fr.eni.pizzaOnline.repository.TypeProduitRepository;

@Service
public class TypeProduitServiceImpl implements TypeProduitService {

	@Autowired
	TypeProduitRepository typeProduitRepository;

	@Override
	public TypeProduit creerTypeProduit(TypeProduit typeProduit) {
		return typeProduitRepository.save(typeProduit);
	}

	@Override
	public Optional<TypeProduit> getTypeProduitById(Long id) {
		return typeProduitRepository.findById(id);
	}

	@Override
	public List<TypeProduit> consulterTypeProduits() {
		return typeProduitRepository.findAll();
	}

	@Override
	public TypeProduit modifierTypeProduit(TypeProduit typeProduit, Long id) {
		TypeProduit tpDB = typeProduitRepository.findById(id).get();
		
		if (Objects.nonNull(typeProduit.getLibelle()) && !"".equalsIgnoreCase(typeProduit.getLibelle())) {
			tpDB.setLibelle(typeProduit.getLibelle());
		}
		return typeProduitRepository.save(tpDB);
	}

	@Override
	public void supprimerTypeProduit(Long id) {
		typeProduitRepository.deleteById(id);
	}

}
