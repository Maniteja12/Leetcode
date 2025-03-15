package org.example.amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    class LruCache {
        private int cap;
        private Map<Integer, Node> cache;
        private Node oldest;
        private Node latest;

        public LruCache(int capacity) {
            this.cap = capacity;
            this.cache = new HashMap<>();
            this.oldest = new Node(0, 0);
            this.latest = new Node(0, 0);
            this.oldest.next = this.latest;
            this.latest.prev = this.oldest;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
                insert(node);
                return node.value;
            }
            return -1;
        }

        private void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void insert(Node node) {
            Node prev = latest.prev;
            Node next = latest;
            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                remove(cache.get(key));
            }
            Node nn = new Node(key, value);
            cache.put(key, nn);
            insert(nn);
            if (cache.size() > cap) {
                Node lru = oldest.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }

    }
    private LruCache lru1 ;
    public static void printHashMap(HashMap<Integer, Node> c){
        for(Node k : c.values()){
            System.out.println(k + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache l = new LRUCache();
        LruCache lru = l.new LruCache(3); // Create an LRU Cache with a capacity of 3

        // Put some key-value pairs in the cache
        lru.put(1, 10);
        lru.put(2, 20);
        lru.put(3, 30);

        // Access some keys
        System.out.println("Get key 1: " + lru.get(1)); // Should return 10

        // Add a new key-value pair, causing the least recently used key to be evicted
        lru.put(4, 40);

        // Access the evicted key
        System.out.println("Get key 2: " + lru.get(2)); // Should return -1 (evicted)

        // Access existing keys
        System.out.println("Get key 3: " + lru.get(3)); // Should return 30
        System.out.println("Get key 4: " + lru.get(4)); // Should return 40

        // Add more keys to test eviction
        lru.put(5, 50);
        lru.put(6, 60);

        // Check current state
        System.out.println("Get key 1: " + lru.get(1)); // Should return -1 (evicted)
        System.out.println("Get key 5: " + lru.get(5)); // Should return 50
        System.out.println("Get key 6: " + lru.get(6)); // Should return 60
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */

}
