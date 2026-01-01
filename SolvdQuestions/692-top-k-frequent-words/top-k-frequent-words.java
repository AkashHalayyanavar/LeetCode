class Pair {
    Integer count;
    String str;

    Pair (Integer count, String str) {
        this.count = count;
        this.str = str;
    }

}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> mp = new HashMap<>();

        for (String word: words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        Queue<Pair> pq = new PriorityQueue<>( (a,b) -> {
                if (b.count != a.count)
                    return b.count - a.count;
                
                return a.str.compareTo(b.str);
            } );

        for (Map.Entry<String, Integer> e: mp.entrySet()) {
            pq.add(new Pair(e.getValue(), e.getKey()));
        }

        List<String> result = new ArrayList<>();

        for (int i=0; i<k; i++) {
            result.add(pq.poll().str);
        }

        return result;
    }
}