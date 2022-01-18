public class MusicPlayer extends Player {
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

    }

    @Override
    public void play(Song song) {

    }
}
