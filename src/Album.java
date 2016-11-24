import java.util.ArrayList;

public class Album {
	private String title;
	private Artist artist;
	private int year;
	private ArrayList<String> genres;
	//private ImageIcon coverArt;
	
	public Album(){
		this.title = " ";
		this.artist = null;
		this.year = 0;	
		this.genres = null;
	}
	
	public Album(String title, Artist artist, int year,ArrayList<String> genres){
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.genres = genres;
	}

	public String getTitle(){
		return this.title;
	}
	
	public Artist getArtist(){
		return this.artist;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public ArrayList<String> getGenres(){
		return this.genres;
	}
	
	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	
	public void setArtist(Artist newArtist){
		this.artist = newArtist;
	}
	
	public void setYear(int newYear){
		this.year = newYear;
	}
	
	public void addGenre(String newGenre){
		this.genres.add(newGenre);
	}
	
	public void removeGenre(String oldGenre){
		this.genres.remove(oldGenre);
	}
	
	public void clearGenres(){
		this.genres = null;
	}
}
