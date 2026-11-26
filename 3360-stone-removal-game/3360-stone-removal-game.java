class Solution {
    public boolean canAliceWin(int n) {
        if(n < 10) return false;
        boolean alice = false;
        boolean bob = false;
        int k = 10;

        while(n > 0){
            if(n>=k){
                alice = true;
                n= n-k;
                k--;
            }
            if(n>=(k)){
                alice = false;
                n= n-(k);
                k--;
            }
            if(n < k){
                break;
            } 
        
        }

        return alice;
    }
}