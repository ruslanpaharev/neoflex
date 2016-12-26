package data;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.Message;

public class MessageData {
	
private Session ss;
	
	public MessageData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}

	public ArrayList<Message> getAll() {
        
		Criteria crit = ss.createCriteria(Message.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<Message> messages = crit.list();
        
        return (ArrayList<Message>) messages;
    }
	
	public void insert(Message entity){
		
		ss.beginTransaction();
		ss.save(entity);
		ss.getTransaction().commit();
	}
	
	public void update(Message entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		Message entity = (Message) ss.load(Message.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
}
