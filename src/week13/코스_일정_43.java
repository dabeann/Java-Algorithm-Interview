package week13;

import java.util.*;

public class 코스_일정_43 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 0: 방문하지 않음, 1: 방문 중, 2: 방문 완료
        int[] visitStatus = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adjList, visitStatus)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> adjList, int[] visitStatus) {
        if (visitStatus[course] == 1) {
            return true;
        }
        if (visitStatus[course] == 2) {
            return false;
        }
        visitStatus[course] = 1;
        for (int neighbor : adjList.get(course)) {
            if (hasCycle(neighbor, adjList, visitStatus)) {
                return true;
            }
        }
        visitStatus[course] = 2;
        return false;
    }
}
