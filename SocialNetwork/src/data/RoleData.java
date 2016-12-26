package data;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import entities.Role;
import entities.UserRole;

public class RoleData {
	
private Session ss;
	
	public RoleData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}

	public ArrayList<Role> getAll() {
        
		Criteria crit = ss.createCriteria(Role.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<Role> roles = crit.list();
        
        return (ArrayList<Role>) roles;
    }
	
	public void insert(Role entity){
		
		ss.beginTransaction();
		ss.save(entity);
		ss.getTransaction().commit();
	}
	
	public void update(Role entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		Role entity = (Role) ss.load(Role.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
	public String getRoleForUser(int idUser){
		
		String roleTitle = "";
		
		UserRole userRole = (UserRole) ss.load(UserRole.class, idUser);
		Role role = (Role) ss.load(Role.class, userRole.idRole);
		
		if(role != null){
			roleTitle = role.getTitle();
		}
		
        return roleTitle;
	}
	
}
