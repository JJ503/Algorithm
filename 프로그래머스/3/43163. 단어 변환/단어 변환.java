import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int[] count = new int[words.length];
        boolean[] visited = new boolean[words.length];
        Queue<Object[]> queue = new LinkedList();
        queue.add(new Object[]{begin, 0});
        while (!queue.isEmpty()) {
            Object[] poll = queue.poll();
            String nowWord = (String) poll[0];
            int depth = (int) poll[1];
            
            if (nowWord.equals(target)) {
                return depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] & canChange(nowWord, words[i])) {
                    visited[i] = true;
                    queue.add(new Object[]{words[i], depth + 1});
                }
            }
        }
        
        return 0;
    }
    
    public boolean canChange(String word, String target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        
        return count == 1;
    }
}