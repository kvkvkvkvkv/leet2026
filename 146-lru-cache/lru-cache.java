class LRUCache {

    DLL dll;
    int size;
    Map<Integer, Item> itemsInCache = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = capacity;
        this.dll = new DLL();
    }
    
    public int get(int key) {
        if(!itemsInCache.containsKey(key)) {
            return -1;
        }
        Item cacheHit = itemsInCache.get(key);
        this.dll.removeNode(cacheHit);
        this.dll.addNode(cacheHit);
        return cacheHit.val;
    }
    
    public void put(int key, int value) {
        if(size == 0) {
            return;
        }
        int capacity = itemsInCache.size();
        Item cacheItem = itemsInCache.getOrDefault(key, null);

        if(capacity==this.size && cacheItem==null) {
            Item evictItem = dll.start.next;
            this.dll.removeNode(evictItem);
            itemsInCache.remove(evictItem.key);
        }

        if (cacheItem == null) {
            cacheItem = new Item(key, value);
        } else {
            cacheItem.val = value;
            this.dll.removeNode(cacheItem);
        }
        this.dll.addNode(cacheItem);
        itemsInCache.put(key, cacheItem);
    }
}

class Item {
    int key;
    int val;
    Item next = null;
    Item prev = null;

    Item() {
        this.key = -1;
        this.val = -1;
    }

    Item(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class DLL {
    Item start;
    Item end;

    DLL() {
        this.start = new Item();
        this.end = new Item();
        start.next = end;
        end.prev = start;
    }

    public void addNode(Item item) {
        Item secondLast = end.prev;
        secondLast.next = item;
        item.next = end;
        end.prev = item;
        item.prev = secondLast;
    }

    public void removeNode(Item item) {
        Item prev = item.prev;
        Item next = item.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */