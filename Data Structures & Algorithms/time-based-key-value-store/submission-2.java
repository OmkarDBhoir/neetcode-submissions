class TimeMap {

    private Map<String, List<Pair<Integer, String>>> timeMap = null;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> lst = timeMap.get(key);
        if(lst == null || lst.isEmpty()) return "";
        int start = 0, end = lst.size()-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(lst.get(mid).f() == timestamp) return lst.get(mid).s();
            if(lst.get(mid).f() < timestamp) start = mid + 1;
            else end = mid - 1;
        }
        return end >= 0 ? lst.get(end).s() : "";
    }
}

public record Pair<K, V>(K f, V s) {};
