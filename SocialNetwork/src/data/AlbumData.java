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

import entities.Album;
import entities.AlbumUser;

public class AlbumData {
	
private Session ss;
	
	public AlbumData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}

	public ArrayList<Album> getAll() {
        
		Criteria crit = ss.createCriteria(Album.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<Album> albums = crit.list();
        
        return (ArrayList<Album>) albums;
    }
	
	public int insert(Album entity){
		
		ss.beginTransaction();
		int id = (int) ss.save(entity);
		ss.getTransaction().commit();
		
		return id;
	}
	
	public void update(Album entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		Album entity = (Album) ss.load(Album.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
	public void attachAlbumToUser(int idAlbum, int idUser){
		
		AlbumUser albumUser = new AlbumUser();
		albumUser.idAlbum = idAlbum;
		albumUser.idUser = idUser;
		
		ss.beginTransaction();
		ss.save(albumUser);
		ss.getTransaction().commit();
	}
	
	public void deleteAlbumToUser(int idAlbum, int idUser){
		
		AlbumUser albumUser = new AlbumUser();
		albumUser.idAlbum = idAlbum;
		albumUser.idUser = idUser;
		
		ss.beginTransaction();
		ss.delete(albumUser);
		ss.getTransaction().commit();
	}
	
	public ArrayList<Album> getAlbumsByIdUser(int idUser){

		ArrayList<Album> albums = new ArrayList<>();
        
		Criteria crit = ss.createCriteria(AlbumUser.class);
		Criterion idCrit = Restrictions.eq("idUser", idUser);
		crit.add(idCrit);

		@SuppressWarnings("unchecked")
		java.util.List<AlbumUser> albumUserList = crit.list();
		
		for(AlbumUser entity : albumUserList){			
			Album album = (Album) ss.load(Album.class, entity.idAlbum);
			albums.add(album);
		}
		        
        return albums;
	}
	
}
