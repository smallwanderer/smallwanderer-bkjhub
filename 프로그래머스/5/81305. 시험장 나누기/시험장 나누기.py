import sys
sys.setrecursionlimit(10**6)

def solution(k, num, links):
    # links에서 루트 노드 찾기
    nodes = range(len(links)) # 0-based
    used = {x for a, b in links for x in (a, b) if x != -1}
    root = (set(nodes) - used).pop()

    weights = [[0, 0] for _ in range(len(links))]  # [왼쪽 자식 weight 합, 오른쪽 자식 weight 합]
    # 왜 dfs? 각 노드의 자식 노드들의 weight 합을 알아야 하기 때문
    def feasible(limit):
        INF = 10**18

        def dfs(node):
            if node == -1:
                return 0, 0 # groups, carry

            lg, lc = dfs(links[node][0])
            rg, rc = dfs(links[node][1])

            if num[node] > limit:
                return INF, 0
            
            groups = lg + rg
            carry = num[node]

            children = []
            if links[node][0] != -1:
                children.append(lc)
            if links[node][1] != -1:
                children.append(rc)

            children.sort()
            for s in children:
                if carry + s > limit:
                    groups += 1
                else:
                    carry += s
            
            return groups, carry
        g, _ = dfs(root)
        return g+1 <= k

    left, right = max(num), sum(num)
    while left < right:
        mid = (left + right) // 2

        if feasible(mid): 
            right = mid
        else:
            left = mid + 1
    return left