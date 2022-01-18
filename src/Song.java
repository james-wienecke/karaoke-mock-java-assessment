import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Song {
    private String artist;
    private String title;
    private List<String> lyrics;

    public Song(String artist, String title, List<String> lyrics) {
        this.artist = artist;
        this.title = title;
        this.lyrics = lyrics;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<String> lyrics) {
        this.lyrics = lyrics;
    }

    public static List<String> parseLyrics(String input) {
        return new LinkedList<>(Arrays.asList(input.split(" ")));
    }
}
