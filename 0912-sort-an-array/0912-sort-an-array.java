class Solution {
    public void arrange(int[] arr, int start , int mid , int end){
        int i = start;
        int j = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while(i<=mid && j <= end){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }


        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }

        while(j <= end){
            temp.add(arr[j]);
            j++;
        }

        for(int k = 0;k<temp.size();k++){
            arr[k + start] = temp.get(k);
        }
    }

    public void mergeSort(int[] arr, int start , int end){
        if(start >= end){
            return;
        }

        int mid = start + (end-start)/2;
        mergeSort(arr, start , mid);
        mergeSort(arr, mid+1 , end);
        arrange( arr, start, mid, end);

    }
    public int[] sortArray(int[] arr) {
         mergeSort(arr, 0 , arr.length-1);

         return arr;
    }
}