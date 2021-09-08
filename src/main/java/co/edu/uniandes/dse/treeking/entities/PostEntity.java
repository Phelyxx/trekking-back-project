package co.edu.uniandes.dse.treeking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class PostEntity extends BaseEntity {
	
	private Integer ratings;
	
	@PodamExclude
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<MultimediaEntity> multimedias;
	

	@PodamExclude
	@ManyToOne
	private BlogEntity blog;


	@PodamExclude
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;
	
	@PodamExclude
	@ManyToOne
	private UserEntity user;
}
