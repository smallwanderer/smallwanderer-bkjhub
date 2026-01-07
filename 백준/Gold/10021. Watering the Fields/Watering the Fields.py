def list_prim_watering_the_fields(start=0):
    N, C = map(int, input().split())
    points = [tuple(map(int, input().split())) for _ in range(N)]

    INF = float('inf')
    distance = [INF] * N
    visited = [False] * N

    distance[0] = 0
    mst_weight = 0
    for _ in range(N):
        current, best = -1, INF
        for i in range(N):
            if not visited[i] and distance[i] < best:
                current, best = i, distance[i]
        
        # 종료조건: 더이상 current가 갱신되지 않았음
        if current == -1:
            return -1
        
        # MST에 현재노드 추가
        visited[current] = True
        mst_weight += best

        # 거리 갱신: currnet를 기준으로 모든 미방문 접점들에 대해 최소 weight 갱신
        for j in range(N):
            if not visited[j]:
                x, y = points[current]
                u, v = points[j]
                a, b = abs(x-u), abs(y-v)
                weight = a*a + b*b
                if weight >= C:
                    distance[j] = min(distance[j], weight)
        
    return mst_weight

result = list_prim_watering_the_fields()
print(result)
    