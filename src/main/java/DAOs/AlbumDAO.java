package main.java.DAOs;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.exceptions.DAOException;
import main.java.models.Album;

public class AlbumDAO {
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Default constructor, necessary for Hibernate
	 */
	public AlbumDAO(){}
	
	/**
     * @param album - the album to be updated
     *
     * @throws {@link DAOException} when album is null
     */
    public void update(Album album){
        if(null == album){
            throw new DAOException("Album update failed; album is null");
        }
        try {
        	Session session = sessionFactory.getCurrentSession();
        	session.update(album);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Album update failed.",hibernateException);
        }
    }
    
    public Long saveNewAlbum(Album album){
    	if(null == album){
            throw new DAOException("Album save failed; album is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	return (Long) session.save(album);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Album save failed.",hibernateException);
        }
    }
    
    public void deleteAlbum(Album album){
    	if(null == album){
            throw new DAOException("Album deletion failed; album is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	session.delete(album);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Album deletion failed.",hibernateException);
        }	
    }
    
    public List<Album> getAll() {
    	 try {
         	Session session = sessionFactory.getCurrentSession();
         	return session.createCriteria(Album.class).list();
         } catch (HibernateException hibernateException) {
         	throw new DAOException("Album deletion failed.",hibernateException);
         }
    	
    }
    
}

