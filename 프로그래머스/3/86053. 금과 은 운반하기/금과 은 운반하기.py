
def solution(a, b, g, s, w, t):
    # Binary Search
    left = 0
    # 탐색 최대는, 한 도시가 max일에 왕복 min(kg)씩 옮겨서 뺑이치는 것
    right = (a + b) * (max(t) * 2) // min(w)
    
    while (left < right):
        mid = (left + right) // 2
        
        if deliver(mid, a, b, g, s, w, t):
            right = mid
        else:
            left = mid + 1
    
    return left

def deliver(time, a, b, g, s, w, t):
    N = len(g)
    print(time)

    extreme = [[0, 0, 0] for _ in range(N)] # 도시[i]의 [gold, silver, cap]
    for i in range(N):
        travel = time // (2 * t[i])
        travel += time // t[i] % 2 != 0

        cap = w[i] * travel
        extreme[i] = [min(g[i], cap), min(s[i], cap), min(g[i] + s[i], cap)]

    condition = [a, b, a+b]
    minkowski = [sum(p[i] for p in extreme) >= condition[i] for i in range(3)]
    
    return all(minkowski)
