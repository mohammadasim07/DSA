class Solution {

    public int maxVowels(String s, int k) {
        int j = 0;
        int count = 0;
        while(j < k){
           char ch = s.charAt(j); 
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
            j++;
        }
        int maxC = count;

        for(int i = k;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }

            char chPre = s.charAt(i-k);
             if(chPre == 'a' || chPre == 'e' || chPre == 'i' || chPre == 'o' || chPre == 'u'){
                count--;
            }
            if(count > maxC){
                maxC = count;
            }
        }
        return maxC;
    }
}