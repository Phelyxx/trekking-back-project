package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class ReplyEntity extends  CommentEntity {
    @PodamExclude
    @ManyToOne
    private UserEntity user;

    @PodamExclude
    @ManyToOne
    private CommentEntity comment;
}
