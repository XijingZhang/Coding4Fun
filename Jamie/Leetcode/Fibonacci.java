import java.util.HashMap;
import java.util.Map;
// Fibonacci


public class Fibonacci {
	// Naive recursive 
	public int fib1(int n){
		int f;
		if (n <= 2) {
			f = 1;
		} else {
			f = fib1(n - 1)  + fib1(n - 2);
		}
		return f;
	}

	// Memoized DP
	public Map<Integer,Integer> memo = new HashMap<Integer,Integer>(); 
	public int fib2(int n) {
		int f;
		if (memo.containsKey(n)){
			return memo.get(n);
		}
	
		if (n <= 2) {
			f = 1;
		} else {
			f = fib2(n - 1)  + fib2(n - 2);
		}
		memo.put(n, f);
		return f;
	}


	// Botton - up DP
	public int fib3(int n) {
		Map<Integer,Integer> fib = new HashMap<Integer,Integer>(); 
		int f;
		for (int k = 1; k < n + 1; k++) {
			if (k <= 2){
				f = 1;
			} else {
				f = fib.get(k - 1) + fib.get(k - 2);
			}
			fib.put(k,f);
		}
		return fib.get(n);
	} 
	
	// Iterative
	public int fib4(int n) {
		int a,b,c;
		a = 1;
		b = 1;
		c = 0;
		if (n <= 2) {
			return a;
		}
		while(n > 2) {
			c = a + b;
			a = b;
			b = c;
			n--;
		}
		return c;
		
	}
	
	
   public static void main(String[] args){
	  Fibonacci ftest = new Fibonacci();
	  for (int i = 1; i <= 20; i++) {
	  	System.out.println(ftest.fib4(i));
	  }
	  
      
	
   }
}
