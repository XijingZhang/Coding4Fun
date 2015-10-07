//Combinations
private List<List<Integer>> rst = new ArrayList<List<Integer>>();
public List<List<Integer>> combine(int n, int k) {
        
        ArrayList<Integer> solution = new ArrayList<Integer>();
        
        helper(rst, solution, n, k, 1);
        return rst;
    }
    
    private void helper(
        List<List<Integer>> rst, 
        ArrayList<Integer> solution, 
        int n, 
        int k, 
        int start ) {

        if (solution.size() == k){
            rst.add(new ArrayList(solution));
            return;
        }
        
        for(int i = start; i <= n; i++){
            solution.add(i);
            
            // the new start should be after the next number after i
            helper(rst, solution, n, k, i + 1); 
            solution.remove(solution.size() - 1);
        }
    }