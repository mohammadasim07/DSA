class Solution {
    public int totalFruit(int[] fruit) {

        int n = fruit.length;
                if (n == 0) return 0;

       int b1 =fruit[0];
       int b2 = -1;

        int ind1 = 0;
        int ind2 = -1;
        
        int i = 0;
    
        while( b2 == -1 && i<n){
            if(fruit[i] == b1){
                ind1 = i;
            }else{
                b2 = fruit[i];
                ind2 = i;
            }
            i++;
        }
        int left = 0;
        int maxf =i;

        for(int j = i;j<n;j++){
            int f = fruit[j];
            
            if(f == b1){
                ind1 = j;
            }else if(f == b2){
                ind2 = j;
            }
            else{

                if(ind1 < ind2){
                    left = ind1 + 1;
                    b1 = f;
                    ind1 = j;
                }else{
                     left = ind2 + 1;
                      b2 = f;
                    ind2 = j;
                }


            }
                  int sum = j - left + 1 ;
                maxf = Math.max(maxf,sum);


        }
        return maxf;
    }
}