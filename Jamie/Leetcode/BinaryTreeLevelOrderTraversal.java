//Binary Tree Level Order Traversal 
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> l = new ArrayList<List<Integer>>();
	ArrayList<Integer> nodeValues = new ArrayList<Integer>();
	if (root == null)
		return l;
	
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	current.add(root);
	
	while (!current.isEmpty()) {
		TreeNode node = current.remove();
		
		if (node.left != null)
			next.add(node.left);
		if (node.right != null)
			next.add(node.right);
		
		nodeValues.add(node.val);
		if (current.isEmpty()) {
			current = next;
			next = new LinkedList<TreeNode>();
			l.add(nodeValues);
			nodeValues = new ArrayList();
		}
	}
	return l;
}