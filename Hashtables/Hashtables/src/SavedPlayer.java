public class SavedPlayer {
    private String key;

    private Player value;

    public SavedPlayer(String key, Player value) {
        this.key = key;
        this.value = value;
    }

    public Player getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}