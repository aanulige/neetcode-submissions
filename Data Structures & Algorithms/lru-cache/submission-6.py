class DoubleListNode:
    def __init__(self, key, val):
        self.prev = self.next = None
        self.key = key
        self.val = val

class DoubleList:
    def __init__(self):
        self.head = DoubleListNode(0, 0)   # 虚拟头
        self.tail = DoubleListNode(0, 0)   # 虚拟尾
        self.head.next = self.tail
        self.tail.prev = self.head

    def add(self, node):                   # 插到虚拟尾之前
        node.prev, node.next = self.tail.prev, self.tail
        self.tail.prev.next = node
        self.tail.prev = node

    def removeNode(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def moveToTail(self, node):
        self.removeNode(node)
        self.add(node)

    def popHead(self):                     # 弹出最久未使用的节点，用于淘汰
        if self.head.next is self.tail:
            return None
        node = self.head.next
        self.removeNode(node)
        return node


class LRUCache:
    def __init__(self, capacity: int):
        self.cache = {}
        self.capacity = capacity
        self.doubleList = DoubleList()
        

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.doubleList.moveToTail(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.val = value
            self.doubleList.moveToTail(node)
        else:
            if len(self.cache) == self.capacity:
                removeNode =  self.doubleList.popHead()
                self.cache.pop(removeNode.key)
            node = DoubleListNode(key, value)
            self.cache[key] = node
            self.doubleList.add(node)



        
