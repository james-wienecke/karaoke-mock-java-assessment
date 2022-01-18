import java.util.List;

public class LyricPlayer extends Player {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    private String textColor;

    public LyricPlayer() {
        this.textColor = "default";
    }

    public LyricPlayer(String textColor) {
        this.textColor = textColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    private void displayText(String string) {
        String colorCode = RESET;
        switch(textColor.toLowerCase()) {
            case "red":
                colorCode = RED;
                break;
            case "green":
                colorCode = GREEN;
                break;
            case "yellow":
                colorCode = YELLOW;
                break;
            case "blue":
                colorCode = BLUE;
                break;
            case "purple":
                colorCode = PURPLE;
                break;
            case "cyan":
                colorCode = CYAN;
                break;
        }
        System.out.printf("%s%s", colorCode, string);
    }

    @Override
    public void play(Album album) {
        displayText(RESET + "Now playing: " + album.getName());
        album.getSongs().forEach(this::play);
    }

    @Override
    public void play(Song song) {
        displayText(RESET + "Now playing: " + song.getTitle() + " by " + song.getArtist());
        try {
            Thread.sleep(Player.INTRO_PAUSE);
            for (String line : song.getLyrics()) {
                Song.parseLyrics(line).forEach(word -> {
                    try {
                        displayText(word);
                        Thread.sleep(MusicPlayer.WORD_CADENCE);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                });
                System.out.print('\n');
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
