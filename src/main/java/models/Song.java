import java.util.ArrayList;

public class Song {
	private Long id;
	private String title;
	private short track;
	private short length;
	
	/**
	 * Default constructor, necessary for Hibernate
	 */
	public Song() {}
	
	public Song(String title, short track, short length) {
		this.title = title;
		this.track = track;
		this.length = length;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getTrack() {
		return track;
	}

	public void setTrack(short track) {
		this.track = track;
	}

	public short getLength() {
		return length;
	}

	public void setLength(short length) {
		this.length = length;
	}

	public Long getId() {
		return this.id;
	}
	
}
