class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                 (a,b) -> map.get(a)==map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b)
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry.getKey());
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll());

        return result;
    }
}