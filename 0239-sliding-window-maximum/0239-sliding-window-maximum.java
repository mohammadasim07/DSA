class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
       int[] nums = new int[arr.length - k + 1];
         Deque<Integer> dq = new LinkedList<>();
        int l = 0;
        for(int i = 0;i < arr.length;i++){
           if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }

             dq.offerLast(i);
            if(i>=k-1){
                nums[l] = arr[dq.peekFirst()];
                l++;
                
            }
        }
        return nums;
    }
}