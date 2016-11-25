package test.java.DAOs;

import main.java.DAOs.AlbumDAO;

import main.java.exceptions.DAOException;

import org.junit.Before;
import org.junit.Test;
import main.java.models.Album;


public class AlbumDAOTest {

	private AlbumDAO albumDAO = new AlbumDAO();
	
	@Before
	public void setup(){
		
	}
	
	@Test(expected = DAOException.class)
	public void testUpdate_NullAlbum_DAOException(){
		albumDAO.update(null);
	}
}
