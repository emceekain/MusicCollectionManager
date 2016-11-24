import java.util.ArrayList;

public class Artist {
	public String name;
	public ArrayList<Album> albums;
	
	public Artist(){
		this.name = " ";
		this.albums = null;
	}
	
	public Artist(String name,ArrayList<Album> albums){
		this.name = name;
		this.albums = albums;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ArrayList<Album> getAlbums(){
		return this.albums;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	public void addAlbum(Album newAlbum){
		this.albums.add(newAlbum);
	}
}

