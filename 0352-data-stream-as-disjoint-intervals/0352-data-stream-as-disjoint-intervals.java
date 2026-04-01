class SummaryRanges {
    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        if (map.containsKey(value)) {
            return;
        }

        Integer lowerKey = map.floorKey(value);
        Integer higherKey = map.ceilingKey(value);

        if (lowerKey != null && map.get(lowerKey)[1] >= value) {
            return;
        }

        boolean mergeLeft = lowerKey != null && map.get(lowerKey)[1] + 1 == value;
        boolean mergeRight = higherKey != null && higherKey - 1 == value;

        if (mergeLeft && mergeRight) {
            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);
        } else if (mergeLeft) {
            map.get(lowerKey)[1] = value;
        } else if (mergeRight) {
            int[] right = map.remove(higherKey);
            map.put(value, new int[]{value, right[1]});
        } else {
            map.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {
        return map.values().toArray(new int[map.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */