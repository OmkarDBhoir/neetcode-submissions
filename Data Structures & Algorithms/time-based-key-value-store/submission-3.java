class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> iMap = timeMap.get(key);
        if(iMap == null) return "";
        Map.Entry<Integer, String> entry = iMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
