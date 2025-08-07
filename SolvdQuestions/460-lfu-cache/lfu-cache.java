class Node {
    int key;
    int val;
    int frequency;

    Node next;
    Node prev;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        frequency = 1;
    }
}

class DLL {

    Node head;
    Node tail;
    int size;

    DLL() {
        size = 0;
        head = new Node(-1, -1); // dummy head
        tail = new Node(-1, -1); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // add method adds the node to the front of the list
    void add(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        size++;
    }

    // remove method removes the given node from the list
    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }

}

class LFUCache {

    final int capacity;
    int currSize;
    int minFreq;
    Map<Integer, Node> cache;
    Map<Integer, DLL> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        currSize = 0;
        minFreq = 0;

        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        
        if (!cache.containsKey(key)) {
            return -1;
        }

        // update the node 
        Node node = cache.get(key);
        updateNode(node);

        return node.val;
    }
    
    public void put(int key, int value) {

        // handle edge/corner case
        if (capacity <= 0)
            return;

        // cache contains the key
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            updateNode(node);
            return;
        }
        
        // cache does not contain the key
        currSize++;

        if (currSize > capacity) {
            // remove node from the least frequency least recently used node
            DLL minFreqList = frequencyMap.get(minFreq);
            
            // remove from cache map
            cache.remove(minFreqList.tail.prev.key);

            // remove from DLL 
            minFreqList.remove(minFreqList.tail.prev);

            currSize--;
        }

        // reset minFreq to 1, as we added new node
        minFreq = 1;

        Node node = new Node(key, value);

        // get the list with frequency 1, and then add new node into the list, as well into the cache
        DLL list = frequencyMap.getOrDefault(1, new DLL());
        list.add(node);
        frequencyMap.put(1, list);
        cache.put(key, node);
    }

    void updateNode(Node node) {
        int currFreq = node.frequency;
        DLL currList = frequencyMap.get(currFreq);
        currList.remove(node);

        if (currFreq == minFreq && currList.size == 0) {
            minFreq++;
        }

        // increase the freq of current node
        node.frequency++;
        DLL list = frequencyMap.getOrDefault(node.frequency, new DLL());

        // add node to the list
        list.add(node);
        
        // update the frequency map
        frequencyMap.put(node.frequency, list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */