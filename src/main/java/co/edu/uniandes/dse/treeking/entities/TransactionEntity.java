package co.edu.uniandes.dse.treeking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.uniandes.dse.treeking.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

@Getter
@Setter
@Entity
public class TransactionEntity extends BaseEntity {

	private PaymentType payment;
	private Integer value;
	private String userType;
	private String userID;
	private String username;

	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@PodamExclude
	@ManyToOne
	private NaturalPersonEntity client;

	@PodamExclude
	@ManyToOne
	private EnterpriseEntity enterprise;
}
