class Solution:

    def encode(self, strs: List[str]) -> str:
        if not strs:
            return ''
        res = ''
        for str in strs:
            n = len(str)
            res = res + f"{n},"
        res += '#'
        for str in strs:
            res += str
        print(res)
        return res


    def decode(self, s: str) -> List[str]:
        if not s:
            return []
        hash_index = s.index('#')
        header = s[:hash_index]          # 例如 "1,"
        inputstring = s[hash_index + 1:] # 例如 ","（完整保留正文里的所有逗号和 '#'）
        
        # 2. 只对头部按逗号分割，提取所有长度
        sizes = []
        for part in header.split(","):
            if part.isdigit():
                sizes.append(int(part))
                
        # 3. 按长度从正文中依次截取（因为已经跳过了 '#', i 从 0 开始即可）
        res = []
        i = 0
        for size in sizes:
            word = inputstring[i : i + size]
            res.append(word)
            i += size
            
        return res