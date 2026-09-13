class Solution {
    public long shadowPairs(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            map.computeIfAbsent(nums[i],x -> new ArrayList<>()).add(i);
        }
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for(int i = 0;i<n;i++){
            int right = next[i];
            int total = right-i-1;
            List<Integer> list = map.get(nums[i]);
            int equal = lowerBound(list,right)-lowerBound(list,i+1);
            ans+=total-equal;
        }
        return ans;
    }
    private int lowerBound(List<Integer>list,int x){
        int l = 0;
        int r = list.size();
        while(l<r){
            int mid = l+(r-l)/2;
            if(list.get(mid)<x){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}