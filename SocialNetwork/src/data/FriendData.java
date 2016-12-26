package data;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.Friend;

public class FriendData {
	
private Session ss;
	
	public FriendData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}

	public ArrayList<Friend> getAll() {
        
		Criteria crit = ss.createCriteria(Friend.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<Friend> friends = crit.list();
        
        return (ArrayList<Friend>) friends;
    }
	
	public void insert(Friend entity){
		
		ss.beginTransaction();
		ss.save(entity);
		ss.getTransaction().commit();
	}
	
	public void update(Friend entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		Friend entity = (Friend) ss.load(Friend.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
}
