import java.util.*;
import java.lang.String;
import java.util.Arrays;
import java.lang.StringBuffer;

public class cc1_Array_String {
    
	// CC 1.1 Implement an algorithm to determine if a string has all unique characters.
	// What if you cannot use additional data structures?



	public boolean isUniqueChars(String str) {
		if (str.length() > 256) return false;
		
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = (int) str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		
		return true;
	}
	
	public boolean isUniqueChars2(String str) {
		
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = (int) str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker  |= (1 << val);
		}
		
		return true;
	}
	
    // 1.3 Given two strings, write a method to decide if one is a permutation of the other
// Solution #1 : Sort the strings
    public String sort(String s) {
	    char[] content = s.toCharArray();
	    java.util.Arrays.sort(content);
	    return new String(content);
    }

    public boolean permutation1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

 // Solution #2 : Check if the two strings have identical charactor count
    public boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256];
        char[] s_array = s.toCharArray();

        for (char c : s_array) {
            letters[c]++;
            System.out.println(letters[c]);
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }


	
    // cc 1.4
	public void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		for (i = 0; i < length; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' '){
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
	}
	
	
	// cc 1.5
	// Solution #1 : StringBuffer
	public String compress1(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		StringBuffer mystr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (last == str.charAt(i)) {
				count ++;
			} else {
				mystr.append(last);
				mystr.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(last);
		mystr.append(count);
		// if (str.length() <= mystr.toString().length()) {
// 			return str;
// 		}
		return mystr.toString();
	}
	
	// Solution #2 : Array
	public String compress2(String str) {
		int size = countCompression(str);
		if (size >= str.length()) {
			return str;
		}
		
		char[] array = new char[size];
		int count = 1;
		char last = str.charAt(0);
		int index = 0;
		for (int i = 1; i < str.length(); i++) {
			if (last == str.charAt(i)) count++;
			else {
				index = set_array(array, last, count, index);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = set_array(array, last, count, index);
		return String.valueOf(array);
    }
	
	public int set_array(char[] array, char c, int count, int index) {
		array[index] = c;
		index++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (int i = 0; i < cnt.length; i++) {
			array[index] = cnt[i];
			index++;
		}
		return index;
	}
	public int countCompression(String str) {
		if (str == null || str.isEmpty()) return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	
	// cc 1.6  Rotate image (reverse to-bottom then swap symmetry) !! very smart
	public void rotateImage(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
	    }

	    int length = matrix.length;
	    int mid = length / 2;
	        // reverse top-bottom, swap the ith row with (n-i)th row
	    for (int i = 0; i < mid; i++) {
	        for ( int j = 0; j < length; j++) {
				int tmp = matrix[i][j];
	            matrix[i][j] = matrix[length - 1 - i][j];
	            matrix[length - 1 - i][j] = tmp;
	        }
	    }

	        // swap symmetry
	     for (int i = 0; i < length; i++) {
	         for ( int j = i + 1; j < length; j++) {
	            int tmp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = tmp;
	        }
	    }
	}
	
	
	// cc 1.7
	public void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || col[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		
	}

    public static void main(String[] args) {
        String s = "abcde";
        String t = "Keep coding! never too late to be good!";
        cc1_Array_String test = new cc1_Array_String();
		
		//test for 1.1
		// if (test.isUniqueChars2(s)) {
// 			System.out.print("It's a unique string.");
// 		} else {
// 			System.out.print("It's not a unique string.");
// 		}
		//test for 1.3
        // if (test.permutation2(s, t)){
 //            System.out.print("String s is a permutations of string t.");
 //        } else {
 //            System.out.print(test.permutation2(s,t));
 //        }
 //
 //        char[] s_array = s.toCharArray();
 //        int[] count = new int[256];
 //        System.out.println(count[255]);
 //        for (int i = 0; i < 256; i++) {
 //            System.out.print(count[i]);
 //        }
 
        //test for 1.4
		// String str = "Mr John Smith     ";
// 		char[] str_array = str.toCharArray();
// 		int length = 13;
// 		System.out.println("Before replacing the spaces:" + str);
// 		test.replaceSpaces(str_array,13);
// 		// String newstr = new String(str_array);
// 		// or
// 		String newstr = String.copyValueOf(str_array);
// 	    System.out.println("After replacing the spaces:" + newstr);
    
        //test for 1.5
		// String str = "aabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcda";
// 		System.out.println(str);
// 		System.out.println(test.compress1(str));
// 		System.out.print(test.compress2(str));


        // test for 1.6 
		// int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
// 		test.rotateImage(m);
// 		for (int i = 0; i < m.length; i++) {
// 			for (int j = 0; j < m[0].length; j++) {
// 				System.out.print(m[i][j] + " ");
// 			}
// 			System.out.println("");
// 		}
		
        // test for 1.7
		// int[][] m = {{0,7,8,3},{9,1,0,5},{1,0,2,5}};
// 		for (int i = 0; i < m.length; i++) {
// 			for (int j = 0; j < m[0].length; j++) {
// 				System.out.print(m[i][j] + " ");
// 			}
// 			System.out.println("");
// 		}
// 		System.out.println("");
// 		test.setZeros(m);
// 		for (int i = 0; i < m.length; i++) {
// 			for (int j = 0; j < m[0].length; j++) {
// 				System.out.print(m[i][j] + " ");
// 			}
// 			System.out.println("");
// 		}


		

		

    }
}
