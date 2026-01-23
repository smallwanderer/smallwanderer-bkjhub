import sys
sys.setrecursionlimit(10**6)

def solution(info, edges):
    N = len(info)

    adjency = [[] for _ in range(N)]
    for edge in edges:
        adjency[edge[0]].append(edge[1])
    
    print(adjency)

    def sheepwolf(node, queue, sheep, wolf):
        if info[node] == 0:
            sheep += 1
        else:
            wolf += 1

        # 탐색 종료
        if wolf >= sheep:
            return sheep
        
        for adj in adjency[node]:
            queue.append(adj)
        
        possibility = []
        for q in queue:
            temp = queue.copy()
            temp.remove(q)
            possibility.append(sheepwolf(q, temp, sheep, wolf))

        return max(possibility) if possibility else sheep
    return sheepwolf(0, [], 0, 0)