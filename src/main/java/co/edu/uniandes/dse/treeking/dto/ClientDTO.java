package co.edu.uniandes.dse.treeking.dto;


import lombok.Data;

import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClientDTO extends UserDTO{
	private CalendarDTO calendar;
}

