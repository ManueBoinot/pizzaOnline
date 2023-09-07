package fr.eni.pizzaOnline.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.pizzaOnline.entity.TypeProduit;
import fr.eni.pizzaOnline.repository.TypeProduitRepository;

@Component
public class StringToTypeProduit implements Converter<String, TypeProduit> {

	@Autowired
	private TypeProduitRepository tpr;
	
	@Override
	public TypeProduit convert(String source) {
		long id = Long.parseLong(source);
		return tpr.findById(id).get(); 
	}
	
}