class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {

            if(arr[i] == 0) {

                // shift right
                for(int j = n-1; j > i; j--) {
                    arr[j] = arr[j-1];
                }

                // duplicate zero
                if(i+1 < n)
                    arr[i+1] = 0;

                i++; // skip duplicated zero
            }
        }
    }
}
