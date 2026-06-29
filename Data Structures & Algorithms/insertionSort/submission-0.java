// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> ans = new ArrayList<>();
        for(int i=0; i<pairs.size(); i++) {
            Pair key = pairs.get(i);
            int j;
            for(j=i-1; j>=0; j--) {
                if(pairs.get(j).key <= key.key) break;
                pairs.set(j+1, pairs.get(j));
            }  
            pairs.set(j+1, key);   
            ans.add(new ArrayList<>(pairs));
        }

        return ans;
    }
}
