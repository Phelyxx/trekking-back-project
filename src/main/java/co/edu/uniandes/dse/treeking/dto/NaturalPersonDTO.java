package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class NaturalPersonDTO extends ClientDTO{
	private PersonDTO person;
}
