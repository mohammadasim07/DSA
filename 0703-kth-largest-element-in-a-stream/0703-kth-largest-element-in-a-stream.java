class KthLargest {

    int k;
    ArrayList<Integer> heap = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            addToHeap(num);

            if (heap.size() > k) {
                removeRoot();
            }
        }
    }

    // Insert into min-heap
    public void addToHeap(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(i) < heap.get(parent)) {
                Collections.swap(heap, i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    // Remove smallest element
    public void removeRoot() {
        int last = heap.remove(heap.size() - 1);

        if (heap.isEmpty()) {
            return;
        }

        heap.set(0, last);
        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < heap.size() &&
                heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            if (right < heap.size() &&
                heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) {
                break;
            }

            Collections.swap(heap, i, smallest);
            i = smallest;
        }
    }

    public int add(int val) {
        addToHeap(val);

        if (heap.size() > k) {
            removeRoot();
        }

        return heap.get(0);
    }
}