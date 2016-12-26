package data;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.UserProfile;

public class UserProfileData {
	
	private Session ss;
	
	public UserProfileData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}

	public ArrayList<UserProfile> getAll() {
        
		Criteria crit = ss.createCriteria(UserProfile.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<UserProfile> profiles = crit.list();
        
        return (ArrayList<UserProfile>) profiles;
    }
	
	public void insert(UserProfile entity){
		
		ss.beginTransaction();
		ss.save(entity);
		ss.getTransaction().commit();
	}
	
	public void update(UserProfile entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		UserProfile entity = (UserProfile) ss.load(UserProfile.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
	public ArrayList<UserProfile> getUserProfileBySearchString(String text){
		
		ArrayList<UserProfile> profilesAll = getAll();
		ArrayList<UserProfile> profiles = new ArrayList<>();
		
		for(UserProfile entity : profilesAll){
			if(entity.getName().toLowerCase().contains(text.toLowerCase())
				|| entity.getSurname().toLowerCase().contains(text.toLowerCase())
				|| entity.status.toLowerCase().contains(text.toLowerCase())
				|| entity.contacts.toLowerCase().contains(text.toLowerCase()) ){
				profiles.add(entity);
			}
		}
		
        return profiles;
    }
	
}
