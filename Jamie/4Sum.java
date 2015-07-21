//4sum
//O(N^3)
public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        int i = 0;
        int z = 1;
        int j ;
        int k ;
        Set set = new HashSet();
        //= num.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num.length < 4)
            return res;
        for (i=0; i < num.length - 3; i++) {
            for (z=i+1; z < num.length - 2; z++) {
                int left = target -(num[i] + num[z]);
                j = z+1;
                k = num.length - 1;
                while (j<k) {
                    if (num[j] + num[k] == left) {
                        List<Integer> sol = new ArrayList<Integer>();
                        sol.add(num[i]);
                        sol.add(num[z]);
                        sol.add(num[j]);
                        sol.add(num[k]);
                        if (set.add(sol))
                            res.add(sol);
                        j++;
                        k--;
                    } else if (num[j] + num[k] < left) {
                        j++;

                    } else
                        k--;
                }
            }
        }
        return res;
    }