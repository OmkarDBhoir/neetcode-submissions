class TimeMap {

    private Map<String, Map<Integer, String>> timeMap = null; 
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new HashMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> pair = timeMap.get(key);
        if(pair == null) return "";
        int it = timestamp;
        while(it > 0) {
            if(pair.containsKey(it)) return pair.get(it);
            it--;
        }
        return "";
    }
}
