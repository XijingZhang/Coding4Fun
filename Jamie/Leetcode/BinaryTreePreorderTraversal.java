//Binary Tree Preorder Traversal
public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> returnList = new ArrayList<Integer>();
	
	if (root == null) {
		return returnList;
	}
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);
	
	while(!stack.empty()) {
		TreeNode node = stack.pop();
		returnList.add(node.val);
		
		if(node.right != null) {
			stack.push(node.right);
		}
		if(node.left != null) {
			stack.push(node.left);
		}
	}
	return returnList;
}