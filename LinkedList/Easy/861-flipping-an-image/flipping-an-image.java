class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int i = 0; i < image.length; i++) {
            int left = 0;
            int right = image[i].length - 1;

            while (left <= right) {
                // Swap left and right
                int temp = image[i][left] ^ 1; // invert
                image[i][left] = image[i][right] ^ 1; // invert
                image[i][right] = temp;

                left++;
                right--;
            }
        }

        return image;
    }
}
