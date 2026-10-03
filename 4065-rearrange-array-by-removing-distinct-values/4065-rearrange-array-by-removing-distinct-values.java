class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] count = new int[101];

        int hight = 0;
        for(int i = 0;i<nums.length;i++){
            count[nums[i]]++;
            if(count[nums[i]] > hight) hight = count[nums[i]];
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(hight != 0){
            for(int j = 0;j<=100;j++){
                if(count[j] > 0){
                    list.add(j);
                    count[j]--;
                }
            }
            hight--;
        }

        int ans[] = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}