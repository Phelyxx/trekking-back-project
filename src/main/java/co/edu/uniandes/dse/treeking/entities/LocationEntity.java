package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Setter
@Getter
@Entity
public class LocationEntity extends BaseEntity {
	
	private Integer idLocation;
	private Float latitude;
	private Float longitude;

	@PodamExclude
	@ManyToOne
	private RouteEntity map;
}
