package week12;

import java.util.*;

public class 조합_38 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(n, k, new boolean[n], 0, answer);
        return answer;
    }

    public void backtracking (int n, int k, boolean[] visited, int start, List<List<Integer>> answer) {
        if(k == 0) {
            List<Integer> cases = new ArrayList<Integer>();
            for(int i = 0; i < visited.length; i++) {
                if(visited[i])
                    cases.add(i + 1);
            }
            answer.add(cases);
        } else {
            for(int i = start; i < n; i++) {
                visited[i] = true;
                backtracking(n, k - 1, visited, i + 1, answer);
                visited[i] = false;
            }
        }
    }
}
