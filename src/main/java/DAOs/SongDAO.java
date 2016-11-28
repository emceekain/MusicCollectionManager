package main.java.DAOs;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.exceptions.DAOException;
import main.java.models.Song;

public class SongDAO {
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * Default constructor, necessary for Hibernate
	 */
	public SongDAO(){}
	
	/**
     * @param song - the song to be updated
     *
     * @throws {@link DAOException} when song is null
     */
    public void update(Song song){
        if(null == song){
            throw new DAOException("Song update failed; song is null");
        }
        try {
        	Session session = sessionFactory.getCurrentSession();
        	session.update(song);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Song update failed.",hibernateException);
        }
    }
    
    public Long saveNewSong(Song song){
    	if(null == song){
            throw new DAOException("Song save failed; song is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	return (Long) session.save(song);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Song save failed.",hibernateException);
        }
    }
    
    public void deleteSong(Song song){
    	if(null == song){
            throw new DAOException("Song deletion failed; song is null");
        }
        
        try {
        	Session session = sessionFactory.getCurrentSession();
        	session.delete(song);
        } catch (HibernateException hibernateException) {
        	throw new DAOException("Song deletion failed.",hibernateException);
        }	
    }
    
    public List<Song> getAll() {
    	 try {
         	Session session = sessionFactory.getCurrentSession();
         	return session.createCriteria(Song.class).list();
         } catch (HibernateException hibernateException) {
         	throw new DAOException("Song deletion failed.",hibernateException);
         }
    	
    }
    
}

