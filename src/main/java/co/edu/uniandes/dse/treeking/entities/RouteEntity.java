package co.edu.uniandes.dse.treeking.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
@Getter
@Setter
public class RouteEntity extends BaseEntity {
	// TODO: add attributes of route entity.
	@PodamExclude
	@ManyToOne
	private OutingEntity outing;
}