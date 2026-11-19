# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # 1. 终止条件：空链表、只有1个节点、或者只有2个节点时，都不需要重排
        if not head or not head.next or not head.next.next:
            return
        
        # 2. 找到最后一个节点 cur，以及它的前一个节点 prev
        prev = None
        cur = head
        while cur.next:   # 注意这里是 while cur.next，不是 while not cur.next
            prev = cur
            cur = cur.next
        
        # 3. 关键一步：断开尾节点，防止成环！
        prev.next = None
        
        # 4. 保存原来的第二个节点，把尾节点 cur 插到 head 后面
        next_node = head.next
        head.next = cur
        
        # 5. 【递归加在这里】：剩下的子链表（从 next_node 开始）继续按同样规则重排
        self.reorderList(next_node)
        
        # 6. 把重排后的子链表接在 cur 后面
        cur.next = next_node

