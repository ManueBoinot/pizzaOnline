package fr.eni.pizzaOnline.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@SuppressWarnings("serial")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class DetailCommandeKey implements Serializable {

	private Long commandeId;
	private Long produitId;

	@Override
	public int hashCode() {
		return Objects.hash(commandeId, produitId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailCommandeKey other = (DetailCommandeKey) obj;
		return Objects.equals(commandeId, other.commandeId) && Objects.equals(produitId, other.produitId);
	}

}