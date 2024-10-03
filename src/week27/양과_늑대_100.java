package week27;

import java.util.*;

public class 양과_늑대_100 {
    int answer = 0;
    List<Integer>[] graph;
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        dfs(0, 0, 0, nextNodes, info);

        return answer;
    }

    private void dfs(int node, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
        if (info[node] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        answer = Math.max(answer, sheep);

        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(node));

        // 현재 노드의 자식 노드들 추가
        newNextNodes.addAll(graph[node]);

        for (int next : newNextNodes) {
            dfs(next, sheep, wolf, newNextNodes, info);
        }
    }

    public static void main(String[] args) {
        양과_늑대_100 p = new 양과_늑대_100();
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        System.out.println(p.solution(info, edges));
    }
}
