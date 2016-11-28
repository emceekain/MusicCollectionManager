package main.java.DAOs;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.exceptions.DAOException;
import main.java.models.Artist;

public class ArtistDAO {
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Default constructor, necessary for Hibernate
	 */
	public ArtistDAO(){}
	
	/**
     * @param artist- the artist to be updated
     *
     * @throws {@link DAOException} when artist is null
     */
    public void update(Artist artist){
        if(null == artist){
            throw new DAOException("Artist update failed; artist is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	session.update(artist);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Artist update failed.",hibernateException);
        }
    }
    
    public Long saveNewArist(Artist artist){
    	if(null == artist){
            throw new DAOException("Artist save failed; artist is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	return (Long) session.save(artist);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Artist save failed.",hibernateException);
        }
    }
    
    public void deleteArtist(Artist artist){
    	if(null == artist){
            throw new DAOException("Artist deletion failed; artist is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	session.delete(artist);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Arist deletion failed.",hibernateException);
        }	
    }
    
    public List<Artist> getAll() {
    	 try {
         	Session session = sessionFactory.getCurrentSession();
         	return session.createCriteria(Artist.class).list();
         } catch (HibernateException hibernateException) {
         	throw new DAOException("Artist deletion failed.",hibernateException);
         }
    	
    }
    
    

}
