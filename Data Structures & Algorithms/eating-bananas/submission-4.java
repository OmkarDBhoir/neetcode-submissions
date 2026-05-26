class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Arrays.stream(piles).max().getAsInt();
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(canEat(piles, mid, h)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean canEat(int[] piles, int max, int h) {
        int count = 0;
        for(int i=0; i<piles.length; i++) {
            count += Math.ceil((double)piles[i] / max);
        }
        return count <= h;
    }
}
