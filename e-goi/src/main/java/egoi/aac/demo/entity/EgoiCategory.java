package egoi.aac.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Instantiates a Category Entity.
 * @author Antonio Carvalho
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "egoi_category")
public class EgoiCategory {
	
	/** The id. */
	@Id
	@Column(name="id", unique = false, nullable = false)
	public int id;
	
	/** The category id. */
	@Column(name="category_id")
	public int category_id;
	
	/** The name. */
	@Column(name="name")
	public String name;
	
	/** The created. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created")	
	public Date created;
	
	/** The modified. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified")
	public Date modified;
}
