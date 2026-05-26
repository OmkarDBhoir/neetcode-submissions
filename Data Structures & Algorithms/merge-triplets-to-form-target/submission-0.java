class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr = {0, 0, 0};

        for(int[] t: triplets) {
            if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                curr[0] = Math.max(curr[0], t[0]);
                curr[1] = Math.max(curr[1], t[1]);
                curr[2] = Math.max(curr[2], t[2]);
            }
        }

        return target[0] == curr[0] && target[1] == curr[1] && target[2] == curr[2];
    }
}
