import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            for(int i = 0; i < freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}