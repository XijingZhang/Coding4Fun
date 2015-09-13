// Largest Rectangle in Histogram

//O(n^2) with pruning
public int LargestRectangleArea1(int[] height) {
	int area = 0;
	for (int i = 0; i < height.length; i++) {
		for (int k = i + 1; k < height.length; k++) {
			if ( height[k] < height[k - 1]) {
				i = k - 1;
				break;
			} else {
				i = k;
			}
		}
		int lowest = height[i];
		for (int j = i; j >= 0; j--) {
			if ( height[j] < lowest) {
				lowest = height[j];
			}
			int currArea = (i - j + 1) * lowest;
			if ( currArea > area) {
				area = currArea;
				
			}
		}
	}
	return area;
}

// O(n) using one stack
public int LargestRectangleArea2(int[] height) {
	int area = 0;
	java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
	for (int i = 0; i < height.length; i++) {
		if (stack.empty() || height[stack.peek()] < height[i]) {
			stack.push(i);
		} else {
			int start = stack.pop(); 
			int width = stack.empty() ? i : i - stack.peek() -1;
			area = Math.max(area, height[start] * width);
			i--;
		}
	}
	while (!stack.empty()) {
		int start = stack.pop();
		int width = stack.empty() ? height.length : height.length - stack.peek() -1;
		area = Math.max(area, height[start] * width);
	}
	return area;
 }                          