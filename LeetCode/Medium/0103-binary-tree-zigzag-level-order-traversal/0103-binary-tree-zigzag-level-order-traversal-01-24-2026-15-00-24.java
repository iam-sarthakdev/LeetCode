import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return new ArrayList<>(result);
    }

    private void dfs(TreeNode node, int level, List<LinkedList<Integer>> result) {
        if (node == null) return;

        // if current level list does not exist, create it
        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            result.get(level).addLast(node.val);   // left → right
        } else {
            result.get(level).addFirst(node.val);  // right → left
        }

        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
}
