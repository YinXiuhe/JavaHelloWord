//public class LeetCode637 {

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private List<TreeNode> nodes = new ArrayList<TreeNode>();
    private List<Double> result = new ArrayList<Double>();
    private Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public List<Double> averageOfLevels(TreeNode root) {
        TreeNode zeroNode = null;

        TreeNode cur = null;
        queue.offer(root);

        // System.out.println(String.format("begin"));
        boolean b = false;
        while (cur != null || !queue.isEmpty()) {
            if (cur != null) {
                if (cur.left != null) {
                    b = queue.offer(cur.left);
                }

                if (cur.right != null) {
                    b = queue.offer(cur.right);
                    // print(String.format("Right B: %b, value: %d\n", b, cur.right.val));
                }

                cur = null;
            } else {
                cur = queue.poll();
                nodes.add(cur);
            }
        }


        for (int i = 0; i < nodes.size(); ++i) {
            if (nodes.get(i) != null) {
                print(String.format("[%02d]:[%d]\n", i, nodes.get(i).val));
            } else {
                print(String.format("[%02d]:[%d]\n", i, -99));
            }
        }


        int sum = 0;
        int level_cnt = 0;
        double cur_val;

        TreeNode tmp = null;
        for (int i = nodes.size() - 1; i > 0;) {
            tmp = nodes.get(i);
            sum = tmp.val;
            level_cnt = 1;
            for (int j = i - 1; j > 0; --j) {
                if (isParent(tmp, nodes.get(j)) || isSingle(nodes.get(j))) {
                    cur_val = sum * 1.0 / level_cnt;
                    result.add(0, cur_val);
                    i = j;
                    break;
                } else {
                    level_cnt += 1;
                    sum += nodes.get(j).val;
                }
            }
        }


        return result;
    }

    private boolean isParent(TreeNode t, TreeNode parent) {
        if (t == parent.left || t == parent.right) {
            return true;
        }

        return false;
    }

    private boolean isSingle(TreeNode t) {
        if (t.left == null && t.right == null) {
            return true;
        }

        return false;
    }

    private void print(String msg) {
        System.out.print(msg);
    }
}
//}
