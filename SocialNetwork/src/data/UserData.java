package data;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.User;
import entities.UserRole;
import entities.AlbumPhoto;
import entities.AlbumUser;

public class UserData {
	
	private Session ss;
	
	public UserData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}

	public ArrayList<User> getAll() {
        
		Criteria crit = ss.createCriteria(User.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<User> users = crit.list();
        
        return (ArrayList<User>) users;
    }
	
	public int insert(User entity){
		
		ss.beginTransaction();
		int id = (int) ss.save(entity);
		ss.getTransaction().commit();
		
		return id;
	}
	
	public void update(User entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();	
	}
	
	public void delete(int id){
		
		User entity = (User) ss.load(User.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
	public void attachUserToRole(int idUser, int idRole){
		
		UserRole userRole = new UserRole();
		userRole.idUser = idUser;
		userRole.idRole = idRole;
		
		ss.beginTransaction();
		ss.save(userRole);
		ss.getTransaction().commit();
	}
	
	public void updateUserRole(int idUser, int idRole){
		
		UserRole userRole = new UserRole();
		userRole.idUser = idUser;
		userRole.idRole = idRole;
		
		ss.beginTransaction();
		ss.update(userRole);
		ss.getTransaction().commit();
	}
	
	public void deleteUserToRole(int idUser, int idRole){
		
		UserRole userRole = new UserRole();
		userRole.idUser = idUser;
		userRole.idRole = idRole;
		
		ss.beginTransaction();
		ss.delete(userRole);
		ss.getTransaction().commit();
	}
	
	public void deleteUserRole(int idUser){
		
		UserRole userRole = (UserRole) ss.load(UserRole.class, idUser);
				
		ss.beginTransaction();
		ss.delete(userRole);
		ss.getTransaction().commit();
	}
		
	public int getUserIDByPhotoID(int idPhoto){
		
		AlbumPhoto albumPhoto = (AlbumPhoto) ss.load(AlbumPhoto.class, idPhoto);
		AlbumUser albumUser = (AlbumUser) ss.load(AlbumUser.class, albumPhoto.idAlbum);
		
		int id = 0;
		
		if(albumUser != null){
			id = albumUser.idUser;
		}
		
		return id;
	}
	
	public int getIdByLogin(String userName){

		Criteria crit = ss.createCriteria(User.class);
		Criterion idCrit = Restrictions.eq("login", userName);
		crit.add(idCrit);
		
		int id = 0;
		User user = (User) crit.uniqueResult();
		
		if(user != null){
			id = user.id;
		}
		
		return id;
	}
	
}
