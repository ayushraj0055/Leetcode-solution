class Solution {
    public boolean validMountainArray(int[] arr) {

        int n = arr.length;
        int i = 0;

        // Step 1: Walk UP
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Step 2: Peak cannot be first or last
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Step 3: Walk DOWN
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Step 4: Must reach end
        return i == n - 1;
    }
}
