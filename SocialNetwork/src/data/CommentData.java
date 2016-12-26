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

import entities.Comment;

public class CommentData {

private Session ss;
	
	public CommentData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}
	
	public ArrayList<Comment> getAll() {
        
		Criteria crit = ss.createCriteria(Comment.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<Comment> comments = crit.list();
        
        return (ArrayList<Comment>) comments;
    }
	
	public void insert(Comment entity){
		
		ss.beginTransaction();
		ss.save(entity);
		ss.getTransaction().commit();
	}
	
	public void update(Comment entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		Comment entity = (Comment) ss.load(Comment.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
			
	public void deleteByIdPhoto(int idPhoto){
		
		ArrayList<Comment> comments = getCommentsByID(idPhoto);
		
		ss.beginTransaction();
						
		for(Comment entity : comments){
			ss.delete(entity);
		}
		
		ss.getTransaction().commit();
	}
	
	public ArrayList<Comment> getCommentsByID(int idPhoto) {
        
		Criteria crit = ss.createCriteria(Comment.class);
		Criterion idCrit = Restrictions.eq("idPhoto", idPhoto);
		crit.add(idCrit);

		@SuppressWarnings("unchecked")
		java.util.List<Comment> comments = crit.list();
        
        return (ArrayList<Comment>) comments;
    }
		
}
