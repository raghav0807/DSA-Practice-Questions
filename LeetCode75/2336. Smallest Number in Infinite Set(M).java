import java.util.TreeSet;

class SmallestInfiniteSet {
    private int currentSmallest;
    private TreeSet<Integer> addedBack;

    public SmallestInfiniteSet() {
        currentSmallest = 1;
        addedBack = new TreeSet<>();
    }
    
    public int popSmallest() {
        if (!addedBack.isEmpty()) {
            return addedBack.pollFirst();
        }
        return currentSmallest++;
    }
    
    public void addBack(int num) {
        if (num < currentSmallest) {
            addedBack.add(num);
        }
    }
}

