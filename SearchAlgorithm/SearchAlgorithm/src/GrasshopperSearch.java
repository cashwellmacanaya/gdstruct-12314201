public class GrasshopperSearch {
    public static int grasshopperSearch(int[] array, int target, int stepSize) {
        int index = 0;

        while (index < array.length) {
            if (array[index] == target) {
                return index;
            }
            if (array[index] > target) {
                for (int i = Math.max(0, index - stepSize); i < index; i++) {
                    if (array[i] == target) {
                        return i;
                    }
                }
                return -1;
            }
            index += stepSize;
        }
        for (int i = Math.max(0, index - stepSize); i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return - 1;
    }
    public static void main(String[] args) {
        int[] data = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
        int target = 56;
        int stepSize = 3;
        int result = grasshopperSearch(data, target, stepSize);

        if (result != -1) {
            System.out.println("target " + target + " found at index: " + result);
        }
        else {
            System.out.println("target " + target + " not found in dataset");
        }
    }
}
