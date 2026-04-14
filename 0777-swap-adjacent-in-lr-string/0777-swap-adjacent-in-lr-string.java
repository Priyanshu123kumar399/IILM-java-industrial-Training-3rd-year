class Solution {
    public boolean canTransform(String start, String result) {
        
        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }
        
        int i = 0, j = 0;
        int n = start.length();
        
        while (i < n && j < n) {
            
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && result.charAt(j) == 'X') j++;
            
            if (i == n && j == n) return true;
            
            char c = start.charAt(i);
            
            if (c == 'L' && i < j) return false;
            if (c == 'R' && i > j) return false;
            
            i++;
            j++;
        }
        
        return true;
    }
}