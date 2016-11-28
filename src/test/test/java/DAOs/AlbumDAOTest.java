package test.java.DAOs;
import static org.mockito.Mockito.*;
import main.java.models.*;

import main.java.DAOs.AlbumDAO;

import main.java.exceptions.DAOException;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import main.java.models.Album;

public class AlbumDAOTest {

	private AlbumDAO albumDAO = new AlbumDAO();
	
	private SessionFactory sessionFactory;
	
	@Before
	public void setup(){
		sessionFactory = mock(SessionFactory.class);
	}
	
	@Test(expected = DAOException.class)
	public void testUpdate_NullAlbum(){
		albumDAO.update(null);
	}
	
	@Test
	public void testUpdate_HibernateException(){
		Session session = mock(Session.class);
		Album album = mock(Album.class);
		doThrow(new HibernateException("")).when(session).update(album);
		try{
			session.update(album);
			fail();
		} catch (DAOException daoException){
			assertEquals("Album save failed.",daoException.getMessage());
		}
	}
	
	/**
	 * Test for {@link AlbumDAO#update(Album)}. When a valid {@link Album} is passed, successfully updates the database. 
	 */
	@Test
	public void testUpdate(){
		assertEquals("3",returnValue);
	}
	//mock, when, do throuw
}
