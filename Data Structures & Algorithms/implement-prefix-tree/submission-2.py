class TrieNode:
    def __init__(self):
        self.pass_count = 0
        self.end = 0
        self.nexts = [None]*26

class PrefixTree:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        node.pass_count += 1
        for char in word:
            index = ord(char) - ord('a')
            if node.nexts[index] is None:
                node.nexts[index] = TrieNode()
            node = node.nexts[index]
            node.pass_count += 1
        node.end += 1


    def search(self, word: str) -> bool:
        if self.root is None:
            return False
        node = self.root
        for char in word:
            index = ord(char) - ord('a')
            if node.nexts[index] is None:
                return False
            node = node.nexts[index]
        return node.end > 0

    def startsWith(self, prefix: str) -> bool:
        if self.root is None:
            return False
        node = self.root
        for char in prefix:
            index = ord(char) - ord('a')
            if node.nexts[index] is None:
                return False
            node = node.nexts[index]
        return True