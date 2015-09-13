//Binary Tree Paths
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x;}
 * }
*/

public List<String> binaryTreePaths(TreeNode root) {
	
	List<String> result = new ArrayList<>();
	
	if (root == null) {
		return result;
	}
	
	helper(result, new ArrayList<>(), root);
	
	return result;
}

private  void helper (List<String> result, List<Integer> temp, TreeNode root) {
	if (root == null) {
		return;
	} else {
		temp.add(root.val);
	}
	
	if (root.left == null && root.right == null) {
		result.add(getString(temp));
	}
	
	if (root.left != null) {
		helper(result, new ArrayList<>(temp), root.left);
	}
	
	if (root.right != null) {
		helper(result, new ArrayList<>(temp), root.right);
	}
}

private String getString(List<Integer> temp) {
	if (temp == null || temp.isEmpty()) {
		return null;
	}
	
	StringBuilder sb = new StringBuilder();
	sb.append(temp.get(0));
	for (int i = 1; i < temp.size(); i++) {
		sb.append("->").append(temp.get(i));
	}
	return sb.toString();
}