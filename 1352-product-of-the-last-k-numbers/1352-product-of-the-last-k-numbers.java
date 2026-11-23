class ProductOfNumbers {
    ArrayList<Integer> arr;
    public ProductOfNumbers() {
        arr = new ArrayList();
    }
    
    public void add(int num) {
        arr.add(num);
    }
    
    public int getProduct(int k) {
        k = arr.size() - k;
        int l = 1;
        for(int i = arr.size() - 1; i >= k;i--){
            l *= arr.get(i);
        }
        return l;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */