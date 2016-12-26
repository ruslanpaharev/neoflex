package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="FullPhotos")
public class FullPhoto implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	public int idPhoto;
	public java.sql.Blob image;
	
	public FullPhoto(){
		
	}
	
}
