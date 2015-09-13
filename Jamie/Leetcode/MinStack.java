// Min Stack
//Solution 1:
class MinStack {
 Node dummy;
 Node topNode;
    class Node {
        int val;
        int min;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
     
    public MinStack() {
        dummy = new Node(0);
        dummy.min = Integer.MAX_VALUE;
        topNode = dummy;
    }
     
    public void push(int x) {
        Node n = new Node(x);
        n.next = topNode;
        n.min = n.val <= topNode.min ? n.val : topNode.min;
        topNode = n;
    }
 
    public void pop() {
        if (topNode == dummy) return;
        topNode = topNode.next;
        return;
    }
 
    public int top() {
        return topNode.val;
         
    }
 
    public int getMin() {
        return topNode.min;
    }
}


// Solution 2
class MinStack {
 Stack<Long> diff;
 long min; // prevent overflow
    public MinStack() {
     diff = new Stack<Long>();
     min = Integer.MAX_VALUE; 
    }
     
    public void push(int x) {
     diff.push((long)x - min);
     if(x < min) min = x;
     return;
    }
 
    public void pop() {
     if(!diff.isEmpty()) {
      Long d = diff.pop();
      min = d >= 0 ? min : min - d;
     }
    }
 
    public int top() {
     if(diff.isEmpty()) return -1;
     Long d = diff.peek();
     return d >= 0 ? (int)(d + min) : (int)min;
    }
 
    public int getMin() {
     return (int)min;
    }
}
