public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void put(String key, Player player) {
        int index = hashKey(key);

        if (isOccupied(index)) {

            int stoppingIndex = index;

            if (index == hashtable.length - 1) {
                index = 0;
            } else {
                index++;
            }

            while (index != stoppingIndex && isOccupied(index)) {
                index = (index + 1) % hashtable.length;
            }
        }

        hashtable[index] = new SavedPlayer(key, player);
    }

    public int findIndex(String key) {
        int index = hashKey(key);
        SavedPlayer savedPlayer = hashtable[index];

        if (savedPlayer == null) {
            return -1;
        }

        if (!key.equals(savedPlayer.getKey())) {
            int stoppingIndex = index;
            boolean found = false;

            if (index == hashtable.length - 1) {
                index = 0;
            } else {
                index++;
            }

            while (index != stoppingIndex && !found) {
                if (isOccupied(index)) {
                    savedPlayer = hashtable[index];

                    if (key.equals(savedPlayer.getKey())) {
                        found = true;
                        break;
                    }
                }

                index = (index + 1) % hashtable.length;
            }

            if (!found) {
                index = -1;
            }
        }

        return index;
    }

    public Player get(String key) {
        int index = findIndex(key);

        if (index == -1) {
            return null;
        }

        return hashtable[index].getValue();
    }

    public void remove(String key) {
        int index = findIndex(key);

        if (index == -1) {
            System.out.println("Key " + key + " not found.");
            return;
        }


        System.out.println("Removing key: " + key);
        hashtable[index] = null;


        int nextIndex = (index + 1) % hashtable.length;
        while (isOccupied(nextIndex)) {
            SavedPlayer temp = hashtable[nextIndex];
            hashtable[nextIndex] = null;
            put(temp.getKey(), temp.getValue());
            nextIndex = (nextIndex + 1) % hashtable.length;
        }
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (isOccupied(i)) {
                System.out.println(i + " - " + hashtable[i].getValue());
            } else {
                System.out.println(i + " - NULL");
            }
        }
    }
}
