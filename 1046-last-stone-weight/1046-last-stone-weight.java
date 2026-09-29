import java.util.*;

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();

    public void heap(int a) {
        arr.add(a);
        int i = arr.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (arr.get(i) > arr.get(parent)) {
                Collections.swap(arr, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    public int deleteMax() {
        int max = arr.get(0);
        int last = arr.remove(arr.size() - 1);

        if (!arr.isEmpty()) {
            arr.set(0, last);
            int i = 0;
            int n = arr.size();

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int largest = i;

                if (left < n && arr.get(left) > arr.get(largest)) {
                    largest = left;
                }

                if (right < n && arr.get(right) > arr.get(largest)) {
                    largest = right;
                }

                if (largest == i) break;

                Collections.swap(arr, i, largest);
                i = largest;
            }
        }

        return max;
    }

    public int lastStoneWeight(int[] stones) {
        for (int a : stones) {
            heap(a);
        }

        while (arr.size() > 1) {
            int first = deleteMax();
            int second = deleteMax();

            if (first != second) {
                heap(first - second);
            }
        }

        return arr.isEmpty() ? 0 : arr.get(0);
    }
}