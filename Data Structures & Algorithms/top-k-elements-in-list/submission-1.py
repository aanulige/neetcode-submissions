class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        res = []
        freqDict = defaultdict(int)
        for num in nums:
            freqDict[num] += 1
        
        res = sorted(freqDict, key=freqDict.get, reverse=True)

        return res[:k]
