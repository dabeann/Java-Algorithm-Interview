package week11;

import java.util.*;

public class 순열_37 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(result,new ArrayList<>(), nums, nums.length );
        return result;
    }

    private void permutation(List<List<Integer>> result, List<Integer> comb, int[] nums,  int depth){
        if(depth == 0){
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int num : nums) {
            if (comb.contains(num))
                continue;
            comb.add(num);
            permutation(result, comb, nums, depth - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
