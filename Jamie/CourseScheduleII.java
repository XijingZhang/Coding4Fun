// Course Schedule II
public int[] findOrder(int numCourses, int[][] prerequisites) {
    if(prerequisites == null) {
        throw new IllegalArgumentException("illegal prerequisites array");
    }
    int len = prerequisites.length;
    if(len == 0) {
       int[] result = new int[numCourses];
       for(int m = 0; m < numCourses; m++) {
            result[m] = m;
       }
       return result;
    }
    
    int[] pCounter = new int[numCourses];
    for(int i = 0; i < len; i++) {
        pCounter[prerequisites[i][0]]++;
    }

    LinkedList<Integer> queue = new LinkedList<Integer>();
    for(int i = 0; i < numCourses; i++) {
        if(pCounter[i] == 0) {
             queue.add(i);
        }
    }
    
    int numNopre = queue.size();
    
    int[] result = new int[numCourses];
    int j = 0;
    
    while(!queue.isEmpty()) {
        int c = queue.remove();
        result[j++] = c;
        
        for(int i = 0; i < len; i++) {
            if(prerequisites[i][1] == c) {
                pCounter[prerequisites[i][0]]--;
                if(pCounter[prerequisites[i][0]] == 0) {
                    queue.add(prerequisites[i][0]);
                    numNopre++;
                }
            }    
        }
    }
    
    if(numNopre == numCourses) {
        return result;
    } else {
        return new int[0];
    }
    }