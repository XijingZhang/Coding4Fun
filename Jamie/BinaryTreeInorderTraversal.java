//Binary Tree Inorder Traversal 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution 1 : Iterative
public List<Integer> inorderTraversal(TreeNode root) {
	List<Integer> lst = new ArrayList<Integer>();
	if (root == null) {
		return lst;
	}
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode p = root;
	
	while(!stack.empty() || p != null) {
		if (p != null) {
			stack.push(p);
			p = p.left;
		} else {
			TreeNode t = stack.pop();
			lst.add(t.val);
			p = t.right;
		}
	}
	return lst;	
}

// Solution 2: Recursive
public class Solution {
    List<Integer> result = new ArrayList<Integer>();
 
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root !=null){
            helper(root);
        }
 
        return result;
    }
 
    public void helper(TreeNode p){
        if(p.left!=null)
            helper(p.left);
 
        result.add(p.val);
 
        if(p.right!=null)
            helper(p.right);
    }
}