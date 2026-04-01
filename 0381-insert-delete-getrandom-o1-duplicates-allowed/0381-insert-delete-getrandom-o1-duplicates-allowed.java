import java.util.*;

class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val) || map.get(val).isEmpty();

        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);

        return notPresent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        int removeIndex = map.get(val).iterator().next();
        map.get(val).remove(removeIndex);

        int lastIndex = list.size() - 1;
        int lastVal = list.get(lastIndex);

        if (removeIndex != lastIndex) {
            list.set(removeIndex, lastVal);

            map.get(lastVal).remove(lastIndex);
            map.get(lastVal).add(removeIndex);
        }

        list.remove(lastIndex);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */