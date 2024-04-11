import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long minTime = 1;
        long maxTime = times[times.length - 1] * (long) n;
        
        while (minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2;
            
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += (mid / times[i]);
                
                if (count >= n) {
                    break;
                }
            }
            
            if (count >= n) {
                answer = mid;
                maxTime = mid - 1;
            } else {
                minTime = mid + 1;
            }
        }
        
        
        return answer;
    }
}