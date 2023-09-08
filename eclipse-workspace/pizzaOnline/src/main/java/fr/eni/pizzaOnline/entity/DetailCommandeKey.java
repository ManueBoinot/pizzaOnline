package fr.eni.pizzaOnline.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class DetailCommandeKey implements Serializable {
	
	private Long commandeId;
	private Long produitId;

}
