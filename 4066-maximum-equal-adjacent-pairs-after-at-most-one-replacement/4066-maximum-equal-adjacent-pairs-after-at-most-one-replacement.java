class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int already = 0;

        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length - 1;i++){
            if(nums[i] == nums[i+1]){
                already ++;
            }  else{
            int x = Math.min(nums[i],nums[i+1]);
            int y = Math.max(nums[i],nums[i+1]);
            String key = x + "," + y;
            map.put(key, map.getOrDefault(key,0) + 1);
        }
        
       
    }

    int max = 0;

    for(int count : map.values()){
    max = Math.max(max,count);
    }
return already + max;
}}