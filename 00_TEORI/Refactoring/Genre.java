package assignment;

public enum Genre {
	UNDEFINED, POP, ROCK, HIPHOP, RNB, JAZZ, INSTRUMENTALS, CLOWNCORE;
}

class Album {
	private String name;
	private String coverURL;

	public Album(String name, String coverURL) {
		this.name = name;
		this.coverURL = coverURL;
	}

	public String getName() {
		return name;
	}
}

class Artist {
	private String name;
	private String alias;
	private String imageURL;

	public Artist(String name, String alias, String imageURL) {
		this.name = name;
		this.alias = alias;
		this.imageURL = imageURL;
	}

	public String getName() {
		return name;
	}

	public String getAlias() {
		return alias;
	}
}

enum DetailLevel {
	SONG_ONLY, SONG_AND_ARTIST, SONG_AND_ALBUM, FULL_DETAILS;
}

public class Song {
	private String id;
	private String title;
	private String releaseYear;
	private String musicFileURL;
	private Genre genre = Genre.UNDEFINED;
	private Album album;
	private Artist artist;

	public Song(String id, String title, String releaseYear, String musicFileURL) {
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.musicFileURL = musicFileURL;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void printInfo(DetailLevel detailLevel) {
		printSongInfo();
		if (detailLevel.ordinal() >= 1)
			printArtistInfo();
		if (detailLevel.ordinal() >= 2)
			printAlbumInfo();
	}

	private void printSongInfo() {
		System.out.println("Song Title: " + title);
		System.out.println("Release Year: " + releaseYear);
		if (genre != Genre.UNDEFINED) {
			System.out.println("Genre: " + genre);
		}
	}

	private void printArtistInfo() {
		if (artist != null) {
			System.out.println("Artist Name: " + artist.getName());
			if (!artist.getAlias().isEmpty()) {
				System.out.println("Also known as: " + artist.getAlias());
			}
		}
	}

	private void printAlbumInfo() {
		if (album != null) {
			System.out.println("Album Title: " + album.getName());
		}
	}
}
