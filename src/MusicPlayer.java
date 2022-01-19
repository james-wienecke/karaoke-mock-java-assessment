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
        String sayCmd = (voice.isEmpty() ? "say " : "say -v " + voice + " ");
        try {
            r.exec(sayCmd + "Now playing: " + song.getTitle() + " by " + song.getArtist());
            Thread.sleep(Player.INTRO_PAUSE);
            for (String word : song.getLyrics()) {
                r.exec(sayCmd + word);
                Thread.sleep(MusicPlayer.WORD_CADENCE);
            }
        } catch (InterruptedException | IOException ie) {
            ie.printStackTrace();
        }
    }
}
