import java.io.IOException;
import java.util.List;

public class MusicPlayer extends Player {
//    private static final int WORD_CADENCE = ;
    private String voice;

    public MusicPlayer() {
        voice = "";
    }

    public MusicPlayer(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public void play(Album album) {
        album.getSongs().forEach(this::play);
    }

    @Override
    public void play(Song song) {
        Runtime r = Runtime.getRuntime();
        try {
            Thread.sleep(Player.INTRO_PAUSE);
            for (String line : song.getLyrics()) {
                Song.parseLyrics(line).forEach(word -> {
                    try {
                        r.exec("say " + word);
                        Thread.sleep(MusicPlayer.WORD_CADENCE);
                    } catch (IOException | InterruptedException ioe) {
                        ioe.printStackTrace();
                    }
                });
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Song song = new Song("Every Day is a Winding Road", "Sheryl Crow", Song.parseLyrics("Everyday is a winding road ... I get a little bit closer to feeling fine"));

        MusicPlayer player = new MusicPlayer();

        player.play(song);

    }
}
