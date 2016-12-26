package entities;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import support.MySecurity;

@Entity(name="Users")
public class User implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public int id;
	
	private String login;
	
	public String getLogin(){
		return login;
	}
	
	public boolean isValid(String text, int minLength){
		
		String paternStr = "^[a-zA-Z0-9]+$";
		Pattern patern = Pattern.compile(paternStr);
		Matcher matcher = patern.matcher(text);
				
		return (text.length() >= minLength && matcher.matches()); 
	}
	
	public void setLogin(String login){
		
		if(isValid(login, 3)){
			this.login = login;
		}
	}
	
	private String password;
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		
		if(isValid(password, 3)){
			this.password = MySecurity.getHashCodeDigest(password);
		}
	}
	
	public User() { 
		
	}

}
