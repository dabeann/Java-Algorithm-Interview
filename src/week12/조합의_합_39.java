package week12;

import java.util.*;

public class 조합의_합_39 {
    ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        generateComb(candidates, target, 0);
        return result;
    }

    void generateComb(int[] candidates, int remain, int index) {
        if (remain == 0) {
            result.add((ArrayList<Integer>) list.clone());
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= remain) {
                list.add(candidates[i]);
                generateComb(candidates, remain - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
}
