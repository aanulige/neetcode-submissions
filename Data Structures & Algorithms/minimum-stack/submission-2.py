class MinStack:
    def __init__(self):
        self.firstStack = deque()
        self.secondStack = deque()

    def push(self, val: int) -> None:
        self.firstStack.append(val)
        if len(self.secondStack) == 0:
            self.secondStack.append(val)
            return

        min = self.secondStack[-1]
        if val <= min:        
            self.secondStack.append(val)

    def pop(self) -> None:
        if self.secondStack[-1] == self.firstStack[-1]:
            self.secondStack.pop()
        self.firstStack.pop()

    def top(self) -> int:
        return self.firstStack[-1]

    def getMin(self) -> int:
        if len(self.secondStack) == 0: return None
        return self.secondStack[-1]