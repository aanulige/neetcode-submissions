class LRUCache {

    class dbllNode{
        int key;
        int val;
        dbllNode prev;
        dbllNode next;
        public dbllNode() {}
        public dbllNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, dbllNode> cache = new HashMap<Integer, dbllNode>();
    private int size;
    private int capacity;
    private dbllNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.dummyHead = new dbllNode();
        this.dummyTail = new dbllNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
       dbllNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        dbllNode node = cache.get(key);
        if(node == null){
            dbllNode newNode = new dbllNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            if(size > capacity){
                dbllNode last = dummyTail.prev;
                dbllNode newlast = dummyTail.prev.prev;
                newlast.next = dummyTail;
                dummyTail.prev = newlast;
                size--;
                cache.remove(last.key);
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }

    public void moveToHead(dbllNode node){
        dbllNode prev = node.prev;
        dbllNode next = node.next;
        prev.next = next;
        next.prev = prev;

        addToHead(node);
    }

    public void addToHead(dbllNode node){
        dbllNode temp = dummyHead.next;
        dummyHead.next = node;
        node.next = temp;
        node.prev = dummyHead;
        temp.prev = node;
    }
}
