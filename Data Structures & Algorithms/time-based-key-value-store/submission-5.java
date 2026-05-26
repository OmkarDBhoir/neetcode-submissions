class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = timeMap.get(key);
        if(map == null) return "";
        List<Integer> keys = new ArrayList<>(map.keySet());
        int start = 0, end = keys.size()-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(keys.get(mid) <= timestamp)  {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end < 0 ? "" : map.get(keys.get(end));
    }
}
