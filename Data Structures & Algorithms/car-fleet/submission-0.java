class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Integer[]> pos = new ArrayList<>();
        for(int i=0; i<position.length; i++) {
            Integer[] arr = {position[i], speed[i]};
            pos.add(arr);
        }

        pos.sort((a, b) -> Integer.compare(a[0],  b[0]));
        Stack<Double> stk = new Stack<Double>();
        for(int i=pos.size()-1; i>=0; i--) {
            int p = pos.get(i)[0];
            int s = pos.get(i)[1];
            Double res = ((double)target - p) / s;
            if(!stk.isEmpty() && stk.peek() >= res) continue;
            stk.push(res);
        }

        return stk.size();
    }
}
