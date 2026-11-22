class DoubleListNode:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev = self.next = None

class DoubleList:
    def __init__(self):
        self.head = self.tail = None

    def addToTail(self, node: DoubleListNode):
        if node is None:
            return None
        if self.head is None and self.tail is None:
            self.head = self.tail = node
        else:
            self.tail.next = node
            node.prev = self.tail
            self.tail = node
    def moveToTail(self, node: DoubleListNode):
        if(self.tail == node):
            return
        if(self.head == node):
            self.head = self.head.next
            self.head.prev = None
        else:
            node.next.prev = node.prev
            node.prev.next = node.next
        
        node.next = None
        self.tail.next = node
        node.prev = self.tail
        self.tail = node

    def removeHead(self):
        if self.head is None:
            return None
        removedHead = self.head
        if self.head == self.tail:  # 链表只有 1 个节点（比如 capacity == 1 时）
            self.head = self.tail = None
        else:
            temp = self.head.next
            temp.prev = None
            self.head.next = None
            self.head = temp
        return removedHead

class LRUCache:
    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity = capacity
        self.doublelist = DoubleList()

    
    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        
        node = self.cache[key]
        value = node.val
        self.doublelist.moveToTail(node)
        return value

        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.val = value
            self.doublelist.moveToTail(node)
        else:
            if(len(self.cache) == self.capacity):
                removedNode = self.doublelist.removeHead()
                self.cache.pop(removedNode.key)

            node = DoubleListNode(key, value)
            self.cache[key] = node
            self.doublelist.addToTail(node)
            
            



        
