package com.fwpsl.leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1028 👎 0


import scala.Int;

import java.util.LinkedList;
import java.util.List;

public class Permutations{
	public static void main(String[] args) {
		Solution solution = new Permutations().new Solution();

	}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
//            result.add(new LinkedList(track));  // 这里需注意，直接add(track)会有问题,全都是空的引用
            result.add(new LinkedList(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}