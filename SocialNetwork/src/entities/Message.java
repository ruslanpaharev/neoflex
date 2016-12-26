package entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="Messages")
public class Message implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int id;
	
	public int idUser;
	public int idFriend;
	public String text;
	public Date creationDate;
	public int isNew;
	
	public Message() { 
		
	}
	
}
