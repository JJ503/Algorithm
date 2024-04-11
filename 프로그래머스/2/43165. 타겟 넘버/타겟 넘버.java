class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        
        return answer;
    }
    
    public void dfs(int currentNumber, int[] numbers, int target, int count) {
        if (count == numbers.length) {
            if (currentNumber == target) {
                answer++;
            }
            return;
        }
        
        dfs(currentNumber + numbers[count], numbers, target, count + 1);
        dfs(currentNumber - numbers[count], numbers, target, count + 1);
    }
}