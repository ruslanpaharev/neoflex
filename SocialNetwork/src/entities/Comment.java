package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Comments")
public class Comment implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int id;
	
	public int idPhoto;
	public int idUser;
	public String title;
	public Date creationDate;
	public int isNew;
	
	public Comment()    {   
		
	}
	
}
