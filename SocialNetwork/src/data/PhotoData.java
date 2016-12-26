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

import entities.Photo;
import entities.FullPhoto;
import entities.AlbumPhoto;
import entities.AlbumUser;

public class PhotoData {

private Session ss;
	
	public PhotoData(){
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		ss = sf.openSession();
	}
	
	public ArrayList<Photo> getAll() {
        
		Criteria crit = ss.createCriteria(Photo.class);
		
		@SuppressWarnings("unchecked")
		java.util.List<Photo> photos = crit.list();
        
        return (ArrayList<Photo>) photos;
    }
	
	public int insert(Photo entity){
		
		ss.beginTransaction();
		int id = (int) ss.save(entity);
		ss.getTransaction().commit();
		
		return id;
	}
	
	public void update(Photo entity){
		
		ss.beginTransaction();
		ss.update(entity);
		ss.getTransaction().commit();
	}
	
	public void delete(int id){
		
		Photo entity = (Photo) ss.load(Photo.class, id);
		
		if(entity != null){
			ss.beginTransaction();
			ss.delete(entity);
			ss.getTransaction().commit();
		}
	}
	
	public java.sql.Blob getFullImageByte(int idPhoto){
		
		FullPhoto fullPhoto = (FullPhoto) ss.load(FullPhoto.class, idPhoto);
		
		return fullPhoto.image;
	}
	
	public void insertFullPhoto(int idPhoto, java.sql.Blob image){
		
		FullPhoto fullPhoto = new FullPhoto();
		fullPhoto.idPhoto = idPhoto;
		fullPhoto.image = image;
		
		ss.beginTransaction();
		ss.save(fullPhoto);
		ss.getTransaction().commit();
	}
	
	public void deleteFullPhoto(int idPhoto){
		
		FullPhoto fullPhoto = (FullPhoto) ss.load(FullPhoto.class, idPhoto);
		
		if(fullPhoto != null){
			ss.beginTransaction();
			ss.delete(fullPhoto);
			ss.getTransaction().commit();
		}
	}
	
	public void attachPhotoToAlbum(int idPhoto, int idAlbum){
		
		AlbumPhoto albumPhoto = new AlbumPhoto();
		albumPhoto.idPhoto = idPhoto;
		albumPhoto.idAlbum = idAlbum;
		
		ss.beginTransaction();
		ss.save(albumPhoto);
		ss.getTransaction().commit();
	}
	
	public void deletePhotoToAlbum(int idPhoto, int idAlbum){
		
		AlbumPhoto albumPhoto = new AlbumPhoto();
		albumPhoto.idPhoto = idPhoto;
		albumPhoto.idAlbum = idAlbum;
		
		ss.beginTransaction();
		ss.delete(albumPhoto);
		ss.getTransaction().commit();
	}
	
	public ArrayList<Photo> getPhotosByIdAlbums(int idAlbum){

		ArrayList<Photo> photos = new ArrayList<>();
        
		Criteria crit = ss.createCriteria(AlbumPhoto.class);
		Criterion idCrit = Restrictions.eq("idAlbum", idAlbum);
		crit.add(idCrit);

		@SuppressWarnings("unchecked")
		java.util.List<AlbumPhoto> albumPhotos = crit.list();
		
		for(AlbumPhoto entity : albumPhotos){
			Photo photo = (Photo) ss.load(Photo.class, entity.idPhoto);
			photos.add(photo);
		}
        
        return photos;	
	}
	
	public ArrayList<Photo> getPhotosByIdUser(int idUser){
		
		ArrayList<Photo> photos = new ArrayList<>();
        
		Criteria crit = ss.createCriteria(AlbumUser.class);
		Criterion idCrit = Restrictions.eq("idUser", idUser);
		crit.add(idCrit);

		@SuppressWarnings("unchecked")
		java.util.List<AlbumUser> albumUsers = crit.list();
		
		for(AlbumUser item : albumUsers){	
			crit = ss.createCriteria(AlbumPhoto.class);
			idCrit = Restrictions.eq("idAlbum", item.idAlbum);
			crit.add(idCrit);

			@SuppressWarnings("unchecked")
			java.util.List<AlbumPhoto> albumPhotos = crit.list();
		
			for(AlbumPhoto entity : albumPhotos){
				Photo photo = (Photo) ss.load(Photo.class, entity.idPhoto);
				photos.add(photo);
			}
		}
		
        return photos;
	}
	
}
