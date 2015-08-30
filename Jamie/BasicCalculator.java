//Basic Calculator 
// solution 1
public int calculate(String s) {
	s = s.replace(" ","");
	
	Stack<String> stack = new Stack<String>();
	char[] arr = s.toCharArray();
	
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < arr.length; i++) {
		if (arr[i] == ' ')
			continue;
		
		if (arr[i] >= '0' && arr[i] <= '9') {
			sb.append(arr[i]);
			
			if (i == arr.length - 1) {
				stack.push(sb.toString());
			}
		} else {
			if (sb.length() > 0) {
				stack.push(sb.toString());
				sb = new StringBuilder();
			}
			
			if (arr[i] != ')') {
				stack.push(new String(new char[] { arr[i]}));
			} else {
				ArrayList<String> t = new ArrayList<String>();
				while(!stack.isEmpty()) {
					String top = stack.pop();
					if (top.equals("(")) {
						break;
					} else {
						t.add(0,top);
					}
				}
				int temp = 0;
				if (t.size() == 1) {
					temp = Integer.valueOf(t.get(0));
				} else {
					for (int j = t.size() - 1; j > 0; j = j - 2){
					if (t.get(j - 1).equals("-")) {
						temp += 0 - Integer.valueOf(t.get(j));
					}else {
						temp += Integer.valueOf(t.get(j));
					}
				}
				temp += Integer.valueOf(t.get(0));
			}
			stack.push(String.valueOf(temp));
		}
	}
}

ArrayList<String> t = new ArrayList<String>();
while(!stack.isEmpty()) {
	String elem = stack.pop();
	t.add(0, elem);
}

int temp = 0;
for (int i = t.size() - 1; i > 0; i = i - 2) {
	if (t.get(i - 1).equals("-")) {
		temp += 0 - Integer.valueOf(t.get(i));
	}else {
		temp += Integer.valueOf(t.get(i));
	}
}
temp += Integer.valueOf(t.get(0));
return temp;
}

// solution 2:
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        int result = 0;
        int sign = 1;
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}