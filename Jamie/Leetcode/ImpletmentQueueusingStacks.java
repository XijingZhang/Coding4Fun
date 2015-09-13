//Impletment Queue using Stacks
class MyQueue {
	Stack<Integer> temp = new Stack<Integer>();
	Stack<Integer> value = new Stack<Integer>();
	
	// Push(x)-- Push element x to the back of queue
	public void push(int x) {
		if (value.isEmpty()) {
			value.push(x);
		} else {
			while (!value.isEmpty()) {
				temp.push(value.pop());
			}
			
			value.push(x);
			
			while(!temp.isEmpty()) {
				value.push(temp.pop());
			}
		}
	}
	
	// pop() -- Remove the element from the front of queue
	public void pop() {
		value.pop();
	}
	
	// peek() -- Get the front element
	public int peek() {
		return value.peek();
	}
	
	// empty() -- Return whether the queue is empty
	public boolean empty() {
		return value.isEmpty();
	}
}