def solution(n):
    def dfs(open, close, something):
        if open == close == 0:
            return [something]
        
        result = []
        if open > 0:
            result.extend(dfs(open-1, close, something + "("))
        
        if close > 0 and close > open:
            result.extend(dfs(open, close-1, something + ")"))

        return result
    
    answer = dfs(n, n, "")
    return len(answer)
