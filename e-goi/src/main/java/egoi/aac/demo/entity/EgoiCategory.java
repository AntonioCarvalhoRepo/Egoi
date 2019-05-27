package egoi.aac.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class EgoiCategory {
	@Id
	@Column(name="id", unique = false, nullable = false)
	public int id;
	
	@Column(name="category_id")
	public int category_id;
	
	@Column(name="name")
	public String name;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created")	
	public Date created;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified")
	public Date modified;
	
	public EgoiCategory(int id ,int category_id, String name) {
		this.id=id;
		this.name= name;
		this.category_id = category_id;
	}
}
