import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        int start = 0;
        int end = distance;
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int count = 0;
            int prev = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    count++;
                } else {
                    prev = rocks[i];
                }
                
                if (count > n) {
                    break;
                }
            }
            
            if (distance - prev < mid) {
                count++;
            }
            
            if (count > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}