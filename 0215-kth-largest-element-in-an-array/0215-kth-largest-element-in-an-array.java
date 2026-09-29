
class Solution {
    ArrayList<Integer> arr = new ArrayList<>();

    public void heap(int a) {
        arr.add(a);
        int i = arr.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (arr.get(i) < arr.get(parent)) {
                Collections.swap(arr, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    public int delete() {
        int min = arr.get(0);
        int last = arr.remove(arr.size() - 1);

        if (!arr.isEmpty()) {
            arr.set(0, last);
            int i = 0;

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                if (left < arr.size() &&
                    arr.get(left) < arr.get(smallest)) {
                    smallest = left;
                }

                if (right < arr.size() &&
                    arr.get(right) < arr.get(smallest)) {
                    smallest = right;
                }

                if (smallest == i) break;

                Collections.swap(arr, i, smallest);
                i = smallest;
            }
        }

        return min;
    }

    public int findKthLargest(int[] nums, int k) {
        for (int a : nums) {
            heap(a);

            if (arr.size() > k) {
                delete();
            }
        }

        return arr.get(0);
    }
}