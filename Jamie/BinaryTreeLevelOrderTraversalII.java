//Binary Tree Level Order Traversal II 
public List<List<Integer>> levelOrderBottom(TreeNode root) {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	if (root == null) {
		return result;
	}
	
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	current.offer(root);
	
	ArrayList<Integer> numberList = new ArrayList<Integer>();
	
	while (!current.isEmpty()) {
		TreeNode head = current.poll();
		numberList.add(head.val);
		
		if (head.left != null) {
			next.offer(head.left);
		}
		if (head.right != null) {
			next.offer(head.right);
		}
		
		if (current.isEmpty()) {
			current = next;
			next = new LinkedList<TreeNode>();
			result.add(numberList);
			numberList = new ArrayList<Integer>();
		}
	}
	
	List<List<Integer>> reversedResult = new ArrayList<List<Integer>>();
	for (int i = result.size() - 1; i >=0; i--) {
		reversedResult.add(result.get(i));
	}
	
	return reversedResult;
}
	
	
	