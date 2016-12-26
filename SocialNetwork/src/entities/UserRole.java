package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="UserRole")
public class UserRole implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	public int idUser;
	public int idRole;
	
	public UserRole(){
		
	}
	
}
