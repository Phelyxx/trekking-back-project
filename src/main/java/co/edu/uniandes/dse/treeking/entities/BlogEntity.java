package co.edu.uniandes.dse.treeking.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
public class BlogEntity extends BaseEntity{
    @OneToMany
    private List<PostEntity> post;
}
