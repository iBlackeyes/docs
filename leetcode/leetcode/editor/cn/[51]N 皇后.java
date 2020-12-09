package com.fwpsl.leetcode.editor.cn;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 688 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NQueens{
	public static void main(String[] args) {
		Solution solution = new NQueens().new Solution();
		
	}
	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<ArrayList<String>> board = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            ArrayList<String> line = new ArrayList<>(n);
            Collections.fill(line, ".");
            board.add(new ArrayList<>(line));
        }

        bucktrack(board, 0);
        List<List<String>> result = new LinkedList<>();
        for (ArrayList<String> strings : board) {
            result.add(strings);
        }
        return result;
    }

    public void bucktrack(List<ArrayList<String>> board, int row, int n) {
        if (board.size() == row) return;
        int size = board.get(0).size();
        for (int col=0; col<size; col++) {
            if (!isValid(board, row, col)) continue;
            board.get(row).set(col, "Q");
            bucktrack(board, row + 1, n);
            board.get(row).set(col, ".");
        }
    }

    public boolean isValid(List<ArrayList<String>> board, int row, int col) {
        // col列无Q
        int size = board.size();
        for(int i=0; i<row; i++) {
            if (board.get(i).get(col) == "Q") return false;
        }
        // 左上方无Q
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board.get(i).get(j) == "Q") return false;
        }
        // 右上方无Q
        for (int i=row+1, j=col+1; i<size && j<size; i++, j++) {
            if (board.get(i).get(j) == "Q") return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}