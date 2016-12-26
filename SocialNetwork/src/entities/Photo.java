package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Photos")
public class Photo implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int id;
	
	public String title;
	public java.sql.Blob previewImage;
	public Date creationDate;
		
	public Photo() { 
		
	}
	
}
