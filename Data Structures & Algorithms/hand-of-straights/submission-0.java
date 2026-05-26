class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i: hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while(!map.isEmpty()) {
            int start = map.firstKey();
            for(int i=start; i<start + groupSize; i++) {
                if(!map.containsKey(i)) return false;
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0) map.remove(i);
            }
        }
        return true;
    }
}
