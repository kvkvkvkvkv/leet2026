class LFUCache {
    Map<Integer, Item> item = new HashMap();
    Map<Integer, Freq> freq = new HashMap();
    DLL dll;
    int size;
    public LFUCache(int capacity) {
        this.size = capacity;
        dll = new DLL();
    }
    
    public int get(int key) {
        if(!item.containsKey(key)) {
            return -1;
        }
        Item hit = item.get(key);
        Freq curFreq = freq.get(key);
        Freq nextFreq = curFreq.next;
        curFreq.values.remove(key);
        if(curFreq.values.size()==0) {
            dll.removeNode(curFreq);
        }
        if(nextFreq.freq == curFreq.freq+1) {
            nextFreq.values.add(key);
            freq.put(key,nextFreq);
        } else {
            // if(item.size() == size) {
            //     Freq next = dll.head.next;
            //     Iterator itr = next.values.iterator();
            //     if(itr.hasNext()) {
            //         Integer element = (Integer)itr.next();
            //         itr.remove();
            //         item.remove(element);
            //         freq.remove(element);
            //     }
            //     if(next.values.size()==0) {
            //         dll.removeNode(next);
            //     }
            // }
            Freq newFreq = new Freq(curFreq.freq+1);
            dll.addNode(newFreq, nextFreq);
            newFreq.values.add(key);
            freq.put(key,newFreq);
        }
        return hit.val;
    }
    
    public void put(int key, int value) {
        Item cacheKey = item.get(key);

        if(cacheKey == null && item.size()== size) {    
            Freq next = dll.head.next;
            Iterator itr = next.values.iterator();
            if(itr.hasNext()) {
                Integer element = (Integer) itr.next();
                itr.remove();
                item.remove(element);
                freq.remove(element);
            }
            if(next.values.size()==0) {
                dll.removeNode(next);
            }
        }

        if(cacheKey == null) {
            Freq nextHead = dll.head.next;
            Item newItem = new Item(key, value);
            item.put(key, newItem);
            if(nextHead.freq == 1) {
                freq.put(key, nextHead);
                nextHead.values.add(key);
            } else {
                Freq newFreq = new Freq(1);
                dll.addNode(newFreq, nextHead);
                newFreq.values.add(key);
                freq.put(key,newFreq);
            }
        } else {
            cacheKey.val = value;
            Freq curFreq = freq.get(key);
            Freq nextFreq = curFreq.next;
            curFreq.values.remove(key);
            if(curFreq.values.size()==0) {
                dll.removeNode(curFreq);
            }
            if(nextFreq.freq == curFreq.freq+1) {
                nextFreq.values.add(key);
                freq.put(key, nextFreq);
            } else {
                Freq newFreq = new Freq(curFreq.freq+1);
                dll.addNode(newFreq, nextFreq);
                newFreq.values.add(key);
                freq.put(key,newFreq);
                item.put(key,cacheKey);
            } 
        }
    }
}

class Item{
    int key;
    int val;

    Item(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Freq {
    int freq;
    LinkedHashSet<Integer> values;
    Freq next;
    Freq prev;

    Freq(int freq) {
        this.freq = freq;
        values = new LinkedHashSet();
    }
}

class DLL {
    Freq head;
    Freq tail;

    DLL() {
        head = new Freq(-1);
        tail = new Freq(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Freq newNode, Freq tail) {
        Freq prev = tail.prev;
        prev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        newNode.prev = prev; 
    }

    public void removeNode(Freq node) {
        Freq prev = node.prev;
        Freq next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */